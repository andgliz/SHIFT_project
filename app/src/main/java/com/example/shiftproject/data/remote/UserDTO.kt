package com.example.shiftproject.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class Results(
    val results: List<UserDTO>,
)

@Serializable
data class UserDTO(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val phone: String,
    val cell: String,
    val picture: Picture,
    val nat: String,
    val dob: Dob,
)

@Serializable
data class Name(
    val title: String,
    val first: String,
    val last: String,
)

@Serializable
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
)

@Serializable
data class Street(
    val number: Int,
    val name: String,
)

@Serializable
data class Login(
    val uuid: String,
)

@Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

@Serializable
data class Dob(
    val date: String,
    val age: Int,
)
