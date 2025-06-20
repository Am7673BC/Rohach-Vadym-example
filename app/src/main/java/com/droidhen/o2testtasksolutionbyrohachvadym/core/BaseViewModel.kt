/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE : ViewState, COMMAND : ViewCommand>(
    val initialState: STATE
) : ViewModel() {

    // --- Internal state ---
    private val _stateFlow = MutableStateFlow(initialState)
    val stateFlow: Flow<STATE> = _stateFlow.asStateFlow()

    private val _commandFlow = MutableSharedFlow<COMMAND?>()
    val commandFlow: Flow<COMMAND?> = _commandFlow.asSharedFlow()

    val eventChannel: Channel<ViewEvent> = Channel(Channel.UNLIMITED)

    init {
        observeEvents()
    }

    // --- Public/state mutation API ---

    /**
     * Updates the current view state using a reducer lambda.
     */
    protected fun updateState(reducer: STATE.() -> STATE) {
        synchronized(_stateFlow) {
            _stateFlow.update { it.reducer() }
        }
    }

    /**
     * Returns the current view state.
     */
    protected fun currentState(): STATE {
        return synchronized(_stateFlow) {
            _stateFlow.value
        }
    }

    /**
     * Emits a one-time command to be observed by the view layer.
     */
    protected fun sendCommand(command: COMMAND) {
        viewModelScope.launch {
            _commandFlow.emit(command)
        }
    }

    /**
     * Override to handle a UI event dispatched from the view layer.
     */
    protected open fun onEvent(event: ViewEvent) = Unit

    // --- Internal flow handling ---

    private fun observeEvents() {
        viewModelScope.launch(Dispatchers.IO) {
            eventChannel
                .consumeAsFlow()
                .collect { event -> onEvent(event) }
        }
    }
}
