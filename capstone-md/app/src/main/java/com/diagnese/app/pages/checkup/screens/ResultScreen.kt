package com.diagnese.app.pages.checkup.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.diagnese.app.R
import com.diagnese.app.components.widgets.ButtonComponent
import com.diagnese.app.components.widgets.CheckupStepSection
import com.diagnese.app.pages.checkup.CheckupViewModel
import com.diagnese.app.pages.home.MainActivity
import com.diagnese.app.utils.Constants

@Composable
fun ResultScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: CheckupViewModel
) {

    val predictResponse = viewModel.predictResponse.observeAsState()
    val context = LocalContext.current

    val response = predictResponse.value?.data
    Log.d("response", response.toString())


    Scaffold {
        LazyColumn(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .background(
                    colorResource(id = R.color.blue_400)
                )
        ) {

            item {
                CheckupStepSection(text = "Step 4", onButtonClick = {})
            }

            item {
                Text(
                    text = "Your Result is Out",
                    color = Color.White,
                    fontSize = Constants.XXL_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_BOLD,
                    modifier = Modifier.padding(15.dp)
                )
            }

            item {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        item{
                            Text(
                                text = "Infeksi saluran kemih",
                                fontSize = Constants.XL_FONT_SIZE.sp,
                                fontFamily = Constants.FONT_FAMILY_BOLD,
                                modifier = Modifier.padding(15.dp)
                            )
                        }

                        item{
                            Text(
                                text = "Kondisi yang terjadi ketika bakteri atau mikroorganisme lainnya menginfeksi bagian saluran kemih, yaitu organ-organ yang berperan dalam produksi, penyimpanan, dan pengeluaran urin dari tubuh.",
                                fontSize = Constants.LARGE_FONT_SIZE.sp,
                                fontFamily = Constants.FONT_FAMILY_BOLD,
                                modifier = Modifier.padding(15.dp)
                            )
                        }

                    }
                }

            }

            item{
                Text(
                    text = "Spesialis Penyakit Ginjal dan Urologi",
                    fontSize = Constants.LARGE_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_BOLD,
                    modifier = Modifier.padding(15.dp)
                )
            }

            item{
                ButtonComponent(buttonMenu = "Back to Main", modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                    onClick = {
                        context.startActivity(Intent(context, MainActivity::class.java))
                    }
                )
            }

        }

    }
}