package com.example.shiftproject.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: String = "",
    val gender: String = "",
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val pictureUrl: String = "",
    val nationality: String = "",
    val address: String = "",
    val phoneNumber: String = "",
    val date: String = "",
    val age: Int = 0,
    val location: String = "",
)
