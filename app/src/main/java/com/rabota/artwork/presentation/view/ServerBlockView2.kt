package com.rabota.artwork.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

//@Composable
//fun ServerBlockView2(
//    icon: String,
//    rating: String,
//    text1: String,
//    text2: String,
//    text3: String,
//    text4: String?,
//    text5: String?,
//    text10: String,
//    text11: String,
//    text12: String,
//    link: String,
//    linkTextButton: String,
//    text14: String
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .background(Color(0xFF001144), RoundedCornerShape(10.dp))
//            .padding(16.dp)
//    ) {
//        // Left Column with Icon and Texts
//        Column(
//            modifier = Modifier.weight(1f),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Image(
//                painter = rememberAsyncImagePainter(icon),
//                contentDescription = "Icon",
//                modifier = Modifier.size(110.dp,48.dp),
//                contentScale = ContentScale.Fit
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Text(
//                text = rating,
//                fontSize = 28.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White
//            )
//            Text(
//                text = text1,
//                fontSize = 16.sp,
//                color = Color.White
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Texts 2, 3, 4, 5
//            if (text2.isNotEmpty()) Text(text = text2, color = Color.White, fontSize = 14.sp)
//            if (text3.isNotEmpty()) Text(text = text3, color = Color.White, fontSize = 14.sp)
//            if (!text4.isNullOrEmpty()) Text(text = text4, color = Color.White, fontSize = 14.sp)
//            if (!text5.isNullOrEmpty()) Text(text = text5, color = Color.White, fontSize = 14.sp)
//        }
//
//        Spacer(modifier = Modifier.width(16.dp))
//
//        // Right Column with Title, Subtitle, and Button
//
//        Column(
//            modifier = Modifier.weight(2f),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = text10,
//                fontSize = 16.sp,
//                color = Color(0xFF66FF66),
//                textAlign = TextAlign.Center
//            )
//            Text(
//                text = text11,
//                fontSize = 22.sp,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                color = Color.White
//            )
//            Text(
//                text = text12,
//                fontSize = 16.sp,
//                textAlign = TextAlign.Center,
//                color = Color.White
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Button
//            TextButton(
//                onClick = { /* Handle the link, e.g., open URL */ },
//                modifier = Modifier
//                    .background(
//                        brush = Brush.horizontalGradient(
//                            colors = listOf(Color(0xFF1B88E9), Color(0xFF2FD1EC))
//                        ),
//                        shape = RoundedCornerShape(10.dp)
//                    )
//                    .size(200.dp, 40.dp)
//            ) {
//
//                Text(
//                    text = linkTextButton,
//                    color = Color.White
//                )
//            }
//        }
//    }
//}
@Composable
fun ServerBlockView2(
    icon: String,
    rating: String,
    text1: String,
    text2: String,
    text3: String,
    text4: String?,
    text5: String?,
    text10: String,
    text11: String,
    text12: String,
    link: String,
    linkTextButton: String,
    text14: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF001144), RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        // Левая колонка с иконкой и текстами
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(icon),
                contentDescription = "Icon",
                modifier = Modifier.size(110.dp, 48.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = rating,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = text1,
                fontSize = 16.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Тексты 2, 3, 4, 5
            if (text2.isNotEmpty()) Text(text = text2, color = Color.White, fontSize = 14.sp)
            if (text3.isNotEmpty()) Text(text = text3, color = Color.White, fontSize = 14.sp)
            if (!text4.isNullOrEmpty()) Text(text = text4, color = Color.White, fontSize = 14.sp)
            if (!text5.isNullOrEmpty()) Text(text = text5, color = Color.White, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Правая колонка с белым фоном и текстом "ADS" сверху
        Box(
            modifier = Modifier
                .weight(2f)
                .background(Color.White, RoundedCornerShape(10.dp)) // Добавляем белый фон
                .padding(16.dp)
        ) {
            // Надпись ADS в верхнем правом углу
            Text(
                text = "ADS",
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopEnd) // Размещаем надпись в правом верхнем углу
                    .padding(8.dp)
            )

            // Контент внутри правой колонки
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = text10,
                    fontSize = 16.sp,
                    color = Color(0xFF66FF66),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = text11,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black // Изменим цвет текста, чтобы он был виден на белом фоне
                )
                Text(
                    text = text12,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black // Изменим цвет текста
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Кнопка
                TextButton(
                    onClick = { /* Handle the link, e.g., open URL */ },
                    modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFF1B88E9), Color(0xFF2FD1EC))
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(200.dp, 40.dp)
                ) {
                    Text(
                        text = linkTextButton,
                        color = Color.White
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun ServerBlockView2Preview() {
    ServerBlockView2(
        icon = "",
        rating = "5.0",
        text1 = "текст 1",
        text2 = "тхт ",
        text3 = "тхт",
        text4 = "тхт",
        text5 = "тхт",
        text10 = "Тест10",
        text11 = "Тест11",
        text12 = "Тест12",
        link = "",
        linkTextButton = "link13",
        text14 = "Тестовое описание"
    )
}
