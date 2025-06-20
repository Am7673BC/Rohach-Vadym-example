/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
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