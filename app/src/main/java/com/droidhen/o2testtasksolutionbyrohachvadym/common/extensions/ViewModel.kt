package com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions
/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewModelScope
import com.droidhen.o2testtasksolutionbyrohachvadym.core.BaseViewModel
import com.droidhen.o2testtasksolutionbyrohachvadym.core.ViewCommand
import com.droidhen.o2testtasksolutionbyrohachvadym.core.ViewEvent
import com.droidhen.o2testtasksolutionbyrohachvadym.core.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Return command flow as a state value. This method has to be annotated as composable
 * because the method should be re-composed after each value change.
 */
@Composable
fun <STATE : ViewState, COMMAND : ViewCommand, VM : BaseViewModel<STATE, COMMAND>>
        VM.collectCommandAsState(initialState: COMMAND? = null) =
    commandFlow.collectAsState(initial = initialState).value

/**
 * Return state flow as a state value. This method has to be annotated as composable
 * because the method should be re-composed after each value change.
 */
@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun <STATE : ViewState, COMMAND : ViewCommand, VM : BaseViewModel<STATE, COMMAND>>
        VM.collectStateAsState(initialState: STATE = this.initialState) =
    stateFlow.flowWithLifecycle(LocalLifecycleOwner.current.lifecycle, Lifecycle.State.STARTED).collectAsState(initial = initialState).value

/**
 * Allows to send an UI event via VM default coroutine scope.
 */
fun <VM : BaseViewModel<*, *>, EVENT : ViewEvent> VM.sendEvent(
    event: EVENT
) {
    this.viewModelScope.launch(Dispatchers.Default) {
        this@sendEvent.eventChannel.send(event)
    }
}