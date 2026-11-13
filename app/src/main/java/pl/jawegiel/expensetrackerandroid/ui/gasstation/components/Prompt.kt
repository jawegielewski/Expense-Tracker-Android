package pl.jawegiel.expensetrackerandroid.ui.gasstation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.jawegiel.expensetrackerandroid.ui.gasstation.GasStationViewModel

@Composable
fun GeminiPrompt(
    modifier: Modifier = Modifier,
    viewModel: GasStationViewModel = viewModel()
) {
    val promptInput by viewModel.promptInput.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        OutlinedTextField(
            value = promptInput,
            onValueChange = { viewModel.onPromptInputChange(it) },
            label = { Text("Enter city") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = Color.Black
            )
        )

        // Submit Button
        Button(
            onClick = { viewModel.sendPrompt(promptInput) },
            enabled = promptInput.isNotBlank() && !isLoading,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Generate")
        }

        HorizontalDivider()

        // Output Area
        PromptResponse(isLoading, uiState)
    }
}