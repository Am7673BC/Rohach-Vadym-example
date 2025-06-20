/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.ui.common.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Spacing
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom.CustomTheme
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.custom.customTextFieldColors

/**
 * Custom password input field that requires task to create
 * @param modifier - can be customized while using this view
 * @param password - current password
 * @param placeHolder - placeholder for input
 * @param label - label for input
 * @param validPasswordText - text that will be shown if password is valid
 * @param optional - is password optional
 * @param isError - is password invalid
 * @param padding - padding for input
 * @param errorTextSpacer - space between input view and list of broken requirements
 * @param errorText - list of broken requirements
 * @param onPasswordChanged - callback when password changed
 */
@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String,
    placeHolder: String = "Placeholder",
    label: String = "Input",
    validPasswordText: String = "Password accepted",
    optional: Boolean = true,
    isError: Boolean = false,
    padding: Dp = Spacing.m,
    errorTextSpacer: Dp = Spacing.xs,
    errorText: List<String> = emptyList(),
    onPasswordChanged: (String) -> Unit,
) {
    val textColor =
        if (isError) CustomTheme.colors.contentOnNeutralDanger else CustomTheme.colors.contentOnNeutralXXHigh

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Column(
        modifier = modifier
            .width(400.dp)
            .padding(padding), horizontalAlignment = Alignment.Start
    ) {

        Row(modifier = Modifier.height(22.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(label, color = textColor, style = CustomTheme.typography.LabelM)
            if (optional) {
                Spacer(modifier = Modifier.width(Spacing.xs))
                Text("Optional", style = CustomTheme.typography.LabelS)
            }
        }
        Spacer(modifier.height(4.dp))
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChanged,
            colors = customTextFieldColors(),
            isError = isError,
            interactionSource = interactionSource,
            singleLine = true,
            shape = CustomTheme.shapes.radiusInput,
            textStyle = CustomTheme.typography.BodyM.copy(color = textColor),
            placeholder = {
                Text(text = placeHolder, style = CustomTheme.typography.BodyM)
            }

        )
        Spacer(modifier.height(errorTextSpacer))
        if (isFocused) {
            errorText.forEach {
                Text(
                    text = it,
                    color = CustomTheme.colors.contentOnNeutralDanger,
                    style = CustomTheme.typography.BodyM
                )
            }
            if (!isError) {
                Text(
                    text = validPasswordText,
                    color = CustomTheme.colors.contentOnNeutralXXHigh,
                    style = CustomTheme.typography.BodyM
                )
            }
        }
    }
}