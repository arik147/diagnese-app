package com.diagnese.app.components.widgets


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants

@Composable
fun CheckupStepSection(
    modifier: Modifier = Modifier,
    text : String,
    onButtonClick : () -> Unit
){

    Row(
        modifier = modifier.wrapContentSize(align = Alignment.Center)
    ) {
        IconButton(onClick = onButtonClick) {
            Icon(Icons.Default.ArrowBackIos, tint = Color.White, contentDescription = null)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            fontFamily = Constants.FONT_FAMILY_BOLD,
            fontSize = Constants.XL_FONT_SIZE.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}