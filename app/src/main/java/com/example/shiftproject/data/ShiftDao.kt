package com.example.shiftproject.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shiftproject.data.model.User

@Dao
interface ShiftDao {
    @Query("SELECT * FROM user WHERE name = :userName AND lastName = :userLastName")
    suspend fun searchUser(userName: String, userLastName: String): User

    @Query("SELECT * FROM user")
    suspend fun getUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsers(users: List<User>)

    @Query("DELETE FROM user")
    suspend fun deleteAllUsers()
}
