const { describe, it, before, after, beforeEach } = require('node:test');
const { readFileSync } = require('node:fs');
const {
  initializeTestEnvironment,
  assertSucceeds,
  assertFails,
} = require('@firebase/rules-unit-testing');

const PROJECT_ID = 'gen-lang-client-0355863001';
const DB_ID = 'ai-studio-android-schoolqu-946b294d-d922-4149-9cfc-c857c917e1b7';

let testEnv;

function dbFor(uid, token = {}) {
  const ctx = uid ? testEnv.authenticatedContext(uid, token) : testEnv.unauthenticatedContext();
  return ctx.firestore(DB_ID);
}

function nowTimestamp() {
  return new Date(Date.now() - 1000);
}

before(async () => {
  testEnv = await initializeTestEnvironment({
    projectId: PROJECT_ID,
    firestore: {
      host: '127.0.0.1',
      port: 8085,
      rules: readFileSync('firestore.rules', 'utf8'),
    },
  });
});

after(async () => {
  await testEnv?.cleanup();
});

beforeEach(async () => {
  await testEnv.clearFirestore();
});

describe('School Quiz Firestore Rules — Users & Trial/Subscription Isolation', () => {
  it('denies unauthenticated reads and writes across all collections', async () => {
    const anonDb = dbFor(null);
    await assertFails(anonDb.collection('users').doc('alice').get());
    await assertFails(anonDb.collection('users').doc('alice').set({ uid: 'alice' }));
    await assertFails(anonDb.collection('battle_rooms').doc('room1').get());
    await assertFails(anonDb.collection('questions').doc('q1').get());
  });

  it('allows owner to create and update their own user doc with trial & subscription fields, but denies cross-user access and admin escalation', async () => {
    const aliceDb = dbFor('alice', { email: 'alice@school.edu', email_verified: true });
    const bobDb = dbFor('bob', { email: 'bob@school.edu', email_verified: true });

    await assertSucceeds(
      aliceDb.collection('users').doc('alice').set({
        uid: 'alice',
        email: 'alice@school.edu',
        displayName: 'Alice',
        role: 'STUDENT',
        standard: 8,
        trialStartMillis: Date.now(),
        subscriptionActive: false,
        subscriptionProductId: 'school_quiz_monthly_20',
        createdAt: nowTimestamp(),
        updatedAt: nowTimestamp(),
      })
    );

    await assertSucceeds(aliceDb.collection('users').doc('alice').get());
    await assertFails(bobDb.collection('users').doc('alice').get());
    await assertFails(
      bobDb.collection('users').doc('alice').update({ subscriptionActive: true })
    );

    // Owner cannot self-escalate to ADMIN
    await assertFails(
      aliceDb.collection('users').doc('alice').update({ role: 'ADMIN' })
    );

    // Owner can update subscriptionActive after Google Play purchase
    await assertSucceeds(
      aliceDb.collection('users').doc('alice').update({
        subscriptionActive: true,
        subscriptionAutoRenewing: true,
        updatedAt: nowTimestamp(),
      })
    );
  });
});

