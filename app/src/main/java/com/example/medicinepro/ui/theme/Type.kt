package com.example.medicinepro.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.medicinepro.R

val interFont = FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_black, FontWeight.Black),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_regular, FontWeight.Normal)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.Thin,
        fontSize = 32.sp
    ),
    titleMedium = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    titleSmall = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    displayLarge = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    displayMedium = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    displaySmall = TextStyle(
        fontFamily = interFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )

)