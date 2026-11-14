package pl.jawegiel.expensetrackerandroid.ui.getexpenses.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.jawegiel.expensetrackerandroid.data.model.Expense

@Composable
fun Title(
    innerPadding: PaddingValues, expenses: List<Expense>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Here are your expenses",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF172554),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ExpensesList(expenses = expenses, modifier = Modifier.fillMaxSize())
    }
}