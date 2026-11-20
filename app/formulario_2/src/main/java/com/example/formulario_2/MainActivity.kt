package com.example.formulario_2

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formulario_2.ui.theme.Mi_ProyectoTheme
import org.intellij.lang.annotations.Pattern

class MainActivityFormularios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaRegistro()
        }
    }
} //Fin de la clase

@Composable
fun PantallaRegistroPreview() {
    //PantallaRegistro()
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
    //Botón
    var mensaje  by remember {mutableStateOf("")}
    //Datos a rellenar para el registro
    var nombre by remember {mutableStateOf("")}
    var apellido by remember {mutableStateOf("")}
    var email by remember {mutableStateOf("")}
    var clave by remember {mutableStateOf("")}
    var edad by remember {mutableStateOf("")}
    var numero by remember {mutableStateOf("")}
    //Listas y checkboxs
    var acepta by remember {mutableStateOf(false)}
    val opciones = listOf("Presencial","On-line", "Mixta")
    var modalidad by remember {mutableStateOf(opciones[0])}
    //Errores para campos no válidos
    val nombreError = nombre.isEmpty()
    val emailError = !Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()
    val claveError = clave.length < 6
    var intentoEnvio by remember {mutableStateOf(false)}
    //Formulario válido
    val formularioValido = !nombreError && !emailError && !claveError && acepta

    //Fondo del formulario
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
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
            isError = intentoEnvio && nombreError,
            supportingText = {
                if (intentoEnvio && nombreError) Text("Nombre obligatorio")
            },
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
            isError = intentoEnvio && emailError,
            supportingText = {
                if (intentoEnvio && emailError) Text("Formato de email no válido")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = clave,
            onValueChange = {clave = it},
            label = {Text("Contraseña")},
            singleLine = true,
            isError = intentoEnvio && claveError,
            supportingText = {
                if (intentoEnvio && claveError) Text("Contraseña demasiado corta")
            },
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

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = acepta, onCheckedChange = {acepta = it})
            if (intentoEnvio && !acepta){
                Text("Acepta los terminos")
            }
            Text("Acepto los terminos")
        }

        Text("Modalidad")
        for (opcion in opciones){
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = opcion==modalidad, onClick = {modalidad=opcion})
                Text(opcion)//Pone de una vez los nombres de todas las opciones
            }
        }

        Button(onClick = {intentoEnvio = true}, modifier = Modifier.fillMaxWidth()) {
            Text("Registrarse")
        }

        if (intentoEnvio && formularioValido) {
            Text("Registro correcto")
        }
    }
}