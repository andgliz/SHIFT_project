package com.example.shiftproject.domain

data class User(
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
