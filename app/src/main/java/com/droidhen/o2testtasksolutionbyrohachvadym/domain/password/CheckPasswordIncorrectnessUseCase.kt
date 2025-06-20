/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.domain.password

import com.droidhen.o2testtasksolutionbyrohachvadym.domain.common.UseCase
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.common.utils.FormValidator.isPasswordInvalid

/**
 * UseCase for password validation, returns true if password is incorrect
 * @param params: String - password
 * @return Boolean (true if password is incorrect, false if not)
 */
class CheckPasswordIncorrectnessUseCase () : UseCase<Boolean ,String>(){

    override suspend fun doWork(params: String): Boolean = isPasswordInvalid(params)

}