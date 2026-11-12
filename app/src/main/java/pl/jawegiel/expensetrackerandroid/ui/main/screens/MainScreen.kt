package pl.jawegiel.expensetrackerandroid.ui.main.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.jawegiel.expensetrackerandroid.ui.main.MainViewModel
import pl.jawegiel.expensetrackerandroid.ui.main.components.Title
import pl.jawegiel.expensetrackerandroid.ui.main.components.Toolbar

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
    onNavigateToExpenses: () -> Unit = {},
    onNavigateToSaveExpense: () -> Unit = {},
    onNavigateToGasStation: () -> Unit = {}
) {
    var menuExpanded by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF1F5F9),
        topBar = {
            Toolbar(
                menuExpanded = menuExpanded,
                onMenuClick = { menuExpanded = !menuExpanded },
                onDismissMenu = { menuExpanded = false },
                viewModel = viewModel,
                onNavigateToExpenses = onNavigateToExpenses,
                onNavigateToSaveExpense = onNavigateToSaveExpense,
                onNavigateToGasStation = onNavigateToGasStation
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Title()

            Button(
                shape = RoundedCornerShape(18.dp),
                onClick = {
                    viewModel.getExpenses()
                    onNavigateToExpenses()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D4ED8))
            ) {
                Text(text = "Get expenses", fontSize = 16.sp, color = Color.White)
            }

            Button(
                shape = RoundedCornerShape(18.dp),
                onClick = {
                    viewModel.saveExpense()
                    onNavigateToSaveExpense()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF))
            ) {
                Text(text = "Save expense", fontSize = 16.sp, color = Color(0xFF1E3A8A))
            }
        }
    }
}
