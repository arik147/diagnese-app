package com.diagnese.app.components.widgets


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.diagnese.app.utils.Constants
import com.google.android.material.textfield.TextInputEditText

@Composable
fun ProfileTextField(
    text : String,
    hintText : String,
    inputType: Int,
    value : String
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        Column {

            Text(text = text,
                fontSize = Constants.LARGE_FONT_SIZE.sp,
                fontFamily = Constants.FONT_FAMILY_BOLD,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
            AndroidView(
                modifier = Modifier.fillMaxWidth(),
                factory = { context ->
                    TextInputEditText(context).apply {
                        hint = hintText
                        setText(value)
                        setInputType(inputType)
                     }
                })
        }
    }

}