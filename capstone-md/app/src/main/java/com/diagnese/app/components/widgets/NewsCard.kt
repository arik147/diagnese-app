package com.diagnese.app.components.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.diagnese.app.R
import com.diagnese.app.utils.Constants

@Composable
fun NewsCard(
    modifier : Modifier = Modifier,
    imageUrl : String?,
    title : String,
    onClick : () -> Unit = {},
    onBookmarked : () -> Unit = {},
){

    val isBookmarked by remember {
        mutableStateOf(false)
    }

    Card(modifier = modifier
        .padding(10.dp)
        .width(370.dp)
        .height(250.dp)
        .clickable { onClick() },
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            AsyncImage(model = imageUrl, contentDescription = "news-image", modifier = Modifier
                .fillMaxWidth()
                .height(140.dp))

               Text(
                   text = title,
                   fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                   fontFamily = Constants.FONT_FAMILY_MEDIUM,
               )

               IconButton(onClick = onBookmarked
               ) {
                   if(!isBookmarked){
                       Icon(Icons.Filled.Bookmark, contentDescription = null, tint = colorResource(
                           id = Constants.TEXT_COLOR
                       ))
                   } else {
                       Icon(
                           painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                           tint = colorResource(id = Constants.TEXT_COLOR),
                           contentDescription = null 
                       )
                   }
               }



        }
    }

}