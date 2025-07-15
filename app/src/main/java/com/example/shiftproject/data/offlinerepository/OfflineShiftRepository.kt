package com.example.shiftproject.data.offlinerepository

import com.example.shiftproject.data.ShiftDao
import com.example.shiftproject.data.UsersApiService
import com.example.shiftproject.data.datasource.ShiftRepository
import com.example.shiftproject.data.model.User
import com.example.shiftproject.data.toEntity

class OfflineShiftRepository(
    private val shiftDao: ShiftDao,
    private val usersApiService: UsersApiService,
) : ShiftRepository {

    override suspend fun getNewUserList(): List<User> {
        if (getUserList().isNotEmpty()) {
            shiftDao.deleteAllUsers()
        }
        val users = usersApiService.getUsers(10).results.map { it.toEntity() }
        shiftDao.addUsers(users)
        return users
    }

    override suspend fun searchUser(userName: String, userLastName: String): User {
        return shiftDao.searchUser(userName, userLastName)
    }

    override suspend fun getUserList(): List<User> {
        return shiftDao.getUsers()
    }
}
