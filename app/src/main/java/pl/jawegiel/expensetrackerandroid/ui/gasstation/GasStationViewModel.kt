package pl.jawegiel.expensetrackerandroid.ui.gasstation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.jawegiel.expensetrackerandroid.data.remote.AiApiService
import javax.inject.Inject

@HiltViewModel
class GasStationViewModel @Inject constructor(
    private val aiApiService: AiApiService
) : ViewModel() {

    private val _promptInput = MutableStateFlow("")
    val promptInput: StateFlow<String> = _promptInput.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _uiState = MutableStateFlow<PromptUiState>(PromptUiState.Initial)
    val uiState: StateFlow<PromptUiState> = _uiState.asStateFlow()

    fun onPromptInputChange(newInput: String) {
        _promptInput.value = newInput
    }

    fun sendPrompt(city: String) {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val recommendation = aiApiService.getRecommendation(city)
                if (recommendation.isNotEmpty()) {
                    _uiState.value = PromptUiState.Success(recommendation)
                } else {
                    _uiState.value = PromptUiState.Success("No recommendations found.")
                }
            } catch (e: Exception) {
                _uiState.value = PromptUiState.Error(e.localizedMessage ?: "An error occurred")
            } finally {
                _isLoading.value = false
            }
        }
    }

    sealed interface PromptUiState {
        data object Initial : PromptUiState
        data class Success(val outputText: String) : PromptUiState
        data class Error(val errorMessage: String) : PromptUiState
    }
}