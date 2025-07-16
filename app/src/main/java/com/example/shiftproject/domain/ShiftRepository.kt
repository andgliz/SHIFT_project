package com.example.shiftproject.domain

interface ShiftRepository {
    suspend fun getNewUserList(): List<User>

    suspend fun searchUser(userName: String, userLastName: String): User

    suspend fun getUserList(): List<User>
}
