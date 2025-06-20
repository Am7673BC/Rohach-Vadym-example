/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym

import android.app.Application
import com.droidhen.o2testtasksolutionbyrohachvadym.di.useCaseModule
import com.droidhen.o2testtasksolutionbyrohachvadym.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TestApplication)
            modules(listOf(viewModelModule, useCaseModule))
        }
    }
}