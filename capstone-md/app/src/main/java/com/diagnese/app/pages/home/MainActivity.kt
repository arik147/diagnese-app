package com.diagnese.app.pages.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.diagnese.app.components.widgets.GuideCardView
import com.diagnese.app.components.widgets.UserCard
import com.diagnese.app.model.CardItem
import com.diagnese.app.pages.settings.SettingsActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface( modifier = Modifier.fillMaxSize(),
                color = colorResource(id = Constants.PRIMARY_COLOR)){
                MainPage()
            }
      }
}
}

@Composable
fun MainPage(){

    val context = LocalContext.current

    Scaffold( 
        topBar = {
           CenterAppBar(
               context = context,
               title = "Good Morning".uppercase(),
               navIcons = Icons.Outlined.Bookmark,
               onNavClick = {},
               actions = {
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
           )
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
                                    ButtonComponent(buttonMenu = welcomeText.buttonMenu, modifier = Modifier.width(150.dp))
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
                     UserCard()
                 }

                 item {
                     GuideCardView()
                 }


             }
         }

    }
}