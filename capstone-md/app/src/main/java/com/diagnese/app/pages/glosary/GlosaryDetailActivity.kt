package com.diagnese.app.pages.glosary


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.components.widgets.CenterAppBar
import com.diagnese.app.utils.Constants
import com.diagnese.app.utils.findActivity

class GlosaryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlosaryDetailPage()
        }
    }
}

@Composable
fun GlosaryDetailPage(
    modifier : Modifier = Modifier
){
    val context = LocalContext.current
    val intent = context.findActivity()?.intent

    val prognosis = intent?.getStringExtra("prognosis")
    val description = intent?.getStringExtra("description")

    Scaffold(
        topBar = {
            CenterAppBar(context = context, title = "Detail", onNavClick = { context.startActivity(
                Intent(context, GlosaryActivity::class.java)
            )})
        }
    ) { paddingValues ->
        Box( modifier = modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(colorResource(id = Constants.PRIMARY_COLOR))){
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = prognosis ?: "Prognosis",
                    color = colorResource(id = Constants.TEXT_COLOR),
                    fontSize = Constants.XXL_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_BOLD,
                    textAlign = TextAlign.Center
                )

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(300.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = description ?: "Description",
                        color = colorResource(id = Constants.TEXT_COLOR),
                        fontSize = Constants.XL_FONT_SIZE.sp,
                        fontFamily = Constants.FONT_FAMILY_MEDIUM
                    )
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = Constants.ROUNDED_RADIUS,
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(1.dp, colorResource(id = Constants.TEXT_COLOR)),
                    content = {
                        Row{
                            Icon(
                                Icons.Default.Share,
                                tint = colorResource(id = Constants.TEXT_COLOR),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(text = "Share",
                                style = MaterialTheme.typography.bodyLarge,
                                fontFamily = Constants.FONT_FAMILY_BOLD,
                                color = colorResource(id = Constants.TEXT_COLOR)
                            )
                        }
                    }
                )




            }
        }

    }
}

