/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.di

import com.droidhen.o2testtasksolutionbyrohachvadym.domain.password.CheckPasswordIncorrectnessUseCase
import com.droidhen.o2testtasksolutionbyrohachvadym.domain.password.GetIssuesListUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single {
        CheckPasswordIncorrectnessUseCase()
    }

    single {
        GetIssuesListUseCase(get())
    }
}