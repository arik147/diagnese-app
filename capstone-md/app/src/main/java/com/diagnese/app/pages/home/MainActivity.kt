package com.diagnese.app.pages.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants
import com.diagnese.app.R
import com.diagnese.app.components.widgets.ButtonComponent
import com.diagnese.app.components.widgets.CenterAppBar
import com.diagnese.app.components.widgets.GuestCard
import com.diagnese.app.components.widgets.GuideCardView
import com.diagnese.app.components.widgets.Loading
import com.diagnese.app.components.widgets.NewsCard
import com.diagnese.app.components.widgets.UserCard
import com.diagnese.app.core.data.local.NewsEntity
import com.diagnese.app.model.CardItem
import com.diagnese.app.pages.bookmark.BookmarkActivity
import com.diagnese.app.pages.checkup.CheckupActivity
import com.diagnese.app.pages.news.NewsActivity
import com.diagnese.app.pages.news.NewsDetailActivity
import com.diagnese.app.pages.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface( modifier = Modifier.fillMaxSize(),
                color = colorResource(id = Constants.PRIMARY_COLOR)){
                MainPage(viewModel = mainViewModel)
            }
      }
}
}

@Composable
fun MainPage(
    viewModel: MainViewModel
){


    val context = LocalContext.current
    val newsLiveData = viewModel.newsPagingData.observeAsState()
    val newsData = newsLiveData.value?.data?.articles

    val currentUser = viewModel.loginResultState.observeAsState()



    Scaffold( 
        topBar = {
           CenterAppBar(
               context = context,
               title = "Good Morning".uppercase(),
               navIcons = Icons.Default.Bookmark,
               onNavClick = {
                    context.startActivity(Intent(context, BookmarkActivity::class.java))
               }
           ) {
               IconButton(onClick = {
                   context.startActivity(Intent(context, SettingsActivity::class.java))
               }) {
                   Icon(
                       Icons.Filled.Settings,
                       contentDescription = null,
                       tint = Color.White
                   )
               }
           }
        }
    ) { paddingValues ->
         Box(modifier = Modifier
             .padding(paddingValues)
             .fillMaxSize()
             .background(
                 Brush.verticalGradient(
                     colors = listOf(
                         colorResource(id = Constants.PRIMARY_COLOR),
                         Color.White
                     )
                 )
             )
         ){
             LazyColumn{

                 item{
                    val welcomeText = CardItem(
                        image = R.drawable.stethoscope,
                        title = "Feeling Under the Weather",
                        slug = "Lets Check up with Us",
                        buttonMenu = "Start"
                    )

                    Box(modifier = Modifier.fillMaxWidth()){
                        Column {
                            Row(modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()) {
                                Column {
                                    Text(text = welcomeText.title,
                                        color = colorResource(id = Constants.TEXT_COLOR),
                                        fontSize = Constants.LARGE_FONT_SIZE.sp,
                                        fontFamily = Constants.FONT_FAMILY_BOLD,
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = welcomeText.slug,
                                        color = colorResource(id = Constants.TEXT_COLOR),
                                        fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                                        fontFamily = Constants.FONT_FAMILY_BOLD,
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    ButtonComponent(buttonMenu = welcomeText.buttonMenu, modifier = Modifier.width(150.dp), onClick = {
                                        context.startActivity(Intent(context, CheckupActivity::class.java))
                                    })
                                }

                                Image(painter = painterResource(id = R.drawable.mainpage),
                                    contentDescription = "welcome-greeter",
                                    contentScale = ContentScale.Inside,
                                )

                            }
                        }
                    }
                 }

                 item{
                    if(currentUser.value == null){
                        GuestCard()
                    } else if(currentUser.value != null) {
                        UserCard(
                            name = (currentUser.value?.child("name")?.value as String?) ?: "Rin Erina" ,
                            age = ((currentUser.value?.child("age")?.value as Long?) ?: 23.toLong()).toString()
                        )
                    } else {
                        GuestCard()
                    }
                 }

                 item {
                     GuideCardView()
                 }
                 
                 item{
                     Row(modifier = Modifier
                         .fillMaxWidth()
                         .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                         Text(
                             text = "Read New Articles",
                             fontSize = Constants.LARGE_FONT_SIZE.sp,
                             fontFamily = Constants.FONT_FAMILY_BOLD,
                             color = colorResource(id = Constants.TEXT_COLOR)
                             )

                         Text(
                             text = "See More",
                             fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                             fontFamily = Constants.FONT_FAMILY_MEDIUM,
                             color = colorResource(id = Constants.TEXT_COLOR),
                             modifier = Modifier.clickable {
                                context.startActivity(Intent(context, NewsActivity::class.java))
                             }
                         )
                     }
                 }

                 item {
                     LazyRow(modifier = Modifier.padding(10.dp)){
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
         }

    }
}