package com.example.mi_proyecto

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mi_proyecto.ui.theme.Mi_ProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mi_ProyectoTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        //name = "Elena",
//                        modifier = Modifier.padding(innerPadding)
                    )
//                }
            }
        }
    }
}

@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//            .border(4.dp, Color.Black)
//            .background(MaterialTheme.colorScheme.primary)
//            .padding(90.dp)
//            .fillMaxWidth(),
//        fontSize = 48.sp,
//        fontWeight = FontWeight.W800,
//        //color = Color.White,
//        color = MaterialTheme.colorScheme.onPrimaryContainer,
//        style = MaterialTheme.typography.bodySmall
//    )
//}

fun Greeting() {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(32.dp)
        .background(Color.Yellow),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Primero"
        )
        Text(
            text = "Segundo"
        )
        Text(
            text = "Tercero"
        )
    }

    Row() {

    }
}

@Preview(showBackground = true, showSystemUi = false, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Modo oscuro")
@Composable
fun GreetingPreview() {
    Mi_ProyectoTheme {
        //Greeting("Android")
        Greeting()
    }
}
@Preview(showBackground = true, showSystemUi = false, uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Modo claro")
@Composable
fun GreetingPreview2() {
    Mi_ProyectoTheme {
        //Greeting("Android")
        Greeting()
    }
}