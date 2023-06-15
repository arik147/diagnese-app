package com.diagnese.app.pages.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.diagnese.app.components.widgets.CenterAppBar
import com.diagnese.app.utils.findActivity

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            NewsDetailPage()
        }
    }
}

@Composable
fun NewsDetailPage(
    modifier : Modifier = Modifier
){
    val context = LocalContext.current
    val intent = context.findActivity()?.intent
    val url = intent?.getStringExtra("url")

    Scaffold(
        topBar = {
            CenterAppBar(context = context, title = "", onNavClick = {
                context.startActivity(Intent(context, NewsActivity::class.java))
            })
        }
    ) {
        AndroidView(
            modifier = modifier.padding(it),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl(url ?: "https://www.google.com")

                }
            },
            update = { view ->
                view.loadUrl(url ?: "https://www.google.com")
            }
        )
    }

}