package com.example.shiftproject.data.repository

import com.example.shiftproject.data.local.ShiftDao
import com.example.shiftproject.data.remote.UsersApiService
import com.example.shiftproject.data.local.UserEntity
import com.example.shiftproject.data.toDomain
import com.example.shiftproject.data.toEntity
import com.example.shiftproject.domain.ShiftRepository
import com.example.shiftproject.domain.User

class ShiftRepositoryImpl(
    private val shiftDao: ShiftDao,
    private val usersApiService: UsersApiService,
) : ShiftRepository {

    override suspend fun getNewUserList(): List<User> {
        if (getUserList().isNotEmpty()) {
            shiftDao.deleteAllUsers()
        }
        val users = usersApiService.getUsers(10).results.map { it.toEntity() }
        shiftDao.addUsers(users)
        return users.map { it.toDomain() }
    }

    override suspend fun searchUser(userName: String, userLastName: String): User {
        return shiftDao.searchUser(userName, userLastName).toDomain()
    }

    override suspend fun getUserList(): List<User> {
        return shiftDao.getUsers().map { it.toDomain() }
    }
}
