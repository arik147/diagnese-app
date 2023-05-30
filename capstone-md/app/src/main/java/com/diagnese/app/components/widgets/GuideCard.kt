package com.diagnese.app.components.widgets


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diagnese.app.utils.Constants
import com.diagnese.app.R
import com.diagnese.app.model.Data

@Composable
fun GuideCard(
    modifier: Modifier = Modifier,
    image : Int,
    title : String,
    slug : String,
    buttonMenu : String
){
    val context = LocalContext.current

    Card(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .conditional(buttonMenu.isNotEmpty(),
            isTrue = {
                  height(180.dp)
            },
                isFalse = {
                    height(120.dp)
                }
            ),
        shape = Constants.CARD_CORNER_RADIUS,
    ){
        Row(
            modifier = Modifier.padding(15.dp),
            horizontalArrangement = Arrangement.Center
            ) {
            Image(painter = painterResource(id = image),
                modifier = Modifier
                    .conditional(
                        buttonMenu.isNotEmpty(),
                        isTrue = {
                            height(168.dp)
                            width(168.dp)
                        },
                        isFalse = {
                            height(120.dp)
                            width(120.dp)
                        }
                    )
                    .padding(top = 10.dp),
                contentDescription = "Guide Image"
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = title,
                    fontSize = Constants.XL_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_MEDIUM,

                    )

                Text(
                    text = slug,
                    fontSize = Constants.MEDIUM_FONT_SIZE.sp,
                    fontFamily = Constants.FONT_FAMILY_MEDIUM,

                    )

                Spacer(modifier = Modifier.height(10.dp))

                if(buttonMenu.isNotEmpty()){
                    ButtonComponent(buttonMenu = buttonMenu, onClick = {})
                }
            }
        }

    }
}

internal fun Modifier.conditional(
   condition : Boolean,
   isTrue: Modifier.() -> Modifier,
   isFalse : Modifier.() -> Modifier
) : Modifier{
   return if(condition){
       then(isTrue(Modifier))
   } else {
       then(isFalse(Modifier))
   }
}


@Composable
fun GuideCardView(){

   Column {
       Data.guideItemList.forEach{ item ->
           GuideCard(image = item.image,
               title = item.title,
               slug = item.slug,
               buttonMenu = item.buttonMenu
           )
       }
   }
}



@Preview(showBackground = true)
@Composable

fun GuideCardPreview(){
    MaterialTheme{
        GuideCard(image = R.drawable.ic_launcher_background, title = "Title", slug = "Slug", buttonMenu = "Test" )
    }
}