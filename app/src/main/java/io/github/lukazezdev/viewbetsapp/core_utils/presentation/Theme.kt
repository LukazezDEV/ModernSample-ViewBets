package io.github.lukazezdev.viewbetsapp.core_utils.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF1976D2),
            onPrimary = Color.White,
            secondary = Color(0xFFFFCA28),
            onSecondary = Color.Black,
            background = Color.White,
            surface = Color.White,
            onSurface = Color.Black,
            error = Color.Red,
            onError = Color.White
        ),
        typography = Typography(
            titleLarge = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),
            titleMedium = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp),
            bodyMedium = TextStyle(fontWeight = FontWeight.Normal, fontSize = 16.sp),
            labelLarge = TextStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp)
        ),
        content = content
    )
}