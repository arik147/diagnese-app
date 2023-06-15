package com.diagnese.app.components.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.diagnese.app.utils.Constants

@Composable
fun Loading(
    modifier : Modifier = Modifier,
){
    Box(modifier = modifier.wrapContentSize(align = Alignment.Center)){
        CircularProgressIndicator(
            color = colorResource(id = Constants.PRIMARY_COLOR)
        )
    }
}