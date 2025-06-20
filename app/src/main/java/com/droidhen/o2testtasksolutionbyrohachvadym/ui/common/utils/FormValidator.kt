/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.ui.common.utils

import android.app.Application
import com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions.getConditionMessages
import com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions.getListCompletedRequirements

object FormValidator {

    /**
     * Checks if password completed all conditions
     */
    fun isPasswordInvalid(password: String): Boolean {
        return !PasswordRequirements.listOfCompletablePatterns.all { password.matches(it.toRegex()) }
    }

    /**
     * evaluate password for specific requirements, and return the feedback about that
     * @param password - password that entered by user
     * @return List<String> - the list of changes user have to do to complete password, if password is correct - the list is empty
     */
    fun updatePasswordConditions(application: Application, password: String): List<String> {
        val listOfBrokenConditions = mutableListOf<String>()

        PasswordRequirements.getListCompletedRequirements(password)
            .forEachIndexed { index, completed ->
                if (!completed) {
                    listOfBrokenConditions.add(getConditionMessages(application)[index])
                }
            }
        return listOfBrokenConditions
    }
}

object PasswordRequirements {
    /** Pattern for single uppercase condition check */
    private const val SINGLE_UPPERCASE_PATTERN = ".*[A-Z].*"

    /** Pattern for single number condition check */
    private const val SINGLE_NUMBER_PATTERN = ".*[0-9].*"

    /** Pattern for single special char condition check */
    private const val SINGLE_SPECIAL_CHARACTERS_PATTERN =
        ".*[?=!#/%].*"

    /** Pattern for single min - max password length condition check */
    private const val SINGLE_MIN_LIMIT_PATTERN =
        ".{8,}"

    val listOfCompletablePatterns = mutableListOf(
        SINGLE_UPPERCASE_PATTERN,
        SINGLE_NUMBER_PATTERN,
        SINGLE_MIN_LIMIT_PATTERN,
        SINGLE_SPECIAL_CHARACTERS_PATTERN
    )
}