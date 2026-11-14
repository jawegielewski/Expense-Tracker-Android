package pl.jawegiel.expensetrackerandroid.data.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Expense(var id: Long? = null, var name: String, var price: Int, var dateMillis: Long) {

    val formattedDate: String
        get() {
            val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            return sdf.format(Date(dateMillis))
        }
}