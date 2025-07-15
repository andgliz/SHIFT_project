package com.example.shiftproject.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Results(
    val results: List<UserSer>,
)

@Serializable
data class UserSer(
    val gender: String,
    val name: NameSer,
    val location: LocationSer,
    val email: String,
    val login: LoginSer,
    val phone: String,
    val cell: String,
    val picture: PictureSer,
    val nat: String,
    val dob: DobSer,
)

@Serializable
data class NameSer(
    val title: String,
    val first: String,
    val last: String,
)

@Serializable
data class LocationSer(
    val street: StreetSer,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
)

@Serializable
data class StreetSer(
    val number: Int,
    val name: String,
)

@Serializable
data class LoginSer(
    val uuid: String
)

@Serializable
data class PictureSer(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

@Serializable
data class DobSer(
    val date: String,
    val age: Int,
)
