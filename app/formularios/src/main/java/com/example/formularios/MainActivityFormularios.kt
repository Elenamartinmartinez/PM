package com.example.formularios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formularios.ui.theme.Mi_ProyectoTheme

class MainActivityFormularios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaRegistro()
        }
    }
} //Fin de la clase

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaRegistroPreview() {
    PantallaRegistro()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PantallaRegistro() {
    Mi_ProyectoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FormularioRegistro(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun FormularioRegistro(modifier: Modifier = Modifier){
    var mensaje  by remember {mutableStateOf("")}
    var nombre by remember {mutableStateOf("")}
    var apellido by remember {mutableStateOf("")}
    var email by remember {mutableStateOf("")}
    var clave by remember {mutableStateOf("")}
    var edad by remember {mutableStateOf("")}
    var numero by remember {mutableStateOf("")}

    //Datos para que el usuario pueda registrarse
    Column(
        modifier = modifier
            .padding(16.dp)
            .imePadding() //Para que el teclado no nos estorbe
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text( //Título del registro
            "Registro",
            style = MaterialTheme.typography.headlineMedium
        )
//        TextField(
//            value = nombre,
//            onValueChange = {nombre = it},
//            label = {Text("Nombre")},
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Nombre")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = apellido,
            onValueChange = {apellido = it},
            label = {Text("Apellido")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("email")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = clave,
            onValueChange = {clave = it},
            label = {Text("Contraseña")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = edad,
            onValueChange = {edad = it},
            label = {Text("Edad")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = numero,
            onValueChange = {numero = it},
            label = {Text("Número de teléfono")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {mensaje = "Registrando..."}) {
            Text("Registrarse")
        }
        Text(mensaje)
    }
}