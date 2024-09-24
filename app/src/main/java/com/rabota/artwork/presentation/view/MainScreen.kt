package com.rabota.artwork.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.rabota.artwork.domain.ProductInfo

@Composable
fun MainScreen(products: List<ProductInfo>) {
    if (products.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = Color(0xFF2B74E2),
            )
        }
    }
    else {
        val gradient = Brush.verticalGradient(
                colors = listOf(Color(0xFF2B74E2), Color(0xFF0049B6)) // черный и фиолетовый цвет
                )
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
                    Text(text = "Заголовок 1", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Описание заголовка", color = Color.Cyan, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
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
                items(products.sortedBy { it.newBlock }) { item ->
                    if (item.newBlock == true) {
                        ServerBlockView(
                            newblock = item.newBlock,
                            logo1 = item.logo1.orEmpty(),
                            logo2 = item.logo2.orEmpty(),
                            text1 = item.text1.orEmpty(),
                            text2 = item.text2.orEmpty(),
                            text3 = item.text3.orEmpty(),
                            text4 = item.text4.orEmpty(),
                            text5 = item.text5.orEmpty(),
                            text6 = item.text6.orEmpty(),
                            link = item.link.orEmpty(),
                            textbutton = item.textbutton.orEmpty()
                        )
                        Text(text = "Text14", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
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
                            text14 = item.text14.orEmpty()
                        )
                        Text(text = "Text14", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    }
                }
                item {
                    Text(text = "Description", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Description", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Description", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Description", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Description", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Link1", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Link2", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                    Text(text = "Link3", color = Color.White, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                }
            }
        }


//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(gradient), // Применяем градиент к фону
//            contentAlignment = Alignment.Center // Размещаем текст по центру
//        ){
//
//            Column {
//
//                LazyColumn {
//                    items(products.sortedBy { it.newBlock }) {
//                        if (it.newBlock == true) {
//                            ServerBlockView(
//                                newblock = it.newBlock,
//                                logo1 = it.logo1.orEmpty(),
//                                logo2 = it.logo2.orEmpty(),
//                                text1 = it.text1.orEmpty(),
//                                text2 = it.text2.orEmpty(),
//                                text3 = it.text3.orEmpty(),
//                                text4 = it.text4.orEmpty(),
//                                text5 = it.text5.orEmpty(),
//                                text6 = it.text6.orEmpty(),
//                                link = it.link.orEmpty(),
//                                textbutton = it.textbutton.orEmpty()
//                            )
//                            Text(text = "Text14")
//                        }
//                        else {
//                            ServerBlockView2(
//                                icon = it.icon.orEmpty(),
//                                rating = it.rating.orEmpty(),
//                                text1 = it.text1.orEmpty(),
//                                text2 = it.text2.orEmpty(),
//                                text3 = it.text3.orEmpty(),
//                                text4 = it.text4.orEmpty(),
//                                text5 = it.text5.orEmpty(),
//                                text10 = it.text10.orEmpty(),
//                                text11 = it.text11.orEmpty(),
//                                text12 = it.text12.orEmpty(),
//                                link = it.link13.orEmpty(),
//                                linkTextButton = it.linkTextButton.orEmpty(),
//                                text14 = it.text14.orEmpty()
//                            )
//                            Text(text = "Text14")
//                        }
//                    }
//
//                }
//                Text(text = "Description")
//                Text(text = "Description")
//                Text(text = "Description")
//                Text(text = "Description")
//                Text(text = "Description")
//            }
//        }

    }
}