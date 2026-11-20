package com.example.demo_textview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_textview.ui.theme.Mi_ProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mi_ProyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "DEMO TEXTVIEW",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Ejemplos",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 56.sp,
                fontFamily = FontFamily.Serif
            )
            Titulo("1. Cambiar color")
            Text(
                text = "Texto color verde azulado",
                fontSize = 20.sp,
                color = Color(0xFF009688)
            )
            Titulo("2. Cambiar tamaño")
            Text(text = "Tamaño de 14sp", fontSize = 14.sp)
            Text(text = "Tamaño de 16sp", fontSize = 16.sp)
            Text(text = "Tamaño de 20sp", fontSize = 20.sp)
            Text(text = "Tamaño de 24sp", fontSize = 24.sp)

            Titulo("3. Cambiar estilo de fuente")
            Text(text = "Estilo normal", fontSize = 20.sp)
            Text(
                text = "Estilo en negrita",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Estilo cursiva",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = "Estilos cursiva y negrita",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            Titulo("4. Cambiar tipo de fuente")
            Text(
                text = "Tipo de fuente sans",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = "Tipo de fuente serif",
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )
            Text(
                text = "Tipo de fuente monospace",
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace
            )
            Titulo("5. Convertir urls en links clickeables")
            Text(
                text = buildAnnotatedString {
                    withLink(
                        LinkAnnotation.Url(
                            url = "https://developer.android.com",
                            styles = TextLinkStyles(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    textDecoration = TextDecoration.Underline
                                )
                            )
                        )
                    ) {
                        append("https://developer.android.com")
                    }
                },
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun Titulo(texto: String) {
    Text(
        text = texto,
        modifier = Modifier.padding(top = 24.dp),
        fontSize = 40.sp,
        lineHeight = 46.sp
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Mi_ProyectoTheme {
        Greeting()
    }
}