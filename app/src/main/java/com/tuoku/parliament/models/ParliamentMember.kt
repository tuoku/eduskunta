package com.tuoku.parliament.models

data class ParliamentMember(
    val hetekaId: Int,
    val seatNumber: Int = 0,
    var lastname: String,
    var firstname: String,
    var fullname: String = "$firstname $lastname",
    var party: String,
    val minister: Boolean = false,
    val pictureUrl: String = ""
)
