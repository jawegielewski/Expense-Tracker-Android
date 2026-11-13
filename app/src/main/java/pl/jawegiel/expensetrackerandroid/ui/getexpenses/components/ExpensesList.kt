package pl.jawegiel.expensetrackerandroid.ui.getexpenses.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.jawegiel.expensetrackerandroid.data.model.Expense

@Composable
fun ExpensesList(
    expenses: List<Expense>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        item {
            TableHeader()
        }
        items(
            items = expenses,
            key = { it.id ?: it.hashCode().toLong() },
        ) { expense ->
            ExpenseCard(expense)
        }
    }
}

