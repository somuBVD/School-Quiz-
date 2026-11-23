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
