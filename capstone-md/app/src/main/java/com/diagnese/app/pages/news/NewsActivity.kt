package com.diagnese.app.pages.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.diagnese.app.components.widgets.CenterAppBar
import com.diagnese.app.components.widgets.Loading
import com.diagnese.app.components.widgets.NewsCard
import com.diagnese.app.core.data.local.NewsEntity
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
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            ){
                if(newsData == null){
                    item {
                        Loading()
                    }
                } else {
                    items(items = newsData, key = { item -> item.title ?: "" }){
                        NewsCard(
                            imageUrl = (it.urlToImage ?: "" )as String ,
                            title = it.title ?: "",
                            onClick = {
                                val intent = Intent(context, NewsDetailActivity::class.java)
                                intent.putExtra("url", it.url)
                                context.startActivity(intent)
                            },
                            onBookmarked = {
                                val newsEntity = NewsEntity(
                                    image = (it.urlToImage ?: "") as String ,
                                    title = it.title ?: "",
                                    author = it.author ?: "",
                                )
                                viewModel.insertBookmark(newsEntity)
                            }
                        )
                    }
                }
               }
           }
}




