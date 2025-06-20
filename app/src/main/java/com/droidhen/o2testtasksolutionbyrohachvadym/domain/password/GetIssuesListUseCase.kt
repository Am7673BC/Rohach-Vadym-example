/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.domain.password

import android.app.Application
import com.droidhen.o2testtasksolutionbyrohachvadym.domain.common.UseCase
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.common.utils.FormValidator.updatePasswordConditions


/**
 * UseCase for password validation, returns list of issues with password
 * @param params: String - password
 * @return List<String> - list of issues with password
 */
class GetIssuesListUseCase (private val application: Application) : UseCase<List<String>, String> (){

    override suspend fun doWork(params: String): List<String> = updatePasswordConditions(application, params)

}