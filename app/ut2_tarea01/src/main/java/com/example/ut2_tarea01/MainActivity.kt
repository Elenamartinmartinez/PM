package com.example.ut2_tarea01

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ut2_tarea01.ui.theme.CremaClaro
import com.example.ut2_tarea01.ui.theme.MarronSuave
import com.example.ut2_tarea01.ui.theme.RojoNegativo
import com.example.ut2_tarea01.ui.theme.TextoNormal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Ciclo", "onCreate")
        enableEdgeToEdge()
        setContent { Contador() }
    }
    override fun onStart() {
        super.onStart()
        Log.d("Ciclo", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("Ciclo", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Ciclo", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("Ciclo", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ciclo", "onDestroy")
    }
}

@Composable
fun Contador(modifier: Modifier = Modifier) {
    var contador by rememberSaveable { mutableIntStateOf(0) }
    var pulsaciones by rememberSaveable { mutableIntStateOf(0) }

    Box(modifier = modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fondo1),
            contentDescription = null,
            alpha = 0.4f,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Contador de Elena", fontSize = 24.sp)
            Text(
                text = "$contador",
                fontSize = 56.sp,
                color = if (contador < 0) RojoNegativo else TextoNormal
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick =
                    {contador--; pulsaciones++},
                    colors = ButtonDefaults.buttonColors(containerColor = MarronSuave,
                        contentColor = CremaClaro
                    )

                ) { Text("Restar") }
                Button(onClick = { contador++; pulsaciones++},
                    colors = ButtonDefaults.buttonColors(containerColor = MarronSuave,
                        contentColor = CremaClaro
                    )) { Text("Sumar")}
            }
            Spacer(Modifier.height(8.dp))
            OutlinedButton(
                onClick = { contador = 0; pulsaciones++ },
                border = BorderStroke(1.5.dp, MarronSuave),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MarronSuave)
            ) { Text("Reiniciar") }

            Spacer(Modifier.height(8.dp))
            Text("Pulsaciones de Elena: $pulsaciones")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContadorPreview() {
    MaterialTheme { Contador() }
}