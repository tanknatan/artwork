package com.seveng.oneapps.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(1000) // Short delay before transitioning
        onTimeout()
    }

    // Черно-фиолетовый градиент
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF2B74E2), Color(0xFF0049B6)) // черный и фиолетовый цвет
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient), // Применяем градиент к фону
        contentAlignment = Alignment.Center // Размещаем текст по центру
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "loading",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // Белый цвет для текста
            )

            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
                    .size(48.dp)
            )
        }
        
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(onTimeout = { /*TODO*/ })
}
