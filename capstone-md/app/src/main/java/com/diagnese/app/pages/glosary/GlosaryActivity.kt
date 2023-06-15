package com.diagnese.app.pages.glosary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.components.widgets.CenterAppBar
import com.diagnese.app.components.widgets.DiseaseHeader
import com.diagnese.app.components.widgets.Dropdown
import com.diagnese.app.components.widgets.SearchTextField
import dagger.hilt.android.AndroidEntryPoint
import com.diagnese.app.utils.Constants

@AndroidEntryPoint
class GlosaryActivity : AppCompatActivity() {

    private val glosaryViewModel by viewModels<GlosaryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
           GlosaryPage(viewModel = glosaryViewModel)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GlosaryPage(
    modifier : Modifier = Modifier,
    viewModel: GlosaryViewModel
){
    val context = LocalContext.current

    val query by viewModel.query
    val listState = rememberLazyListState()
    val sortByAlphabet by viewModel.sortByAlphabet.collectAsState()


    Scaffold(
        topBar = {
            CenterAppBar(context = context, title = "List of Disease") {
                Dropdown {
                    Text(
                        text = "Sort by Descending ( Z - A )",
                        fontFamily = Constants.FONT_FAMILY_BOLD
                    )
                    Text(
                        text = "Sort by Ascending ( A - Z )",
                        fontFamily = Constants.FONT_FAMILY_BOLD
                    )
                }
            }
        }
    ) {   paddingValues ->
       Column(modifier = modifier
           .padding(paddingValues)
           .fillMaxSize()) {

           SearchTextField(
               value = query,
               label = "Search for Glosary...",
               modifier = Modifier.padding(10.dp),
               onValueChange = viewModel::search,
               onIconClick = {
                   viewModel.search(query)
               }
           )

           LazyColumn(
               modifier = Modifier.padding(10.dp),
               state = listState,
               contentPadding = PaddingValues(bottom = 80.dp)
           ){

               sortByAlphabet?.forEach { (initial, diseaseData) ->
                      stickyHeader {
                          DiseaseHeader(header = initial)
                      }
                      items(diseaseData, key = { it.prognosis}){ item ->
                          Text(
                              text = item.prognosis,
                              fontFamily = Constants.FONT_FAMILY_BOLD,
                              fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                              modifier = Modifier
                                  .clickable {
                                      val intent =
                                          Intent(context, GlosaryDetailActivity::class.java)
                                      intent.putExtra("prognosis", item.prognosis)
                                      intent.putExtra("description", item.deskripsi)
                                      context.startActivity(intent)
                                  }
                                  .padding(10.dp)
                                  .animateItemPlacement(tween(durationMillis = 100))
                          )
                          Divider(color = Color.LightGray)
                      }
                  }



           }


       }
    }
}




