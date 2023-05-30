package com.diagnese.app.model

import com.diagnese.app.R

sealed class LandingScreen(
    val title : String,
    val image : Int,
    val description : String
){
    object PageOne : LandingScreen(
        title = "Say Hello To Diagnese",
        image = R.drawable.landingpage_1,
        description = "Your Trusted Health Companion"
    )

    object PageTwo : LandingScreen(
        title = "Discover the future of Self Diagnosis",
        image = R.drawable.landingpage_2,
        description = "Diagnese is here to guide you on your journey towards better health"
    )
    object PageThree : LandingScreen(
        title = "Trustworthy information at your fingertips",
        image = R.drawable.landingpage_3,
        description = "Let's get Started"
    )
}
