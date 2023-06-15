package com.diagnese.app.components.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.diagnese.app.pages.checkup.CheckupScreen
import com.diagnese.app.pages.checkup.CheckupViewModel
import com.diagnese.app.pages.checkup.screens.CheckOnceScreen
import com.diagnese.app.pages.checkup.screens.GetStartedScreen
import com.diagnese.app.pages.checkup.screens.ResultScreen
import com.diagnese.app.pages.checkup.screens.SelectSymptomScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun CheckupNavigation(
    navHostController: NavHostController,
    viewModel: CheckupViewModel
){
   NavHost(
       navController = navHostController,
       startDestination = CheckupScreen.GetStarted.route,
   ){
       composable(CheckupScreen.GetStarted.route){
           GetStartedScreen(
              navHostController = navHostController
           )
       }

       composable(CheckupScreen.SelectSymptoms.route){
           SelectSymptomScreen(
               navHostController = navHostController,
               viewModel = viewModel,
               navigateToCheckOnce = { symptoms, feels ->
                   navHostController.navigate(
                       CheckupScreen.CheckOnceMore.createRoute(
                          symptoms, feels
                       )
                   )
               })
       }


       composable(
           CheckupScreen.CheckOnceMore.route,
           arguments = listOf(
               navArgument("symptoms"){
               type = NavType.StringType
           },
             navArgument("feels"){
                 type = NavType.IntType
             }
           )
       ){
           val symptoms = it.arguments?.getString("symptoms") ?: ""
           val feels = it.arguments?.getInt("feels") ?: 1
          CheckOnceScreen(navHostController = navHostController, symptomsValue = symptoms, feels = feels, viewModel = viewModel)
       }

       composable(CheckupScreen.CheckupResult.route){
           ResultScreen(navHostController = navHostController, viewModel = viewModel)

       }


   }
}