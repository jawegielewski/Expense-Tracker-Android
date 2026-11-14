package pl.jawegiel.expensetrackerandroid.domain.usecase

import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

sealed interface ValidationResult {
    data object Success : ValidationResult
    data class Error(val message: String) : ValidationResult
}

class ValidateExpenseUseCase @Inject constructor() {

    operator fun invoke(
        name: String, price: String, dateMillis: String, selectedMillis: Long?
    ): ValidationResult {
        val nameResult = validateName(name)
        if (nameResult is ValidationResult.Error) return nameResult

        val priceResult = validatePrice(price)
        if (priceResult is ValidationResult.Error) return priceResult

        val dateResult = validateDate(dateMillis, selectedMillis)
        if (dateResult is ValidationResult.Error) return dateResult

        return ValidationResult.Success
    }

    private fun validateName(name: String): ValidationResult {
        if (name.isBlank()) return ValidationResult.Error("Name is required")
        if (!name.matches(Regex("^[^0-9]*$"))) return ValidationResult.Error("Name must not contain numbers")
        if (name.length !in 3..50) return ValidationResult.Error("Name must be of length between 3-50")
        return ValidationResult.Success
    }

    private fun validatePrice(price: String): ValidationResult {
        if (price.isBlank()) return ValidationResult.Error("Price is required")
        val bigDecimalPrice = price.toBigDecimalOrNull()
            ?: return ValidationResult.Error("Price must be greater than zero")
        if (bigDecimalPrice <= BigDecimal.ZERO) return ValidationResult.Error("Price must be greater than zero")
        if (bigDecimalPrice.scale() > 2) return ValidationResult.Error("Price format must be up to 6 digits and 2 decimals")
        val intVal = bigDecimalPrice.setScale(0, RoundingMode.DOWN).toBigInteger().abs()
        if (intVal.toString().length > 6) return ValidationResult.Error("Price format must be up to 6 digits and 2 decimals")
        return ValidationResult.Success
    }

    private fun validateDate(dateMillis: String, selectedMillis: Long?): ValidationResult {
        if (selectedMillis == null || dateMillis.isBlank()) return ValidationResult.Error("Date is required")
        if (selectedMillis < 1000000000000L || selectedMillis.toString().length > 13) {
            return ValidationResult.Error("Date is not correct")
        }
        return ValidationResult.Success
    }
}