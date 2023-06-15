package com.diagnese.app.pages.checkup.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.diagnese.app.R
import com.diagnese.app.components.widgets.ButtonComponent
import com.diagnese.app.components.widgets.CheckupStepSection
import com.diagnese.app.components.widgets.SelectBox
import com.diagnese.app.pages.checkup.CheckupViewModel
import com.diagnese.app.utils.Constants
import org.json.JSONObject

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun CheckOnceScreen(
    modifier : Modifier = Modifier,
    navHostController: NavHostController,
    symptomsValue : String,
    viewModel : CheckupViewModel,
    feels : Int
){

    val parseJSON = "{\"$symptomsValue\": $feels }"



    Scaffold {

        LazyColumn(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.blue_400)),
                ) {

                item{
                    CheckupStepSection(text = "Step 3", onButtonClick = {
                        navHostController.navigate("symptoms")
                    })
                }

               item {
                   Text(
                       text = "Check once more before submitting",
                       color = Color.White,
                       fontSize = Constants.XXL_FONT_SIZE.sp,
                       fontFamily = Constants.FONT_FAMILY_BOLD,
                       modifier = Modifier.padding(15.dp)
                   )
               }

                item {
                    TextWithCardLayout(
                        text = "Symptoms : ",
                        modifier = Modifier
                            .padding(15.dp)
                            .height(300.dp)
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            SelectBox(text = symptomsValue)
                        }
                    }
                }


               item{
                   ButtonComponent(buttonMenu = stringResource(id = R.string.next), modifier = Modifier
                       .fillMaxWidth()
                       .padding(15.dp), onClick = {
                       viewModel.predictDiseaseData(JSONObject(parseJSON))
                        navHostController.navigate("result")
                   })
               }
            }

        }
}



@Composable
fun TextWithCardLayout(
    modifier: Modifier = Modifier,
    text : String,
    cardContent : @Composable () -> Unit
){
    Box(modifier = modifier
        .padding(10.dp)
        .fillMaxWidth()){

        Column {
            Text(
                text = text, color = Color.White,
                fontSize = Constants.XL_FONT_SIZE.sp,
                fontFamily = Constants.FONT_FAMILY_BOLD
            )
            Spacer(modifier = Modifier.height(10.dp))

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
                colors = CardDefaults.cardColors(Color.White)
            ){
                cardContent()
            }
        }
    }


}