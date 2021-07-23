package com.melikeey.shortlyapppsoixd.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg history: History)

    @Query("DELETE FROM history where id=:id")
    fun deleteById(id : Int)
}