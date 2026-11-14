package pl.jawegiel.expensetrackerandroid.ui.main.components

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pl.jawegiel.expensetrackerandroid.ui.main.MainViewModel

@Composable
fun ToolbarMenu(
    menuExpanded: Boolean,
    onDismissRequest: () -> Unit,
    viewModel: MainViewModel,
    onNavigateToExpenses: () -> Unit,
    onNavigateToSaveExpense: () -> Unit,
    onNavigateToGasStation: () -> Unit
) {
    DropdownMenu(
        expanded = menuExpanded, onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(text = { Text("Get expenses") }, onClick = {
            onDismissRequest()
            viewModel.getExpenses()
            onNavigateToExpenses()
        })
        DropdownMenuItem(text = { Text("Save expense") }, onClick = {
            onDismissRequest()
            viewModel.saveExpense()
            onNavigateToSaveExpense()
        })
        DropdownMenuItem(text = { Text("Best gas station") }, onClick = {
            onDismissRequest()
            onNavigateToGasStation()
        })
    }
}