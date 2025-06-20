/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom.CustomColorScheme
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom.CustomShapes
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom.DarkColorScheme
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom.LightColorScheme


val localCustomColors =
    staticCompositionLocalOf<CustomColorScheme> { error("No CustomColorScheme provided") }


val localCustomShapes = staticCompositionLocalOf<CustomShapes> {
    error("No CustomShapes provided")
}

val localCustomTypography = staticCompositionLocalOf<CustomTypography> {
    error("No CustomTypography provided")
}

@Composable
fun O2TestTaskSolutionByRohachVadymTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val materialColorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    val customColors = if (darkTheme) DarkColorScheme else LightColorScheme
    val customTypography = CustomTypography()
    val customShapes = CustomShapes()

    CompositionLocalProvider(
        localCustomColors provides customColors,
        localCustomShapes provides customShapes,
        localCustomTypography provides customTypography,
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = Typography,
            content = {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        content()
                    }
                }
            }
        )
    }
}