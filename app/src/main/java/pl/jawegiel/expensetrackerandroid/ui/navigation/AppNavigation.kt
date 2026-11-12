package pl.jawegiel.expensetrackerandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.jawegiel.expensetrackerandroid.ui.main.screens.ExpensesScreen
import pl.jawegiel.expensetrackerandroid.ui.main.screens.GasStationScreen
import pl.jawegiel.expensetrackerandroid.ui.main.screens.MainScreen
import pl.jawegiel.expensetrackerandroid.ui.main.screens.SaveExpenseScreen

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Expenses : Screen("expenses")
    object SaveExpense : Screen("save_expense")
    object GasStation : Screen("gas_station")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) {
            MainScreen(
                onNavigateToExpenses = { navController.navigate(Screen.Expenses.route) },
                onNavigateToSaveExpense = { navController.navigate(Screen.SaveExpense.route) },
                onNavigateToGasStation = { navController.navigate(Screen.GasStation.route) }
            )
        }
        composable(Screen.Expenses.route) {
            ExpensesScreen(onBackClick = { navController.popBackStack() })
        }
        composable(Screen.SaveExpense.route) {
            SaveExpenseScreen(onBackClick = { navController.popBackStack() })
        }
        composable(Screen.GasStation.route) {
            GasStationScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
