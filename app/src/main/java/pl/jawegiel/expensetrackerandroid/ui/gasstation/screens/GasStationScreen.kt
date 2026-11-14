package pl.jawegiel.expensetrackerandroid.ui.gasstation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import pl.jawegiel.expensetrackerandroid.ui.gasstation.GasStationViewModel
import pl.jawegiel.expensetrackerandroid.ui.gasstation.components.GeminiPrompt
import pl.jawegiel.expensetrackerandroid.ui.gasstation.components.Title
import pl.jawegiel.expensetrackerandroid.ui.gasstation.components.Toolbar

@Composable
fun GasStationScreen(onBackClick: () -> Unit, viewModel: GasStationViewModel = hiltViewModel()) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = Color(0xFFF1F5F9), topBar = {
            Toolbar(onBackClick)
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            GeminiPrompt(viewModel = viewModel)
        }
    }
}