describe('School Quiz Firestore Rules — 1 vs 1 Battle Arena', () => {
  const samplePlayer1 = {
    uid: 'student_host',
    name: 'Aarav',
    school: 'Karnataka State Board',
    avatar: 'avatar_1',
    standard: 8,
    score: 0,
    currentAnswer: '',
    streak: 0,
    answeredAt: 0,
  };

  const samplePlayer2 = {
    uid: 'student_guest',
    name: 'Diya',
    school: 'Karnataka State Board',
    avatar: 'avatar_2',
    standard: 8,
    score: 0,
    currentAnswer: '',
    streak: 0,
    answeredAt: 0,
  };

  function makeRoomPayload(roomId, hostUid = 'student_host', isPrivate = false) {
    return {
      roomId,
      roomCode: '654321',
      hostUid,
      participantUids: [hostUid],
      isPrivate,
      subject: 'math',
      standard: 8,
      status: 'WAITING',
      currentRound: 0,
      roundStartTime: 0,
      createdAt: nowTimestamp(),
      updatedAt: nowTimestamp(),
      questions: [],
      player1: { ...samplePlayer1, uid: hostUid },
    };
  }

  it('allows host to create a room, another student to discover & join it, and both participants to play while blocking outsiders and post-completion edits', async () => {
    const hostDb = dbFor('student_host');
    const joinerDb = dbFor('student_guest');
    const outsiderDb = dbFor('student_outsider');

    // Host cannot spoof another user as hostUid
    await assertFails(
      hostDb.collection('battle_rooms').doc('room_spoof').set(makeRoomPayload('room_spoof', 'someone_else'))
    );

    // Host creates a valid public WAITING room
    await assertSucceeds(
      hostDb.collection('battle_rooms').doc('room_1').set(makeRoomPayload('room_1', 'student_host', false))
    );

    // Another authenticated student can query open WAITING rooms (mirrors RealOnlineBattleManager.findOrCreateMatch)
    await assertSucceeds(
      joinerDb.collection('battle_rooms')
        .where('status', '==', 'WAITING')
        .where('isPrivate', '==', false)
        .where('standard', '==', 8)
        .get()
    );

    // Another student can query by roomCode + WAITING (mirrors RealOnlineBattleManager.joinByRoomCode)
    await assertSucceeds(
      joinerDb.collection('battle_rooms')
        .where('roomCode', '==', '654321')
        .where('status', '==', 'WAITING')
        .get()
    );

    // Joiner atomically joins the WAITING room as player2
    await assertSucceeds(
      joinerDb.collection('battle_rooms').doc('room_1').update({
        player2: samplePlayer2,
        player2Uid: 'student_guest',
        participantUids: ['student_host', 'student_guest'],
        status: 'IN_PROGRESS',
        roundStartTime: Date.now(),
        updatedAt: nowTimestamp(),
      })
    );

    // Outsider cannot modify an IN_PROGRESS room
    await assertFails(
      outsiderDb.collection('battle_rooms').doc('room_1').update({
        'player2.score': 999,
        updatedAt: nowTimestamp(),
      })
    );

    // Player 2 submits answer
    await assertSucceeds(
      joinerDb.collection('battle_rooms').doc('room_1').update({
        'player2.currentAnswer': '42',
        'player2.answeredAt': Date.now(),
        updatedAt: nowTimestamp(),
      })
    );

    // Host reveals round & completes game
    await assertSucceeds(
      hostDb.collection('battle_rooms').doc('room_1').update({
        status: 'COMPLETED',
        currentRound: 5,
        winnerUid: 'student_host',
        updatedAt: nowTimestamp(),
      })
    );

    // Terminal state lock: even host cannot mutate a COMPLETED room
    await assertFails(
      hostDb.collection('battle_rooms').doc('room_1').update({
        status: 'IN_PROGRESS',
        updatedAt: nowTimestamp(),
      })
    );

    // Non-admin cannot delete an active/completed room
    await assertFails(hostDb.collection('battle_rooms').doc('room_1').delete());
  });
});

describe('School Quiz Firestore Rules — Questions & Admin Privileges', () => {
  it('allows authenticated students to read questions, blocks students from writing, and allows bootstrapped admin to write', async () => {
    const studentDb = dbFor('student_1', { email: 'student@school.edu', email_verified: true });
    const adminDb = dbFor('admin_uid', { email: 'somas211@gmail.com', email_verified: true });

    const qPayload = {
      id: 'q_math_1',
      stdId: 8,
      subjectId: 'math',
      unitId: 1,
      type: 'MCQ',
      questionText: 'What is 7 x 8?',
      options: ['54', '56', '58', '64'],
      correctAnswer: '56',
    };

    await assertFails(studentDb.collection('questions').doc('q_math_1').set(qPayload));
    await assertSucceeds(adminDb.collection('questions').doc('q_math_1').set(qPayload));
    await assertSucceeds(studentDb.collection('questions').doc('q_math_1').get());
  });
});

