package com.diagnese.app.components.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.diagnese.app.utils.Constants

@Composable
fun PictureCardComponent(
    imageSrc : String,
    title : String,
){

    Card( modifier = Modifier
        .padding(10.dp)
        .height(190.dp)
        .width(310.dp),
        shape = Constants.CARD_CORNER_RADIUS) {

       Column {
           AsyncImage(model = imageSrc,
               contentDescription = "header-image",
               modifier = Modifier
                   .fillMaxWidth()
                   .height(150.dp)
           )

           Text(text = title, fontSize = Constants.LARGE_FONT_SIZE.sp, fontFamily = Constants.FONT_FAMILY_BOLD)
       }

    }
}