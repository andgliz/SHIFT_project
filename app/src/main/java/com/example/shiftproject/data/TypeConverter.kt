package com.example.shiftproject.data

import com.example.shiftproject.data.local.UserEntity
import com.example.shiftproject.data.remote.UserDTO
import com.example.shiftproject.domain.User

fun UserDTO.toEntity(): UserEntity = UserEntity(
    id = this.login.uuid,
    gender = this.gender,
    name = this.name.first,
    lastName = this.name.last,
    email = this.email,
    pictureUrl = this.picture.large,
    nationality = this.nat,
    address = "${this.location.street.name} ${this.location.street.number}",
    phoneNumber = this.phone,
    date = this.dob.date.substringBefore("T"),
    age = this.dob.age,
    location = "${this.location.country}, ${this.location.state}, ${this.location.city}",
)

fun UserEntity.toDomain(): User = User(
    gender = this.gender,
    name = this.name,
    lastName = this.lastName,
    email = this.email,
    pictureUrl = this.pictureUrl,
    nationality = this.nationality,
    address = this.address,
    phoneNumber = this.phoneNumber,
    date = this.date,
    age = this.age,
    location = this.location,
)