package com.diagnese.app.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.ui.graphics.vector.ImageVector

data class SettingsMenuItem(
    val leadingIcon : ImageVector,
    val title : String,
    val trailingIcon : Any? = Icons.Default.ArrowForwardIos
)

