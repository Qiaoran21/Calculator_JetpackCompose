package com.example.calculatorincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorincompose.ui.theme.CalculatorInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorPreview()
                }
            }
        }
    }
}

@Composable
fun Calculator() {
    var numberOne by remember { mutableStateOf("") }
    var numberTwo = ""
    var result = ""
    var action = ""

    CalculatorInComposeTheme {
        Column {
            NumberScreen(modifier = Modifier, onValueChange = { numberOne = it }, input = numberOne)
            Buttons(
                modifier = Modifier,
                onNumberClick = { numberOne += it },
                onOperatorClick = {
                    numberTwo = numberOne
                    numberOne = ""
                    action = it
                },
                onClearClick = { numberOne = "" },
                onEqualClick = {
                    if (numberOne.isNotEmpty() && numberTwo.isNotEmpty() && action.isNotEmpty()) {
                        when (action) {
                            "+" -> result = (numberTwo.toDouble() + numberOne.toDouble()).toString()
                            "-" -> result = (numberTwo.toDouble() - numberOne.toDouble()).toString()
                            "/" -> result = (numberTwo.toDouble() / numberOne.toDouble()).toString()
                            "*" -> result = (numberTwo.toDouble() * numberOne.toDouble()).toString()
                        }
                        numberOne = result
                        numberTwo = ""
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorInComposeTheme {
        Calculator()
    }
}