package pl.jawegiel.expensetrackerandroid.ui.main.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pl.jawegiel.expensetrackerandroid.ui.getexpenses.GetExpensesViewModel
import pl.jawegiel.expensetrackerandroid.ui.getexpenses.components.ExpensesList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpensesScreen(onBackClick: () -> Unit, viewModel: GetExpensesViewModel = hiltViewModel()) {

    val expenses by viewModel.expensesState.collectAsStateWithLifecycle()


    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = Color(0xFFF1F5F9), topBar = {
            TopAppBar(
                title = { Text("Expenses List", color = Color.White) }, navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF172554), titleContentColor = Color.White
            )
            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Here are your expenses",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF172554),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ExpensesList(expenses = expenses, modifier = Modifier.fillMaxSize())
        }
    }
}
