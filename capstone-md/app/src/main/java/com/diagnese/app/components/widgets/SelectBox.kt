package com.diagnese.app.components.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants

@Composable
fun SelectBox(
    modifier : Modifier = Modifier,
    text : String,
    onClick : () -> Unit = {},
){
    
    Card(modifier = modifier
        .fillMaxWidth()
        .height(50.dp)
        .clickable { onClick() }, shape = Constants.ROUNDED_RADIUS) {
        Row (modifier = Modifier.padding(8.dp)){
           Icon(Icons.Default.Check, contentDescription = null, tint = colorResource(id = Constants.TEXT_COLOR))
           
            Spacer(modifier = Modifier.width(10.dp))
            
            Text(
                text = text,
                fontFamily = Constants.FONT_FAMILY_BOLD,
                fontSize = Constants.MEDIUM_FONT_SIZE.sp
            )
            
        }
    }

}