package com.diagnese.app.components.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants

@Composable
fun DiseaseHeader(
    header : Char,
    modifier : Modifier = Modifier
){
    Surface(modifier = modifier.fillMaxWidth()) {
        Text(
            text = header.toString(),
            fontFamily = Constants.FONT_FAMILY_BOLD,
            fontSize = Constants.LARGE_FONT_SIZE.sp,
            color = colorResource(id = Constants.TEXT_COLOR)
        )
    }
}
