package com.diagnese.app.pages.checkup.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.diagnese.app.R
import com.diagnese.app.components.widgets.ButtonComponent
import com.diagnese.app.components.widgets.CheckupStepSection
import com.diagnese.app.components.widgets.Loading
import com.diagnese.app.components.widgets.SelectBox
import com.diagnese.app.core.data.network.disease.Badan
import com.diagnese.app.core.data.network.disease.Hidung
import com.diagnese.app.core.data.network.disease.Kaki
import com.diagnese.app.core.data.network.disease.Kepala
import com.diagnese.app.core.data.network.disease.Kulit
import com.diagnese.app.core.data.network.disease.Leher
import com.diagnese.app.core.data.network.disease.Mata
import com.diagnese.app.core.data.network.disease.Mental
import com.diagnese.app.core.data.network.disease.Mulut
import com.diagnese.app.core.data.network.disease.Pernafasan
import com.diagnese.app.core.data.network.disease.Tangan
import com.diagnese.app.core.data.network.disease.Tenggorokan
import com.diagnese.app.core.data.network.disease.Vital
import com.diagnese.app.pages.checkup.CheckupViewModel
import com.diagnese.app.utils.Constants
import kotlin.reflect.full.memberProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectSymptomScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel : CheckupViewModel,
    navigateToCheckOnce : (String, Int) -> Unit,

){
    val symptomsState = viewModel.symptomsData.observeAsState()


   var isExpanded by remember { mutableStateOf(false ) }
    val context = LocalContext.current

    val symptoms = symptomsState.value?.data?.asMap()

    val dropdownMenuList = symptoms?.keys
    Log.d("dropdown", dropdownMenuList.toString())

    val symptomsList = symptoms?.values?.map{
        when(it){
            is Badan -> it.asMap().entries
            is Hidung -> it.asMap().entries
            is Kaki -> it.asMap().entries
            is Kepala -> it.asMap().entries
            is Kulit -> it.asMap().entries
            is Leher -> it.asMap().entries
            is Mata -> it.asMap().entries
            is Mental -> it.asMap().entries
            is Mulut -> it.asMap().entries
            is Pernafasan -> it.asMap().entries
            is Tangan -> it.asMap().entries
            is Tenggorokan -> it.asMap().entries
            is Vital -> it.asMap().entries
            else -> "Error"
        }
    }
    Log.d("symptomsList", symptomsList.toString())


    var selectedText by remember {
        mutableStateOf("Select the body part")
    }


    var symptomsValue by remember {
        mutableStateOf("")
    }

    var feels by remember{
        mutableStateOf(0)
    }


    Scaffold { paddingValues ->


        LazyColumn(verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = colorResource(id = R.color.blue_400)),) {

                item{
                    CheckupStepSection(text = "Step 2", onButtonClick = {
                        navHostController.navigate("get-started")
                    })
                }

                item {
                    Text(
                        text = "Which part of the body that bothering you ?",
                        color = Color.White,
                        fontSize = Constants.XXL_FONT_SIZE.sp,
                        fontFamily = Constants.FONT_FAMILY_BOLD,
                        modifier = Modifier.padding(15.dp)
                    )
                }

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ){
                        ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
                            isExpanded = !isExpanded
                        }) {
                            TextField(
                                value = selectedText.replaceFirstChar { i -> i.uppercase() },
                                readOnly = true,
                                onValueChange = {},
                                textStyle = TextStyle(
                                    fontFamily = Constants.FONT_FAMILY_BOLD,
                                    fontSize = Constants.MEDIUM_FONT_SIZE.sp
                                ) ,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor(),
                            )

                            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                                dropdownMenuList?.forEach{ item ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                text = item.replaceFirstChar { i -> i.uppercase() },
                                                fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                                                fontFamily = Constants.FONT_FAMILY_BOLD,
                                            )

                                               },
                                        onClick = {
                                            selectedText = item
                                            isExpanded = false

                                        }
                                    )
                                }
                            }

                        }
                    }

                }


                item {
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .height(300.dp), colors = CardDefaults.cardColors(Color.White)) {
 
                        LazyColumn(modifier = Modifier.padding(10.dp)){
                            item {
                                if(symptomsState.value == null){
                                    Loading()
                                } else {
                                    symptomsList?.forEach {
                                        val entry = it as Set<Map.Entry<String, Int>>
                                        entry.forEach { (key, value) ->
                                            SelectBox(text = key) {
                                                symptomsValue = key
                                                feels = value
                                            }
                                            Spacer(modifier = Modifier.height(5.dp))
                                        }

                                    }
                                }
                            }
                        }
                    }
                }

                item {
                    ButtonComponent(buttonMenu = stringResource(id = R.string.next), modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                    ) {
                        if(symptomsValue.isNotEmpty()){
                            navigateToCheckOnce(symptomsValue,feels)
                        } else {
                            Toast.makeText(context, "Select First", Toast.LENGTH_SHORT).show()
                        }
                    }
                }



            }



        }
    }

inline fun <reified T : Any> T.asMap() : Map<String, Any?> {
    val props = T::class.memberProperties.associateBy { it.name }
    return props.keys.associateWith { props[it]?.get(this) }
}




