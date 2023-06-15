package com.diagnese.app.pages.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.diagnese.app.components.widgets.CenterAppBar
import com.diagnese.app.components.widgets.Loading
import com.diagnese.app.components.widgets.NewsCard
import com.diagnese.app.components.widgets.SearchTextField
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private val newsViewModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsPage(viewModel = newsViewModel)
        }
    }
}


@Composable
fun NewsPage(
    viewModel: NewsViewModel
){
    val context = LocalContext.current
    val data = viewModel.newsData.observeAsState()
    val newsData = data.value?.articles

    Scaffold(
        topBar = {
            CenterAppBar(context = context, title = "Articles" )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        ){
            SearchTextField(label = "Search for Articles...", modifier = Modifier.padding(10.dp))

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(verticalArrangement = Arrangement.Center){
                if(newsData == null){
                    item {
                        Loading()
                    }
                } else {
                    items(items = newsData, key = { item -> item.title!! }){
                        NewsCard(imageUrl = it.urlToImage as String, title = it.title ?: "", onClick = {
                            val intent = Intent(context, NewsDetailActivity::class.java)
                            intent.putExtra("url", it.url)
                            context.startActivity(intent)
                        })
                    }
                }
               }
           }
        }

    }


