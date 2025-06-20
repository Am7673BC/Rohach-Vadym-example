/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/
package com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom

import androidx.compose.runtime.Composable
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.CustomTypography
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.localCustomColors
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.localCustomShapes
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.localCustomTypography

object CustomTheme {
    val colors: CustomColorScheme
        @Composable
        get() = localCustomColors.current
    val shapes: CustomShapes
        @Composable
        get() = localCustomShapes.current
    val typography: CustomTypography
        @Composable
        get() = localCustomTypography.current
}