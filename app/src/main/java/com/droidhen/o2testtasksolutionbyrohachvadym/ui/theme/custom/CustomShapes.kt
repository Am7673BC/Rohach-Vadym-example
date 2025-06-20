/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/
package com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.radiusInputDimension

@Immutable
data class CustomShapes(
    val radiusInput: Shape = RoundedCornerShape(radiusInputDimension),
    val sharp: Shape = RectangleShape
)