package com.cumaliguzel.onboarding

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.cumaliguzel.onboarding.onboard.OnboardingScreen
import com.cumaliguzel.onboarding.onboard.OnboardingUtils
import com.cumaliguzel.onboarding.ui.theme.OnBoardingTheme

class MainActivity : ComponentActivity() {
    private val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnBoardingTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainContent()
                }
            }
        }
    }

    @Composable
    private fun MainContent() {

        var isOnboardingCompleted by remember { mutableStateOf(onboardingUtils.isOnboardingCompleted()) }

        if (isOnboardingCompleted) {
            ShowHomeScreen()
        } else {
            ShowOnboardingScreen {
                onboardingUtils.setOnboardingCompleted()
                isOnboardingCompleted = true
            }
        }
    }

    @Composable
    private fun ShowHomeScreen() {
        Column {
            Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
        }
    }

    @Composable
    private fun ShowOnboardingScreen(onFinished: () -> Unit) {
        val context = LocalContext.current
        Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
            OnboardingScreen {

                Toast.makeText(context, "Finished", Toast.LENGTH_SHORT).show()
                onFinished()
            }
        }
    }
}