describe('School Quiz Firestore Rules — Global Leaderboard (Top 10 by XP)', () => {
  it('denies unauthenticated reads/writes, enforces ownership & schema integrity, and permits Kotlin Top-10 XP query', async () => {
    const anonDb = dbFor(null);
    const aliceDb = dbFor('alice_uid', { email: 'alice@school.edu', email_verified: true });
    const bobDb = dbFor('bob_uid', { email: 'bob@school.edu', email_verified: true });

    const aliceEntry = {
      uid: 'alice_uid',
      displayName: 'Alice Star',
      standard: 8,
      avatar: 'avatar_astro_explorer',
      xp: 1850,
      stars: 42,
      attendanceStreak: 7,
      updatedAt: nowTimestamp(),
    };

    const bobEntry = {
      uid: 'bob_uid',
      displayName: 'Bob Genius',
      standard: 10,
      avatar: 'avatar_math_wizard',
      xp: 2600,
      stars: 64,
      attendanceStreak: 12,
      updatedAt: nowTimestamp(),
    };

    // Unauthenticated access denied
    await assertFails(
      anonDb.collection('global_leaderboard')
        .where('xp', '>=', 0)
        .orderBy('xp', 'desc')
        .limit(10)
        .get()
    );
    await assertFails(anonDb.collection('global_leaderboard').doc('alice_uid').set(aliceEntry));

    // Owner creates valid PII-free leaderboard entry (exact Kotlin payload)
    await assertSucceeds(aliceDb.collection('global_leaderboard').doc('alice_uid').set(aliceEntry));
    await assertSucceeds(bobDb.collection('global_leaderboard').doc('bob_uid').set(bobEntry));

    // Cross-user write/update denied
    await assertFails(
      aliceDb.collection('global_leaderboard').doc('bob_uid').update({
        xp: 0,
        updatedAt: nowTimestamp(),
      })
    );

    // Shadow/ghost field injection (PII leak attempt) denied
    await assertFails(
      aliceDb.collection('global_leaderboard').doc('alice_uid').set({
        ...aliceEntry,
        email: 'leak@school.edu',
      })
    );

    // Negative XP, invalid standard, and tampered future timestamp denied
    await assertFails(
      aliceDb.collection('global_leaderboard').doc('alice_uid').update({
        xp: -10,
        updatedAt: nowTimestamp(),
      })
    );
    await assertFails(
      aliceDb.collection('global_leaderboard').doc('alice_uid').update({
        xp: 1950,
        updatedAt: new Date(Date.now() + 60000),
      })
    );

    // Valid owner update succeeds
    await assertSucceeds(
      aliceDb.collection('global_leaderboard').doc('alice_uid').update({
        xp: 2100,
        stars: 50,
        updatedAt: nowTimestamp(),
      })
    );

    // Unfiltered list query without xp >= 0 constraint fails (Query Trust Test)
    await assertFails(aliceDb.collection('global_leaderboard').get());

    // Exact Kotlin repository Top-10 XP query succeeds and returns Bob (2600) ahead of Alice (2100)
    const snap = await assertSucceeds(
      aliceDb.collection('global_leaderboard')
        .where('xp', '>=', 0)
        .orderBy('xp', 'desc')
        .limit(10)
        .get()
    );
    if (snap.docs.length !== 2 || snap.docs[0].data().uid !== 'bob_uid' || snap.docs[1].data().uid !== 'alice_uid') {
      throw new Error(`Expected ordered [bob_uid, alice_uid], got ${snap.docs.map(d => d.data().uid)}`);
    }
  });
});

