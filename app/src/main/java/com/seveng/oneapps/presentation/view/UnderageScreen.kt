package com.seveng.oneapps.presentation.view

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UnderageScreen() {
    val activity = LocalContext.current as? Activity
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Black, Color(0xFF8A2BE2)) // черный и фиолетовый цвет
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient), // Применяем градиент к фону

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Сообщение пользователю
            Text(
                text = "Вам нет 18 лет. Пожалуйста, удалите приложение.",
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Кнопка "Выход" или "Закрыть"
            Button(onClick = {  activity?.finish()  }) {
                Text(text = "Закрыть приложение",
                color = Color.White)
            }
        }

    }
    // Структура экрана

}

@Preview
@Composable
fun UnderageScreenPreview() {
    UnderageScreen(

    )
}
