package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Room DAO providing indexed offline access to synchronized KPSC study materials.
 */
@Dao
interface KpscStudyMaterialDao {

    @Query("SELECT * FROM kpsc_study_materials WHERE published = 1 ORDER BY subjectId ASC, unitId ASC")
    fun observePublishedMaterials(): Flow<List<KpscStudyMaterialEntity>>

    @Query("SELECT * FROM kpsc_study_materials WHERE published = 1 AND subjectId = :subjectId ORDER BY unitId ASC, updatedAtMillis DESC")
    fun observeMaterialsBySubject(subjectId: String): Flow<List<KpscStudyMaterialEntity>>

    @Query("SELECT * FROM kpsc_study_materials WHERE subjectId = :subjectId AND unitId = :unitId ORDER BY updatedAtMillis DESC")
    fun observeMaterialsByUnit(subjectId: String, unitId: Int): Flow<List<KpscStudyMaterialEntity>>

    @Query("SELECT COUNT(*) FROM kpsc_study_materials WHERE published = 1")
    fun observePublishedCount(): Flow<Int>

    @Query("SELECT MAX(lastSyncedAtMillis) FROM kpsc_study_materials")
    fun observeLastSyncedAt(): Flow<Long?>

    @Query("SELECT * FROM kpsc_study_materials WHERE id = :id LIMIT 1")
    suspend fun getMaterialById(id: String): KpscStudyMaterialEntity?

    @Query("SELECT * FROM kpsc_study_materials WHERE published = 1 ORDER BY subjectId ASC, unitId ASC")
    suspend fun getAllPublishedDirect(): List<KpscStudyMaterialEntity>

    @Query("SELECT COUNT(*) FROM kpsc_study_materials WHERE published = 1")
    suspend fun getPublishedCountDirect(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMaterial(material: KpscStudyMaterialEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMaterials(materials: List<KpscStudyMaterialEntity>)

    @Query("DELETE FROM kpsc_study_materials WHERE id = :id")
    suspend fun deleteById(id: String)

    @Query("DELETE FROM kpsc_study_materials")
    suspend fun clearAll()
}
