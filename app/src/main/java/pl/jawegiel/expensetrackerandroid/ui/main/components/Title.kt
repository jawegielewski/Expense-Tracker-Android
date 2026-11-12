package pl.jawegiel.expensetrackerandroid.ui.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title() {
    Text(
        text = "Expense Tracker",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        textAlign = TextAlign.Center,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF172554),
    )
}
