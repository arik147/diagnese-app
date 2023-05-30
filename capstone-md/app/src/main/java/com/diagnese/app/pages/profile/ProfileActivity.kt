package com.diagnese.app.pages.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.RadioButton
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.diagnese.app.utils.Constants
import com.diagnese.app.R
import com.diagnese.app.components.widgets.ButtonComponent
import com.diagnese.app.components.widgets.CenterAppBar
import com.diagnese.app.components.widgets.ProfileTextField
import com.diagnese.app.pages.home.MainActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
          ProfilePage()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(
    modifier: Modifier = Modifier
){
    val context = LocalContext.current

  Scaffold(
      topBar = {
          CenterAppBar(context = context, title = "Edit Profile")
      }) {
          LazyColumn(
              modifier = modifier.padding(it),
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally) {

              item{
                      Column(
                          modifier = Modifier
                              .fillMaxWidth()
                              .background(colorResource(id = Constants.PRIMARY_COLOR)),
                          verticalArrangement = Arrangement.Center,
                          horizontalAlignment = Alignment.CenterHorizontally
                      ){
                          Image(
                              painter = painterResource(id = R.drawable.ic_launcher_background),
                              contentDescription = "profile-image",
                              modifier = Modifier
                                  .padding(10.dp)
                                  .width(190.dp)
                                  .height(190.dp)
                                  .clip(Constants.ROUNDED_RADIUS)
                          )

                          Spacer(modifier = Modifier.height(10.dp))

                          Text(
                              text = "Change Profile Photo",
                              textDecoration = TextDecoration.Underline,
                              fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                              color = colorResource(id = Constants.TEXT_COLOR),
                              modifier = Modifier
                                  .clickable { }
                                  .padding(bottom = 10.dp),
                              fontFamily = Constants.FONT_FAMILY_BOLD,
                          )
                      }

              }

              item {
                  ProfileTextField(text = "E-mail Address", hintText = "Your E-mail Address" , inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
              }

              item {
                  ProfileTextField(text = "Last Name", hintText = "Your Last Name" , inputType = InputType.TYPE_CLASS_TEXT)
              }

              item {
                  Column(modifier = Modifier
                      .fillMaxWidth()
                      .padding(10.dp)) {

                      Text(
                          text = "Gender",
                          fontFamily = Constants.FONT_FAMILY_BOLD,
                          textAlign = TextAlign.Center,
                          fontSize = Constants.LARGE_FONT_SIZE.sp,
                          color = Color.Gray
                          )

                      Spacer(modifier = Modifier.height(10.dp))

                      Row(modifier = Modifier.fillMaxWidth()){
                          AndroidView(factory = { context ->
                              RadioButton(context).apply {
                                  width
                                  text = "Male"
                              }
                          })

                          AndroidView(factory = { context ->
                              RadioButton(context).apply {
                                  width
                                  text = "Female"
                              }
                          })
                      }
                  }
              }

              item{
                  Column(modifier = Modifier
                      .fillMaxWidth()
                      .padding(10.dp)) {

                      Text(
                          text = "Age",
                          fontFamily = Constants.FONT_FAMILY_BOLD,
                          textAlign = TextAlign.Center,
                          fontSize = Constants.LARGE_FONT_SIZE.sp,
                          color = Color.Gray
                      )

                      Spacer(modifier = Modifier.height(10.dp))

                      Box(modifier = Modifier
                          .width(110.dp)
                          .wrapContentSize(Alignment.BottomStart)){
                          DropdownMenu(expanded = false,
                              modifier = Modifier.background(Color.Gray),
                              onDismissRequest = { }) {
                              for (i in 18..100){
                                  DropdownMenuItem(text = {
                                      Text(text = i.toString(), fontFamily = Constants.FONT_FAMILY_MEDIUM)
                                  }, onClick = { })
                              }
                          }
                      }

                  }
              }

              item {
                  ButtonComponent(buttonMenu = "Save",
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(20.dp),
                      onClick = {
                          context.startActivity(Intent(context, MainActivity::class.java))
                      })
              }



              item {

              }


          }


  }

}


@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}