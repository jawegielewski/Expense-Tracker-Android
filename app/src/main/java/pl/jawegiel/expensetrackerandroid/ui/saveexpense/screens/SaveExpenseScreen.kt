package pl.jawegiel.expensetrackerandroid.ui.saveexpense.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.SaveExpenseViewModel
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.components.FormFields
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
            Text(
                text = "Add your expense",
                fontSize = 20.sp,
                color = Color(0xFF172554),
                modifier = Modifier.padding(bottom = 8.dp),
            )

            FormFields(viewModel)

            Button(
                shape = RoundedCornerShape(18.dp),
                onClick = {
                    viewModel.validateAndSave(
                        onSuccess = {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Expense saved successfully")
                                onBackClick()
                            }
                        },
                    ) { errorMessage ->
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(errorMessage)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D4ED8)),
            ) {
                Text(text = "Save Expense", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}
