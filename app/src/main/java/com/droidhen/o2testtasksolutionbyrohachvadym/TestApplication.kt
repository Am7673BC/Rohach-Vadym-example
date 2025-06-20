/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
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