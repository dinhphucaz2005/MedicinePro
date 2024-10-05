package com.example.medicinepro.ui.screen.navigation

import androidx.annotation.DrawableRes
import com.example.medicinepro.R

enum class Routes(
    @DrawableRes val icon: Int? = null,
    @DrawableRes val selectedIcon: Int? = null
) {
    AUTHENTICATION,
    LOGIN,
    REGISTER,
    FORGET,
    MAIN,
    HOME(R.drawable.ic_home, R.drawable.ic_home_selected),
    LOCATION(R.drawable.ic_location, R.drawable.ic_location_selected),
    DATE(R.drawable.ic_calendar, R.drawable.ic_calendar_selected),
    USER(R.drawable.ic_person, R.drawable.ic_person_selected)
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