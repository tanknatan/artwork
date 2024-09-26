package com.seveng.oneapps.presentation.view


import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView



@Composable
fun WebViewScreen(url: String) {
    Box {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    webViewClient =
                        WebViewClient() // Открываем ссылки внутри WebView, а не в браузере
                    settings.apply {
                        javaScriptEnabled = true
                        domStorageEnabled = true
                        setSupportMultipleWindows(true)
                        setSupportZoom(true)
                        useWideViewPort = true
                        loadWithOverviewMode = true
                    }
                    loadUrl(url) // Загружаем указанный URL
                }
            },
            modifier = Modifier.fillMaxWidth() // Устанавливаем WebView на весь размер экрана
        )


    }
}