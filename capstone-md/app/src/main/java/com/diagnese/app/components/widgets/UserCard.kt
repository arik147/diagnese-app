package com.diagnese.app.components.widgets

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants
import com.diagnese.app.R
import com.diagnese.app.pages.auth.AuthActivity
import com.diagnese.app.pages.profile.ProfileActivity

@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    name : String,
    age : String
){
    val context = LocalContext.current

    Card( modifier = modifier
        .padding(15.dp)
        .fillMaxWidth()
        .height(95.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(30.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Avatar Image",
                modifier = Modifier
                    .clip(Constants.ROUNDED_RADIUS)
                    .height(80.dp)

            )

            Column{
                Text(
                    text = name,
                    fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_BOLD,
                    color = colorResource(id = Constants.TEXT_COLOR)
                )

                Text(
                    text = "$age Years Old",
                    fontSize = Constants.SMALL_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_BOLD,
                    color = colorResource(id = Constants.TEXT_COLOR)
                    )
            }

            Text(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .clickable {
                        context.startActivity(Intent(context, ProfileActivity::class.java))

                    },
                text = stringResource(R.string.edit_profile),
                fontSize = Constants.SMALL_FONT_SIZE.sp,
                color = colorResource(id = Constants.TEXT_COLOR),
                fontFamily = Constants.FONT_FAMILY_BOLD,

                )

        }
    }
}

@Composable
fun GuestCard(
    modifier: Modifier = Modifier,
){
    val context = LocalContext.current

    Card( modifier = modifier
        .padding(15.dp)
        .fillMaxWidth()
        .clickable { context.startActivity(Intent(context, AuthActivity::class.java)) }
        .height(85.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(30.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Avatar Image",
                modifier = Modifier
                    .clip(Constants.ROUNDED_RADIUS)
                    .height(80.dp)

            )
            
            Spacer(modifier = Modifier.width(25.dp))

            Text(
                    text = "Login/Signup",
                    fontSize = Constants.LARGE_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_BOLD,
                    color = colorResource(id = Constants.TEXT_COLOR)
                )



        }
    }
}