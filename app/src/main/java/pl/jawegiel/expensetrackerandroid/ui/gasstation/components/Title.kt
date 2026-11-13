package pl.jawegiel.expensetrackerandroid.ui.gasstation.components

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
fun Title(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Best gas station recommendations",
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF172554),
        textAlign = TextAlign.Center,
        modifier = modifier.padding(bottom = 16.dp)
    )
}
