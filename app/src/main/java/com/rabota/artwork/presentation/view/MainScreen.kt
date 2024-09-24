package com.rabota.artwork.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Column {
            LazyColumn {
                items(products.sortedBy { it.newBlock }) {
                    if (it.newBlock == true) {
                        ServerBlockView(
                            newblock = it.newBlock,
                            logo1 = it.logo1.orEmpty(),
                            logo2 = it.logo2.orEmpty(),
                            text1 = it.text1.orEmpty(),
                            text2 = it.text2.orEmpty(),
                            text3 = it.text3.orEmpty(),
                            text4 = it.text4.orEmpty(),
                            text5 = it.text5.orEmpty(),
                            text6 = it.text6.orEmpty(),
                            link = it.link.orEmpty(),
                            textbutton = it.textbutton.orEmpty()
                        )
                    }
                    else {
                        ServerBlockView2(
                            icon = it.icon.orEmpty(),
                            rating = it.rating.orEmpty(),
                            text1 = it.text1.orEmpty(),
                            text2 = it.text2.orEmpty(),
                            text3 = it.text3.orEmpty(),
                            text4 = it.text4.orEmpty(),
                            text5 = it.text5.orEmpty(),
                            text10 = it.text10.orEmpty(),
                            text11 = it.text11.orEmpty(),
                            text12 = it.text12.orEmpty(),
                            link = it.link13.orEmpty(),
                            linkTextButton = it.linkTextButton.orEmpty(),
                            text14 = it.text14.orEmpty()
                        )
                    }
                }
            }
        }
    }
}