/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.feature.main_screen

import androidx.lifecycle.viewModelScope
import com.droidhen.o2testtasksolutionbyrohachvadym.core.BaseViewModel
import com.droidhen.o2testtasksolutionbyrohachvadym.core.ViewCommand
import com.droidhen.o2testtasksolutionbyrohachvadym.core.ViewEvent
import com.droidhen.o2testtasksolutionbyrohachvadym.core.ViewState
import com.droidhen.o2testtasksolutionbyrohachvadym.domain.password.CheckPasswordIncorrectnessUseCase
import com.droidhen.o2testtasksolutionbyrohachvadym.domain.password.GetIssuesListUseCase
import com.droidhen.o2testtasksolutionbyrohachvadym.feature.main_screen.Event.EnteredPassword
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPasswordIssuesUseCase: GetIssuesListUseCase,
    private val checkPasswordIncorrectnessUseCase: CheckPasswordIncorrectnessUseCase
) :
    BaseViewModel<MainViewModel.State, MainViewModel.Command>(
        initialState = State()
    ) {

    init {
        checkPassword(currentState().password)
    }

    override fun onEvent(event: ViewEvent) {
        when (event) {
            is EnteredPassword -> checkPassword(event.value)
        }
    }

    /**
     * Checks password and updates state
     * sends command to view if password correct
     * @param password: String - password to check
     */
    private fun checkPassword(password: String) {

        viewModelScope.launch(Dispatchers.IO) {

            val listOfIssues = getPasswordIssuesUseCase.invoke(password)
            val isPasswordInvalid = checkPasswordIncorrectnessUseCase.invoke(password)
            if (!isPasswordInvalid) {
                sendCommand(Command.PasswordAccepted)
            }
            updateState {
                currentState().copy(
                    password = password,
                    isPasswordInvalid = isPasswordInvalid,
                    listOfBrokenRequirements = listOfIssues
                )
            }
        }
    }

    data class State(
        val password: String = "",
        val isPasswordInvalid: Boolean = true,
        val listOfBrokenRequirements: List<String> = emptyList()
    ) : ViewState

    sealed class Command : ViewCommand {
        object PasswordAccepted : Command()
    }
}