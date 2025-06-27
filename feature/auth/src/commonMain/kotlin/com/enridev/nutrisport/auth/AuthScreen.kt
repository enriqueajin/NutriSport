package com.enridev.nutrisport.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.enridev.nutrisport.auth.component.GoogleButton
import com.enridev.nutrisport.shared.Alpha
import com.enridev.nutrisport.shared.BebasNeueFont
import com.enridev.nutrisport.shared.FontSize
import com.enridev.nutrisport.shared.Surface
import com.enridev.nutrisport.shared.TextPrimary
import com.enridev.nutrisport.shared.TextSecondary

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Surface)
                .padding(padding)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "NUTRISPORT",
                    textAlign = TextAlign.Center,
                    fontFamily = BebasNeueFont(),
                    fontSize = FontSize.EXTRA_LARGE,
                    color = TextSecondary
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(Alpha.HALF),
                    text = "Sign in to continue",
                    textAlign = TextAlign.Center,
                    fontSize = FontSize.EXTRA_REGULAR,
                    color = TextPrimary,

                )
            }
            GoogleButton {  }
        }
    }
}