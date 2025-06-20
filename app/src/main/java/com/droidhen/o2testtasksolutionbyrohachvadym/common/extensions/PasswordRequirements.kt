/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.common.extensions

import android.app.Application
import com.droidhen.o2testtasksolutionbyrohachvadym.R
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.common.utils.FormValidator
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.common.utils.PasswordRequirements

/**
 * List of validations rules for password, requires application to get access to resources
 * @param application Application to get resources
 * @return list of rules in specific order
 */
fun  FormValidator.getConditionMessages(application: Application): List<String> =
         listOf(
            application.getString(R.string.password_rule_uppercase),
            application.getString(R.string.password_rule_number),
            application.getString(R.string.password_rule_min_length),
            application.getString(R.string.password_rule_special_char),
         )


/**
 *  check password for correctness for specific conditions
 * @param password - password that will be checked
 * @return list of Boolean (true if correct, false if not)
 */
fun PasswordRequirements.getListCompletedRequirements(password: String): List<Boolean> {
    val result = mutableListOf<Boolean>()
    listOfCompletablePatterns.forEach { pattern ->
        result.add(password.matches(pattern.toRegex()))
    }
    return result
}