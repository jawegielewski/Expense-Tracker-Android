package pl.jawegiel.expensetrackerandroid.ui.getexpenses.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pl.jawegiel.expensetrackerandroid.data.model.Expense

@Composable
fun ExpensesList(
    expenses: List<Expense>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF172554))
                            .padding(vertical = 12.dp, horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Id", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(0.8f))
                        Text("Name", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(2f))
                        Text("Price", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(1.5f))
                        Text("Date", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(2f))
                    }
                    HorizontalDivider(color = Color(0xFFE2E8F0))
                }
            }
            items(items = expenses, key = { it.id.toString() }) { message ->
                PosterCard(message)
            }
        }
    }
}