describe('School Quiz Firestore Rules — KPSC Study Materials', () => {
  function makeKpscMaterialPayload(overrides = {}) {
    return {
      subjectId: 'kpsc_kannada',
      unitId: 1,
      unitName: 'ಸಾಮಾನ್ಯ ಕನ್ನಡ - ಸಾಹಿತ್ಯ',
      title: 'KPSC General Kannada Core Notes & MCQs',
      summary: 'Key Kannada literature and vocabulary notes for KAS/FDA/SDA.',
      contentMarkdown: '## ಸಾಮಾನ್ಯ ಕನ್ನಡ\n- ಪ್ರಮುಖ ಕವಿಗಳು ಮತ್ತು ಕೃತಿಗಳು',
      language: 'kn',
      difficulty: 'Medium',
      examTags: ['KAS', 'FDA', 'SDA'],
      questions: [
        {
          id: 'kpsc_remote_kn_1',
          unitId: 1,
          type: 'MCQ',
          questionText: 'ಕನ್ನಡದ ಆದಿಕವಿ ಯಾರು?',
          options: ['ಪಂಪ', 'ರನ್ನ', 'ಪೊನ್ನ', 'ಕುಮಾರವ್ಯಾಸ'],
          correctAnswer: 'ಪಂಪ',
          explanation: 'ಪಂಪನನ್ನು ಕನ್ನಡದ ಆದಿಕವಿ ಎಂದು ಕರೆಯುತ್ತಾರೆ.',
        },
      ],
      contentVersion: 1,
      published: true,
      createdAt: nowTimestamp(),
      updatedAt: nowTimestamp(),
      ...overrides,
    };
  }

  it('denies unauthenticated access and blocks students from writing KPSC study materials', async () => {
    const anonDb = dbFor(null);
    const studentDb = dbFor('student_kpsc', { email: 'student@school.edu', email_verified: true });
    const adminDb = dbFor('admin_uid', { email: 'somas211@gmail.com', email_verified: true });

    const payload = makeKpscMaterialPayload();

    await assertFails(anonDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').set(payload));
    await assertFails(anonDb.collection('kpsc_study_materials').where('published', '==', true).get());
    await assertFails(studentDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').set(payload));

    // Bootstrapped admin creates a valid published KPSC study material
    await assertSucceeds(adminDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').set(payload));

    // Student cannot update or delete it
    await assertFails(
      studentDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').update({
        contentVersion: 2,
        updatedAt: nowTimestamp(),
      })
    );
    await assertFails(studentDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').delete());
  });

  it('enforces schema validation, rejects ghost id/future timestamps/mutated createdAt, and verifies Kotlin sync queries', async () => {
    const studentDb = dbFor('student_kpsc', { email: 'student@school.edu', email_verified: true });
    const adminDb = dbFor('admin_uid', { email: 'somas211@gmail.com', email_verified: true });

    const initialCreatedAt = new Date(Date.now() - 10000);
    const validDoc = makeKpscMaterialPayload({ createdAt: initialCreatedAt });

    // Reject invalid subjectId
    await assertFails(
      adminDb.collection('kpsc_study_materials').doc('bad_subject').set(
        makeKpscMaterialPayload({ subjectId: 'unknown_subject' })
      )
    );

    // Reject ghost 'id' field in document body (Kotlin uses @DocumentId)
    await assertFails(
      adminDb.collection('kpsc_study_materials').doc('ghost_id').set({
        ...validDoc,
        id: 'ghost_id',
      })
    );

    // Reject future updatedAt timestamp
    await assertFails(
      adminDb.collection('kpsc_study_materials').doc('future_ts').set(
        makeKpscMaterialPayload({ updatedAt: new Date(Date.now() + 60000) })
      )
    );

    // Create published Kannada material and unpublished draft Computer material
    await assertSucceeds(adminDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').set(validDoc));
    await assertSucceeds(
      adminDb.collection('kpsc_study_materials').doc('kpsc_comp_draft').set(
        makeKpscMaterialPayload({
          subjectId: 'kpsc_computer',
          unitId: 2,
          unitName: 'ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ',
          title: 'Draft Computer Basics Notes',
          published: false,
        })
      )
    );

    // Admin cannot mutate createdAt during update
    await assertFails(
      adminDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').update({
        createdAt: nowTimestamp(),
        updatedAt: nowTimestamp(),
      })
    );

    // Valid partial update preserving createdAt succeeds
    await assertSucceeds(
      adminDb.collection('kpsc_study_materials').doc('kpsc_kn_u1').update({
        contentVersion: 2,
        summary: 'Updated KPSC General Kannada summary for 2026 exam cycle.',
        updatedAt: nowTimestamp(),
      })
    );

    // Student cannot read unpublished draft via direct get
    await assertFails(studentDb.collection('kpsc_study_materials').doc('kpsc_comp_draft').get());

    // Student unfiltered list query fails (Query Trust Test)
    await assertFails(studentDb.collection('kpsc_study_materials').get());

    // Student filtered Kotlin sync queries succeed
    const allPublished = await assertSucceeds(
      studentDb.collection('kpsc_study_materials').where('published', '==', true).get()
    );
    if (allPublished.docs.length !== 1 || allPublished.docs[0].id !== 'kpsc_kn_u1') {
      throw new Error(`Expected 1 published KPSC doc [kpsc_kn_u1], got ${allPublished.docs.map(d => d.id)}`);
    }

    const kannadaPublished = await assertSucceeds(
      studentDb.collection('kpsc_study_materials')
        .where('published', '==', true)
        .where('subjectId', '==', 'kpsc_kannada')
        .get()
    );
    if (kannadaPublished.docs.length !== 1) {
      throw new Error(`Expected 1 kpsc_kannada doc, got ${kannadaPublished.docs.length}`);
    }
  });
});


