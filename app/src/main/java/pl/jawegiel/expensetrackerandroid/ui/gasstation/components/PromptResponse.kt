package pl.jawegiel.expensetrackerandroid.ui.gasstation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pl.jawegiel.expensetrackerandroid.ui.gasstation.GasStationViewModel

@Composable
fun PromptResponse(
    isLoading: Boolean, uiState: GasStationViewModel.PromptUiState
) {
    Box(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            when (val state = uiState) {
                is GasStationViewModel.PromptUiState.Initial -> {
                    Text(
                        text = "Your AI response will appear here.", color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                is GasStationViewModel.PromptUiState.Success -> {
                    Text(
                        text = state.outputText, style = MaterialTheme.typography.bodyLarge
                    )
                }

                is GasStationViewModel.PromptUiState.Error -> {
                    Text(
                        text = "Error: ${state.errorMessage}", color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}
