package com.pdm0126.parcial3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.parcial3.screens.Menu.MenuScreen

@Composable
fun  AppNavigation() {
    val backStack = rememberNavBackStack(Routes.Menu)

    NavDisplay(
        backStack = backStack,
        onBack = backStack.removeLastOrNull() as () -> Unit,
        entryProvider = entryProvider {
            entry<Routes.Menu> {
                MenuScreen(
                    navigateToQuestions = { backStack.removeLastOrNull()}
                )
            }
        }
    )
}