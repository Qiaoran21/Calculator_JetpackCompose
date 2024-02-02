package com.example.calculatorincompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NumberScreen(modifier: Modifier, onValueChange: (String) -> Unit, input: String) {
    TextField(
        value = input,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth()
    )
}