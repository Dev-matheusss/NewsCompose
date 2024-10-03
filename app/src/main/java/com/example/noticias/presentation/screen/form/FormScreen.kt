package com.example.noticias.presentation.screen.form

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showSystemUi = true)
fun FormScreen() {

    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = CenterHorizontally
    ) {
        Forms("Titulo", titulo) {
            titulo = it
        }

        Forms("Descricao", descricao) {
            descricao = it
        }

        Forms("mensagem", mensagem) {
            mensagem = it
        }

        Button(
            onClick = {
                Log.d("Login", "titulo: $titulo, descricao: $descricao mensagem: $mensagem")
            }
        ) {
            Text("nome do button")
        }
    }
}

@Composable
fun Forms(
    label: String,
    email: String,
    onEmailChange: (String) -> Unit
) {
    OutlinedTextField(
        value = email,
        label = { Text(label) },
        onValueChange = {
            onEmailChange(it)
        }
    )
}
