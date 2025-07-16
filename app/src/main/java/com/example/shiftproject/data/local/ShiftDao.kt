package com.example.shiftproject.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShiftDao {
    @Query("SELECT * FROM user WHERE name = :userName AND lastName = :userLastName")
    suspend fun searchUser(userName: String, userLastName: String): UserEntity

    @Query("SELECT * FROM user")
    suspend fun getUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsers(userEntities: List<UserEntity>)

    @Query("DELETE FROM user")
    suspend fun deleteAllUsers()
}
