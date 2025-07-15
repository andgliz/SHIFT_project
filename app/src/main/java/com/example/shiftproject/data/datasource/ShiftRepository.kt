package com.example.shiftproject.data.datasource

import com.example.shiftproject.data.model.User

interface ShiftRepository {
    suspend fun getNewUserList(): List<User>

    suspend fun searchUser(userName: String, userLastName: String): User

    suspend fun getUserList(): List<User>
}
