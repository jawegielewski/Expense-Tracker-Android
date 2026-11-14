package pl.jawegiel.expensetrackerandroid.ui.saveexpense.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.SaveExpenseViewModel
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.components.FormFields
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.components.SaveExpense
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.components.Title
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.components.Toolbar

@Composable
fun SaveExpenseScreen(
    viewModel: SaveExpenseViewModel = hiltViewModel(), onBackClick: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF1F5F9),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            Toolbar(onBackClick)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Title()

            FormFields(viewModel)

            SaveExpense(viewModel, coroutineScope, snackbarHostState, onBackClick)
        }
    }
}