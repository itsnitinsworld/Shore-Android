package com.theshoremedia.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theshoremedia.database.entity.FactCheckHistoryModel

/**
 * @author- Nitin Khanna
 * @date -
 */

@Dao
interface FactCheckHistoryDio {
    @get:Query("SELECT * FROM tableFactChecksHistory")
    val all: LiveData<List<FactCheckHistoryModel>?>

    @Query("SELECT * FROM tableFactChecksHistory WHERE isFavourite = (:isFav)")
    fun getFavouriteNews(isFav: Boolean? = true): List<FactCheckHistoryModel>?

    @Query("SELECT * FROM tableFactChecksHistory WHERE isFavourite = (:isRead)")
    fun getUnreadNews(isRead: Boolean? = false): List<FactCheckHistoryModel>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(tableFactChecksHistoryModel: List<FactCheckHistoryModel?>?): Array<Long?>?

    @Delete
    fun delete(tableFactChecksHistoryModel: List<FactCheckHistoryModel>?)

    @Query("DELETE FROM tableFactChecksHistory")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNew(tableFactChecksHistoryModel: FactCheckHistoryModel)

    @Update
    fun markedAsFav(tableFactChecksHistoryModel: FactCheckHistoryModel)
}