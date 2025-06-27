package com.enriquedev.nutrisport

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.enridev.navigation.NavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavGraph()
    }
}