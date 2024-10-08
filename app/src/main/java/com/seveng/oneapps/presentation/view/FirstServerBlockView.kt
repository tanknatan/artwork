package com.seveng.oneapps.presentation.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.seveng.oneapps.R


@Composable
fun ServerBlockView(
    logo1: String,
    logo2: String,
    text1: String,
    text2: String,
    text3: String,
    text4: String,
    text5: String,
    text6: String,
    link: String,
    textbutton: String,
    navController: NavHostController
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                Color(0xFFEFEFEF),
                RoundedCornerShape(16.dp)
            ) // Светлый фон с закругленными краями
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(120.dp, 30.dp)
                    .background(Color(0xFF101A28), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(logo1),
                    contentDescription = "Logo 1",
                    modifier = Modifier.size(100.dp, 40.dp),

                    )
            }
            Spacer(modifier = Modifier.width(0.dp))

            Image(
                painter = painterResource(id = R.drawable.play),
                contentDescription = "Logo 1",
                modifier = Modifier.size(40.dp, 40.dp),

                )

            Spacer(modifier = Modifier.width(0.dp))
            Box(
                modifier = Modifier
                    .size(120.dp, 40.dp)
                    .background(Color(0xFF268F1C), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(logo2),
                    contentDescription = "Logo 2",
                    modifier = Modifier.size(100.dp, 40.dp),

                    )
            }

        }
        // Вставляем блок с изображением


        Spacer(modifier = Modifier.height(16.dp))

        // Текстовые поля
        Text(
            text = text1,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Text(
            text = text2,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Text(
            text = text3,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = text4,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2D8C3E), // Зеленый текст
            textAlign = TextAlign.Center
        )
        Text(
            text = text5,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Text(
            text = text6,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Кнопка с градиентом
        TextButton(
            onClick = { openWebView(navController = navController, url = link) },
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF55AA33), Color(0xFF0D7400))
                    ),
                    shape = RoundedCornerShape(50.dp)
                )
                .padding(horizontal = 32.dp, vertical = 12.dp)
        ) {

            Text(
                text = textbutton,
                color = Color.White
            )
        }
    }
}



