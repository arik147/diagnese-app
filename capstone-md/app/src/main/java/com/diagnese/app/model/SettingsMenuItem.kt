package com.diagnese.app.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.google.android.material.switchmaterial.SwitchMaterial

data class SettingsMenuItem(
    val title : String,
    val isExpandable : Boolean = false,
    val icon : ImageVector,
    val childList : ArrayList<ChildItem>
)

data class ChildItem(
    val childTitle : String,
    val switchLabel : String? = null
)
