package com.diagnese.app.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.SwitchDefaults

import com.diagnese.app.R


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

    val settingsMenuItem = listOf(
        SettingsMenuItem(
            leadingIcon = Icons.Default.Edit,
            title = "Edit Profile",
        ),

        SettingsMenuItem(
            leadingIcon = Icons.Default.Lock,
            title = "Change Password",
        ),

        SettingsMenuItem(
            leadingIcon = Icons.Default.Notifications,
            title = "Turn On Notifications",
            trailingIcon = SwitchDefaults
        ),

        SettingsMenuItem(
            leadingIcon = Icons.Default.Shield,
            title = "Privacy and Security",
        ),

        SettingsMenuItem(
            leadingIcon = Icons.Default.SupportAgent,
            title = "Help Center",

        ),

        SettingsMenuItem(
            leadingIcon = Icons.Default.Help,
            title = "About",
        ),

    )
}