package com.marcelo.buscadordecep.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcelo.buscadordecep.view.GetCepScreen

@Composable
fun Navigation(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = "homeCep"
    ){
        composable("homeCep"){
            GetCepScreen(navHostController)
        }
    }
}