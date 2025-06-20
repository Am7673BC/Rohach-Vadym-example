/**
 * Created by Rohach Vadym, 2025 All rights reserved and belongs to Rohach Vadym.
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.droidhen.o2testtasksolutionbyrohachvadym.feature.main_screen.MainScreen
import com.droidhen.o2testtasksolutionbyrohachvadym.ui.theme.O2TestTaskSolutionByRohachVadymTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            O2TestTaskSolutionByRohachVadymTheme {
                MainScreen()
            }
        }
    }
}