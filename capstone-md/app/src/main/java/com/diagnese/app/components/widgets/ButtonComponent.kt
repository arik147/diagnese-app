package com.diagnese.app.components.widgets

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.diagnese.app.utils.Constants

@Composable
fun ButtonComponent(
    buttonMenu : String,
    modifier: Modifier = Modifier,
    onClick : () -> Unit = {}
){
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(id = Constants.PRIMARY_COLOR)),
        shape = Constants.ROUNDED_RADIUS,

        modifier = modifier
            .width(200.dp)
    ) {
        Text(text = buttonMenu,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontFamily = Constants.FONT_FAMILY_BOLD,
            )
    }
}