/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.di

import com.droidhen.o2testtasksolutionbyrohachvadym.feature.main_screen.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(get(), get())
    }
}