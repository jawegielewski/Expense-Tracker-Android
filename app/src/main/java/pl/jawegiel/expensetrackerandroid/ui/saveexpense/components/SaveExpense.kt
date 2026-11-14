package pl.jawegiel.expensetrackerandroid.ui.saveexpense.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pl.jawegiel.expensetrackerandroid.ui.saveexpense.SaveExpenseViewModel

@Composable
fun SaveExpense(
    viewModel: SaveExpenseViewModel,
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    onBackClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(18.dp),
        onClick = {
            viewModel.validateAndSave(onSuccess = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Expense saved successfully")
                    onBackClick()
                }
            }, onError = { errorMessage ->
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(errorMessage)
                }
            })
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
