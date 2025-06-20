package com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions
/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
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
 * Collects command flow as state, triggering recomposition on each new value.
 */
@Composable
fun <STATE : ViewState, COMMAND : ViewCommand, VM : BaseViewModel<STATE, COMMAND>> VM.collectCommandAsState(
    initial: COMMAND? = null
): COMMAND? {
    return commandFlow.collectAsState(initial = initial).value
}

/**
 * Collects state flow with lifecycle awareness, returning current state as a Compose state.
 */
@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun <STATE : ViewState, COMMAND : ViewCommand, VM : BaseViewModel<STATE, COMMAND>> VM.collectStateAsState(
    initial: STATE = this.initialState
): STATE {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    return stateFlow
        .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
        .collectAsState(initial = initial)
        .value
}

/**
 * Dispatches UI event to the ViewModel's event channel using Default dispatcher.
 */
fun <VM : BaseViewModel<*, *>, EVENT : ViewEvent> VM.sendEvent(event: EVENT) {
    viewModelScope.launch(Dispatchers.Default) {
        eventChannel.send(event)
    }
}
