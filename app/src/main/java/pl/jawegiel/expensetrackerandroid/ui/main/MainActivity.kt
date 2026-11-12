package pl.jawegiel.expensetrackerandroid.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import pl.jawegiel.expensetrackerandroid.ui.navigation.AppNavigation
import pl.jawegiel.expensetrackerandroid.ui.theme.ExpenseTrackerAndroidTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerAndroidTheme {
                AppNavigation()
            }
        }
    }
}
