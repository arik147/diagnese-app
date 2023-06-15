package com.diagnese.app.components.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants

@Composable
fun SettingComponent(
    modifier : Modifier = Modifier,
    leading : ImageVector,
    title : String,
    trailing : Any?,
    isChecked : Boolean = false,
    textColor : Color = Color.Black,
    iconColor : Color = colorResource(id = Constants.PRIMARY_COLOR),
    onCheckedChange : (Boolean) -> Unit = {},
    onClick : () -> Unit = {}
){


    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier
        .padding(20.dp)
        .fillMaxWidth()
        .clickable { onClick() }) {
        Icon(
            leading, contentDescription = null, tint = iconColor
        )

        Text(
            text = title,
            fontFamily = Constants.FONT_FAMILY_MEDIUM,
            fontSize = Constants.LARGE_FONT_SIZE.sp,
            textAlign = TextAlign.Start,
            color = textColor
        )

        if(trailing is ImageVector){
            Icon(trailing, contentDescription = null, tint = colorResource(id = Constants.PRIMARY_COLOR))
        } else {
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = colorResource(id = Constants.PRIMARY_COLOR),
                ),
                modifier = Modifier.wrapContentSize()
            )
        }

    }


}