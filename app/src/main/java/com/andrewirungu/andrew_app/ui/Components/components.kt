package com.andrewirungu.andrew_app.ui.Components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.andrewirungu.andrew_app.R

@Composable
fun LottieAnimationWidget(lottiepath: Int, size: Dp) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(lottiepath))
    val progress by animateLottieCompositionAsState(composition,
        iterations = LottieConstants.IterateForever  // continuous loop
        )
    LottieAnimation(

        composition = composition,
        progress = { progress },
        modifier = Modifier.size(300.dp)
    )
}