/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/
package com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom

import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

@Composable
fun customTextFieldColors(): TextFieldColors {
    val custom = CustomTheme.colors

    val colors = TextFieldDefaults.colors(
        focusedTextColor = custom.contentOnNeutralXXHigh,
        unfocusedTextColor = custom.contentOnNeutralXXHigh,
        focusedContainerColor = custom.surfaceXLow,
        unfocusedIndicatorColor = custom.surfaceXHigh,
        errorContainerColor = custom.surfaceXLow,
        errorTextColor = custom.contentOnNeutralXXHigh,
        errorIndicatorColor = custom.surfaceDanger,
        cursorColor = custom.surfaceBrand,
        errorCursorColor = custom.surfaceBrand,
        focusedIndicatorColor = custom.surfaceXHigh,
        disabledIndicatorColor = custom.surfaceXHigh,
        unfocusedContainerColor = custom.surfaceXLow,
        unfocusedPlaceholderColor = custom.contentOnNeutralLow,
        focusedPlaceholderColor = custom.contentOnNeutralLow,
    )
    return colors
}