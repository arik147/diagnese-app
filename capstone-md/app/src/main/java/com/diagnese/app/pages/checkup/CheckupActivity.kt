package com.diagnese.app.pages.checkup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.diagnese.app.components.navigation.CheckupNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckupActivity : AppCompatActivity() {

    private val checkupViewModel by viewModels<CheckupViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            CheckupNavigation(navHostController, checkupViewModel)
        }
    }
}