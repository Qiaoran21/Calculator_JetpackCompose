package com.example.calculatorincompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(text: String, modifier: Modifier, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(text) },
        modifier = Modifier
            .size(100.dp)
            .padding(5.dp)
    ) {
        Text(text = text, fontSize = 20.sp)
    }
}

@Composable
fun ClearButton(modifier: Modifier, onClearClick: () -> Unit) {
    Button(
        onClick = { onClearClick() },
        modifier = Modifier
            .size(100.dp)
            .padding(5.dp)
    ) {
        Text(text = "C", fontSize = 20.sp)
    }
}

@Composable
fun EqualButton(modifier: Modifier, onEqualClick: () -> Unit) {
    Button(
        onClick = { onEqualClick() },
        modifier = Modifier
            .size(100.dp)
            .padding(5.dp)
    ) {
        Text(text = "=", fontSize = 20.sp)
    }
}

@Composable
fun Buttons(
    modifier: Modifier = Modifier,
    onNumberClick: (String) -> Unit,
    onOperatorClick: (String) -> Unit,
    onClearClick: () -> Unit,
    onEqualClick: () -> Unit
) {
    val numbersListOne = listOf("7", "8", "9")
    val numbersListTwo = listOf("4", "5", "6")
    val numbersListThree = listOf("1", "2", "3")

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        ClearButton(modifier = modifier, onClearClick = { onClearClick() })
        for (number in numbersListOne) {
            Button(text = number, modifier = modifier, onClick = { onNumberClick(it) })
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(text = "/", modifier = modifier, onClick = { onOperatorClick(it)} )
        for (number in numbersListTwo) {
            Button(text = number, modifier = modifier, onClick = { onNumberClick(it) })
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(text = "*", modifier = modifier, onClick = { onOperatorClick(it)} )
        for (number in numbersListThree) {
            Button(text = number, modifier = modifier, onClick = { onNumberClick(it) })
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(text = "-", modifier = modifier, onClick = { onOperatorClick(it)} )
        Button(text = "+", modifier = modifier, onClick = { onOperatorClick(it)} )
        Button(text = "0", modifier = modifier, onClick = { onNumberClick(it) })
        EqualButton(modifier = modifier, onEqualClick = { onEqualClick()} )
    }
}