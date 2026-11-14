package pl.jawegiel.expensetrackerandroid.ui.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.jawegiel.expensetrackerandroid.ui.main.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    menuExpanded: Boolean,
    onMenuClick: () -> Unit,
    onDismissMenu: () -> Unit,
    viewModel: MainViewModel,
    onNavigateToExpenses: () -> Unit,
    onNavigateToSaveExpense: () -> Unit,
    onNavigateToGasStation: () -> Unit,
) {
    TopAppBar(
        title = { Text("Expense Tracker", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF172554),
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
        actions = {
            Box {
                IconButton(onClick = onMenuClick) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More options",
                        tint = Color.White,
                    )
                }
                ToolbarMenu(
                    menuExpanded = menuExpanded,
                    onDismissRequest = onDismissMenu,
                    viewModel = viewModel,
                    onNavigateToExpenses = onNavigateToExpenses,
                    onNavigateToSaveExpense = onNavigateToSaveExpense,
                    onNavigateToGasStation = onNavigateToGasStation,
                )
            }
        })
}
