package com.seveng.oneapps.presentation.view

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.seveng.oneapps.domain.ProductInfo
import com.seveng.oneapps.presentation.navigation.Destinations

@Composable
fun MainScreen(products: List<ProductInfo>, navController: NavHostController) {

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF2B74E2), Color(0xFF0049B6)) // черный и фиолетовый цвет
    )
    if (products.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.White,
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient), // Применяем градиент к фону
            contentAlignment = Alignment.Center // Размещаем текст по центру
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize() // LazyColumn сам по себе уже скроллируемый
            ) {
                // Добавляем элементы вне списка
                item {
                    Text(
                        text = "Заголовок 1",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Описание заголовка",
                        color = Color.Cyan,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically, // Центрируем элементы по вертикали
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check, // Галочка
                            contentDescription = "Checkmark",
                            tint = Color.White, // Цвет галочки
                            modifier = Modifier.size(24.dp) // Размер иконки
                        )

                        Spacer(modifier = Modifier.width(8.dp)) // Отступ между галочкой и текстом

                        Text(
                            text = "Текст 1",
                            color = Color.White
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically, // Центрируем элементы по вертикали
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check, // Галочка
                            contentDescription = "Checkmark",
                            tint = Color.White, // Цвет галочки
                            modifier = Modifier.size(24.dp) // Размер иконки
                        )

                        Spacer(modifier = Modifier.width(8.dp)) // Отступ между галочкой и текстом

                        Text(
                            text = "Текст 2",
                            color = Color.White
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically, // Центрируем элементы по вертикали
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check, // Галочка
                            contentDescription = "Checkmark",
                            tint = Color.White, // Цвет галочки
                            modifier = Modifier.size(24.dp) // Размер иконки
                        )

                        Spacer(modifier = Modifier.width(8.dp)) // Отступ между галочкой и текстом

                        Text(
                            text = "Текст 3",
                            color = Color.White
                        )
                    }
                }

                // Добавляем элементы из списка продуктов
                items(products){ item ->
                    if (item.newBlock == true) {
                        ServerBlockView(
                            logo1 = item.logo1.orEmpty(),
                            logo2 = item.logo2.orEmpty(),
                            text1 = item.text1.orEmpty(),
                            text2 = item.text2.orEmpty(),
                            text3 = item.text3.orEmpty(),
                            text4 = item.text4.orEmpty(),
                            text5 = item.text5.orEmpty(),
                            text6 = item.text6.orEmpty(),
                            link = item.link.orEmpty(),
                            textbutton = item.textbutton.orEmpty(),
                            navController = navController
                        )
                    } else {
                        ServerBlockView2(
                            icon = item.icon.orEmpty(),
                            rating = item.rating.orEmpty(),
                            text1 = item.text1.orEmpty(),
                            text2 = item.text2.orEmpty(),
                            text3 = item.text3.orEmpty(),
                            text4 = item.text4.orEmpty(),
                            text5 = item.text5.orEmpty(),
                            text10 = item.text10.orEmpty(),
                            text11 = item.text11.orEmpty(),
                            text12 = item.text12.orEmpty(),
                            link = item.link13.orEmpty(),
                            linkTextButton = item.linkTextButton.orEmpty(),
                            navHostController = navController
                        )
                        Text(
                            text = item.text14.orEmpty(),
                            color = Color.White,
                            modifier = Modifier
                                .padding(
                                    top = 0.dp,
                                    start = 16.dp,
                                    bottom = 8.dp,
                                    end = 16.dp
                                )
                                .offset(0.dp, -10.dp),
                            fontSize = 14.sp
                        )
                    }
                }
                item {
                    Text(
                        text = "Description",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Description",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Description",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Description",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Description",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Link1",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Link2",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                    Text(
                        text = "Link3",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

fun openWebView(navController: NavHostController, url: String) {
    if (url.isBlank()) return
    val encodedUrl = Uri.encode(url)
    navController.navigate("${Destinations.WebViewScreen.route}/$encodedUrl") {
        popUpTo(Destinations.MainScreen.route) {
 //           inclusive = true
        }
    }
}
