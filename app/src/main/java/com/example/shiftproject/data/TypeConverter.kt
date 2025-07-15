package com.example.shiftproject.data

import com.example.shiftproject.data.model.User
import com.example.shiftproject.data.model.UserSer

fun UserSer.toEntity(): User = User(
    id = this.login.uuid,
    gender = this.gender,
    name = this.name.first,
    lastName = this.name.last,
    pictureUrl = this.picture.large,
    nationality = this.nat,
    address = "${this.location.street.name} ${this.location.street.number}",
    phoneNumber = this.phone,
    date = this.dob.date,
    age = this.dob.age,
    location = "${this.location.country}, ${this.location.state}, ${this.location.city}"
)