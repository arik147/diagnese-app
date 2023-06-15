package com.diagnese.app.components.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import com.diagnese.app.utils.Constants

@Composable
fun SearchTextField(
    modifier : Modifier = Modifier,
    label : String,
    value : String = "",
    onValueChange : (String) -> Unit = {},
    onIconClick : () -> Unit = {}
){

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, fontFamily = Constants.FONT_FAMILY_MEDIUM)},
        modifier = modifier.fillMaxWidth(),
        trailingIcon = {
          IconButton(onClick = onIconClick) {
              Icon(Icons.Default.Search, contentDescription = "icon-search")
          }
        },
        shape = Constants.ROUNDED_RADIUS
    )

}