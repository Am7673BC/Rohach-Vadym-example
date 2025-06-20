/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
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

abstract class BaseViewModel<STATE : ViewState, COMMAND : ViewCommand>(val initialState: STATE) :
    ViewModel() {
    private val _stateFlow = MutableStateFlow(initialState)

    /**
     * Contains current state of view
     */
    val stateFlow: Flow<STATE> = _stateFlow.asStateFlow()

    private val _commandFlow = MutableSharedFlow<COMMAND?>()

    /**
     * Contains a one-time event for view (command)
     */
    val commandFlow: Flow<COMMAND?> = _commandFlow.asSharedFlow()

    /**
     * A channel to handle events from view
     */
    val eventChannel = Channel<ViewEvent>(Channel.UNLIMITED)


    init {
        handleEvent()
    }

    /**
     * Updates view state with a new value.
     */
    protected fun updateState(body: STATE.() -> STATE) {
        synchronized(_stateFlow) {
            _stateFlow.update { body(_stateFlow.value) }
        }
    }

    /**
     * Gets the current view state.
     */
    protected fun currentState(): STATE {
        synchronized(_stateFlow) {
            return _stateFlow.value
        }
    }

    /**
     * Sends a command to the channel.
     */
    protected fun sendCommand(command: COMMAND) {
        viewModelScope.launch { _commandFlow.emit(command) }
    }

    /**
     * Handle a ViewModel specific event.
     */
    protected open fun onEvent(event: ViewEvent) {
    }

    private fun handleEvent() {
        viewModelScope.launch(Dispatchers.IO) {
            eventChannel.consumeAsFlow().collect { localEvent ->
                onEvent(localEvent)
            }
        }
    }
}