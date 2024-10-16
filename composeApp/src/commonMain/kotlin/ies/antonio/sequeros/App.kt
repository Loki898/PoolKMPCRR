package ies.antonio.sequeros

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import poolkmpcrr.composeapp.generated.resources.Res
import poolkmpcrr.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var metrosCubicos by remember { mutableStateOf("") }
        var ph by remember { mutableStateOf("") }
        var gramos by remember { mutableStateOf("") }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(64.dp)) {
            Row(Modifier.fillMaxWidth(1.0f)) {
                TextField(
                    modifier = Modifier.fillMaxWidth().testTag("metroscubicos"),
                    value = metrosCubicos,
                    label = { Text("Metros cúbicos") },
                    onValueChange = {
                        metrosCubicos = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Number
                    )
                )
            }
            Row(Modifier.fillMaxWidth(1.0f)) {
                TextField(
                    modifier = Modifier.fillMaxWidth().testTag("lecturaph"),
                    value = ph,
                    label = { Text("Lectura PH") },
                    onValueChange = {
                        ph = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Number
                    )
                )
            }
            Row(Modifier.fillMaxWidth(1.0f)) {
                TextField(
                    modifier = Modifier.fillMaxWidth().testTag("gramos"),
                    value = gramos,
                    label = { Text("Gramos") },
                    onValueChange = {
                        gramos = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Number
                    )
                )
            }
            Row() {
                Text(
                    if (metrosCubicos.isNotEmpty() && ph.isNotEmpty() && gramos.isNotEmpty()) {
                        ((7.4 - ph.toString().toDouble()) * 10 * metrosCubicos.toString().toDouble() * gramos.toString().toDouble()).toString()

                    } else {
                        "VACIO"
                    },
                    modifier = Modifier.background(Color.Red).testTag("resultado")
                )
            }

        }

    }
}