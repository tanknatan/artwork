package com.seveng.oneapps.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AgeConfirmationScreen(
    onYesClick: () -> Unit,
    onNoClick: () -> Unit
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Black, Color(0xFF8A2BE2)) // черный и фиолетовый цвет
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient), // Применяем градиент к фону
        contentAlignment = Alignment.Center // Размещаем текст по центру
    ){
        // Структура экрана
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Текст вопроса
            Text(
                text = "Вам уже исполнилось 18 лет?",
                fontSize = 24.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Кнопки "Да" и "Нет"
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = onYesClick) {
                    Text(text = "Да")
                }

                Button(onClick = onNoClick) {
                    Text(text = "Нет")
                }
            }
        }

    }

}

@Preview
@Composable
fun AgeConfirmationScreenPreview() {
    AgeConfirmationScreen(
        onYesClick = { /* Реакция на клик "Да" */ },
        onNoClick = { /* Реакция на клик "Нет" */ }
    )
}
