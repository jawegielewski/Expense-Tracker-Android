package pl.jawegiel.expensetrackerandroid.ui.getexpenses.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pl.jawegiel.expensetrackerandroid.ui.getexpenses.GetExpensesViewModel
import pl.jawegiel.expensetrackerandroid.ui.getexpenses.components.Title
import pl.jawegiel.expensetrackerandroid.ui.getexpenses.components.Toolbar

@Composable
fun ExpensesScreen(onBackClick: () -> Unit, viewModel: GetExpensesViewModel = hiltViewModel()) {

    val expenses by viewModel.expensesState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = Color(0xFFF1F5F9), topBar = {
            Toolbar(onBackClick)
        }) { innerPadding ->
        Title(innerPadding, expenses)
    }
}