package com.diagnese.app.components.widgets

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.diagnese.app.pages.home.MainActivity
import com.diagnese.app.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAppBar(
    context : Context,
    title : String,
    navIcons : ImageVector = Icons.Default.ArrowBack,
    onNavClick : () -> Unit = { context.startActivity(Intent(context, MainActivity::class.java))},
    actions : @Composable RowScope.() -> Unit = {}
){

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = Constants.XL_FONT_SIZE.sp,
                fontFamily = Constants.FONT_FAMILY_BOLD,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(colorResource(id = Constants.PRIMARY_COLOR)),
        navigationIcon = {
            IconButton(onClick = onNavClick) {
                Icon(navIcons ,tint = Color.White,contentDescription = "icons-close")
            }
        },
        actions = actions
    )

}