/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.feature.main_screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions.collectCommandAsState
import com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions.collectStateAsState
import com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions.sendEvent
import com.droidhen.o2testtasksolutionbyrohachvadym.core.ViewEvent
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.common.components.PasswordInput
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.Spacing
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinViewModel()
){
    val context = LocalContext.current
    val viewState = viewModel.collectStateAsState()
    val commandState = viewModel.collectCommandAsState()

    LaunchedEffect(commandState){
        when (commandState){
            MainViewModel.Command.PasswordAccepted -> {
                Toast.makeText(context, "Password accepted", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    MainScreen(viewState) { password ->
        viewModel.sendEvent(Event.EnteredPassword(password))
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun MainScreen(viewState: MainViewModel.State, onPasswordChanged: (String) -> Unit, ){
    val password =  mutableStateOf(viewState.password)

    Spacer(modifier = Modifier.height(Spacing.l))
    Box(Modifier.fillMaxSize().padding(Spacing.m), contentAlignment = Alignment.Center){
            PasswordInput(password = password.value, onPasswordChanged = onPasswordChanged, isError = viewState.isPasswordInvalid, errorText = viewState.listOfBrokenRequirements)
    }
}

internal sealed class Event: ViewEvent {
    class EnteredPassword(val value: String): Event()
}