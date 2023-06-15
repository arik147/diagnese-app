package com.diagnese.app.components.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.window.Dialog
import com.diagnese.app.utils.Constants

@Composable
fun Dialogue(
    title : String,
    modifier : Modifier = Modifier,
    onYesActionClick : () -> Unit = {},
    onNoActionClick : () -> Unit = {}
){

    Dialog(onDismissRequest = { }) {
        Card( shape = Constants.BUTTON_CORNER_RADIUS, modifier = modifier
            .width(300.dp)
            .height(400.dp) ) {

             Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                 .fillMaxSize()
                 .padding(20.dp)) {

                 Text(
                     text = title,
                     fontFamily = Constants.FONT_FAMILY_BOLD,
                     fontSize = Constants.XL_FONT_SIZE.sp
                 )

                 Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                     ButtonComponent(buttonMenu = "Logout", onClick = onYesActionClick)
                     ButtonComponent(buttonMenu = "Cancel", onClick = onNoActionClick)
                 }
             }
        }
    }
    
}