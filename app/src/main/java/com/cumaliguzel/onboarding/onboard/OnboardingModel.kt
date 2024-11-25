package com.cumaliguzel.onboarding.onboard

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cumaliguzel.onboarding.R


sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,

) {

    data object FirstPage : OnboardingModel(
        image = R.drawable.weather_intro_1,
        title = "What Should You Wear Today?",
        description = "Do you sometimes wonder what to wear? Let us help you decide and make your day stress-free!",


    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.weather_intro_2,
        title = "Check the Weather, Pick Your Outfit",
        description = "Our app suggests the perfect outfit combinations based on the weather, so you can stay stylish and comfortable every day!"
    )

    data object ThirdPages : OnboardingModel(
        image = R.drawable.weather_intro_3,
        title = "We've Left a Link for You",
        description = "Easily access the outfits you like and similar items with a simple link, making shopping for your favorite pieces hassle-free"
    )
    data object ForthPages : OnboardingModel(
        image = R.drawable.weather_intro_4,
        title = "Let’s Start",
        description = "You’re ready to explore and start!Let's go"
    )


}