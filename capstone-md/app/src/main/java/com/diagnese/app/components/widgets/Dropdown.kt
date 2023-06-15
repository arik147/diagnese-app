package com.diagnese.app.components.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Filter
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Dropdown(
    modifier : Modifier = Modifier,
    content : @Composable () -> Unit,
) {

    var showDropdownMenu by remember { mutableStateOf(false) }

    IconButton(onClick = { showDropdownMenu = !showDropdownMenu }) {
        Icon(Icons.Default.Filter, contentDescription = "filter-icon", tint = Color.White)
    }

   DropdownMenu(
       modifier = modifier.padding(10.dp),
       expanded = showDropdownMenu, onDismissRequest = { showDropdownMenu = false}) {
      content()
   }



}