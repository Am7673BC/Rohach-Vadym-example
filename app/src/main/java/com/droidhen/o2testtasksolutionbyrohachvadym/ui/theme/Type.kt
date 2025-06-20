/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.droidhen.o2testtasksolutionbyrohachvadym.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val InterFont = FontFamily(
    Font(R.font.inter)
)

@Immutable
data class CustomTypography(
    val LabelM: TextStyle = TextStyle(
        fontFamily = InterFont ,
        fontWeight = LabelMWeight,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.16.sp
    ),
    val LabelS: TextStyle = TextStyle(
        fontFamily = InterFont,
        fontWeight = LabelSWeight,
        fontSize = 14.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.16.sp
    ),
    val BodyM: TextStyle = TextStyle(
        fontFamily = InterFont,
        fontWeight = BodyMWeight,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.01.sp,
    ),
)