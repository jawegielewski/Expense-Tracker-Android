package pl.jawegiel.expensetrackerandroid.ui.getexpenses.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.jawegiel.expensetrackerandroid.data.model.Expense

@Composable
fun PosterCard(expense: Expense) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(expense.id.toString(), modifier = Modifier.weight(0.8f))
        Text(expense.name, modifier = Modifier.weight(2f))
        Text(expense.price.toString(), modifier = Modifier.weight(1.5f))
        Text(expense.formattedDate, modifier = Modifier.weight(2f))
    }
    HorizontalDivider(color = Color(0xFFE2E8F0))
}