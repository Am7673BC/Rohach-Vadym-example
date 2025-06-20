/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/
package com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Blue500
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Dim50
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Dim800
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Gray00
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Gray300
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Gray500
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Gray950
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Red100
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Red600
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Red700
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Yellow100
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Yellow700

@Immutable
data class CustomColorScheme(
    val surfaceXHigh: Color,
    val surfaceXLow: Color,
    val surfaceBrand: Color,
    val surfaceDanger: Color,
    val surfaceDangerVariant: Color,
    val surfaceWarning: Color,
    val surfaceWarningVariant: Color,
    val contentOnNeutralXXHigh: Color,
    val contentOnNeutralMedium: Color,
    val contentOnNeutralLow: Color,
    val contentOnNeutralDanger: Color,
    val contentOnNeutralWarning: Color,
    val stateDefaultHover: Color,
    val stateDefaultFocus: Color
)

/**
 * Light theme colors
 */
 val LightColorScheme = CustomColorScheme(
    surfaceXHigh = Gray500,
    surfaceXLow = Gray00,
    surfaceBrand = Blue500,
    surfaceDanger = Red600,
    surfaceDangerVariant = Red100,
    surfaceWarning = Yellow700,
    surfaceWarningVariant = Yellow100,
    contentOnNeutralXXHigh = Gray950,
    contentOnNeutralMedium = Gray500,
    contentOnNeutralLow = Gray300,
    contentOnNeutralDanger = Red600,
    contentOnNeutralWarning = Red700,
    stateDefaultHover = Dim50,
    stateDefaultFocus = Dim800
)

/**
 * Dark theme colors
 */
 val DarkColorScheme = CustomColorScheme(
    surfaceXHigh = Gray500,
    surfaceXLow = Gray00,
    surfaceBrand = Blue500,
    surfaceDanger = Red600,
    surfaceDangerVariant = Red100,
    surfaceWarning = Yellow700,
    surfaceWarningVariant = Yellow100,
    contentOnNeutralXXHigh = Gray950,
    contentOnNeutralMedium = Gray500,
    contentOnNeutralLow = Gray300,
    contentOnNeutralDanger = Red600,
    contentOnNeutralWarning = Red700,
    stateDefaultHover = Dim50,
    stateDefaultFocus = Dim800
)
