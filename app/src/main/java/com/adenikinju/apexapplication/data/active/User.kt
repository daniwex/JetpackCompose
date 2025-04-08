package com.adenikinju.apexapplication.data.active

import com.adenikinju.apexapplication.R

object User {

    val currentUser = UserData(
        name = "Cate",
        profilePic = R.drawable.userprofile
    )
}

data class UserData(val name: String, val profilePic: Int)