package com.diagnese.app.components.navigation

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants
import com.diagnese.app.components.widgets.ButtonComponent
import com.diagnese.app.model.LandingScreen
import com.diagnese.app.pages.auth.AuthActivity
import com.diagnese.app.pages.home.MainActivity

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandingPager() {
    val landingScreen = listOf(
        LandingScreen.PageOne,
        LandingScreen.PageTwo,
        LandingScreen.PageThree
    )

    val pagerState = rememberPagerState()

    HorizontalPager(pageCount = landingScreen.size, state = pagerState) { position ->
        LandingScreen(landingScreen = landingScreen[position])

    }
}

@Composable
fun LandingScreen(
    landingScreen: LandingScreen,
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = Constants.PRIMARY_COLOR),
                    Color.White,
                    colorResource(id = Constants.PRIMARY_COLOR)
                )
            )
        )
    ){
        val context = LocalContext.current
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


           item {
               Text(
                   modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp),
                   text = landingScreen.title,
                   style = MaterialTheme.typography.headlineLarge,
                   textAlign = TextAlign.Center,
                   color = Color.White,
                   fontFamily = Constants.FONT_FAMILY_BOLD,
               )
           }


          item {
              Image(
                  painter = painterResource(id = landingScreen.image),
                  contentDescription = "landing-image",
                  modifier = Modifier
                      .height(480.dp)
                      .width(180.dp)
                      .padding(20.dp)

              )
          }

            if (landingScreen is LandingScreen.PageThree) {

               item {
                   Column{
                       Button(
                           onClick = { context.startActivity(Intent(context, MainActivity::class.java))},
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(10.dp),
                           shape = Constants.ROUNDED_RADIUS,
                           colors = ButtonDefaults.buttonColors(Color.White),
                           border = BorderStroke(1.dp, colorResource(id = Constants.TEXT_COLOR)),
                           content = {
                               Text(text = "Continue as Guest",
                                   style = MaterialTheme.typography.bodyLarge,
                                   fontFamily = Constants.FONT_FAMILY_BOLD,
                                   color = colorResource(id = Constants.TEXT_COLOR)
                               )
                           }
                       )

                       ButtonComponent(
                           buttonMenu = landingScreen.description,
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(10.dp),
                           onClick = {
                               context.startActivity(Intent(context, AuthActivity::class.java))
                           }
                       )
                   }
               }

            } else {
               item {
                   Text(
                       modifier = Modifier.padding(20.dp),
                       text = landingScreen.description,
                       fontSize = Constants.XL_FONT_SIZE.sp,
                       textAlign = TextAlign.Center,
                       color = Color.White,
                       fontFamily = Constants.FONT_FAMILY_BOLD,
                   )
               }


            }


        }
    }
}