package com.diagnese.app.pages.checkup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.diagnese.app.R
import com.diagnese.app.components.widgets.ButtonComponent
import com.diagnese.app.utils.Constants

@Composable
fun GetStartedScreen(
  modifier : Modifier = Modifier,
  navHostController: NavHostController
){
    Scaffold {

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.blue_400)),) {

                Text(
                    text = "Let's get Started",
                    color = Color.White,
                    fontSize = Constants.XXL_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_BOLD,
                    modifier = Modifier.padding(15.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.stethoscope),
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(23f)
                        .height(350.dp)
                        .width(352.dp)
                        .padding(15.dp)

                )

                ButtonComponent(buttonMenu = stringResource(id = R.string.next),
                    modifier = Modifier.fillMaxWidth().padding(15.dp),
                onClick = {
                    navHostController.navigate("symptoms")
                }
                )


            }

        }
}

