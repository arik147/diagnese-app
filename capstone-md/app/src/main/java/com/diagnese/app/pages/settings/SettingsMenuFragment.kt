package com.diagnese.app.pages.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import com.diagnese.app.components.widgets.CenterAppBar

@OptIn(ExperimentalMaterial3Api::class)
class SettingsMenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply { 
            setContent { 
                SettingsMenu()
            }
        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun SettingsMenu(
    modifier : Modifier = Modifier
){
    val context = LocalContext.current
    Scaffold( 
        topBar = {
            CenterAppBar(context = context, title = "Settings")
        }
    ) { paddingValues ->  
        Column(modifier = modifier.padding(paddingValues)) {

        }
    }
    
}
