package com.example.medicinepro.ui.screen.navigation

import androidx.annotation.DrawableRes
import com.example.medicinepro.R

enum class Routes(
    @DrawableRes val icon: Int? = null,
) {
    AUTHENTICATION,
        LOGIN,
        REGISTER,
        FORGET,
    MAIN,
        HOME(R.drawable.ic_home),
        LOCATION(R.drawable.ic_location),
        DATE(R.drawable.ic_calendar),
        USER(R.drawable.ic_person)
}
/*
    AUTHENTICATION,
        LOGIN,
        REGISTER,
        FORGET,
    MAIN,
        HOME,
        LOCATION,
        DATE,
        USER
 */