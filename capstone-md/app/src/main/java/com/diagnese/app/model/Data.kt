package com.diagnese.app.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.ui.graphics.vector.ImageVector
import com.diagnese.app.R
import com.google.android.material.switchmaterial.SwitchMaterial

object Data {

    val guideItemList = listOf(
        CardItem(
            image = R.drawable.doctor_1,
            title = "Can't find any Doctor?",
            slug = "Lets Check up with Us",
            buttonMenu = "Search",

        ),
        CardItem(
            image = R.drawable.findhosp,
            title = "See List of Disease",
            slug = "Get to know list of disease here !",
            buttonMenu = ""
        )

    )

    val settingsMenuItem = arrayListOf(
        SettingsMenuItem(
            title = "Account",
            icon = Icons.Default.People,
            isExpandable = true,
            childList = arrayListOf(
                ChildItem(
                    childTitle = "Edit Profile"
                ),
                ChildItem(
                    childTitle = "Change Password"
                ),
                ChildItem(
                    childTitle = "Delete This Account"
                )
            )
        ),

        SettingsMenuItem(
            title = "Notification",
            icon = Icons.Default.Notifications,
            isExpandable = true,
            childList = arrayListOf(
                ChildItem(
                    childTitle = "Notification",
                    switchLabel = "switch"
                )
            )
        ),


        SettingsMenuItem(
            title = "Appearance",
            icon = Icons.Default.Notifications,
            isExpandable = true,
            childList = arrayListOf(
                ChildItem(
                    childTitle = "Dark Mode",
                    switchLabel = "switch"
                )
            )
        ),
        )
}