package com.example.contenedores

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contenedores.ui.theme.Mi_ProyectoTheme




class MainActivityContenedores : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mi_ProyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MiComposable(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}




@Composable
fun MiComposable(modifier: Modifier = Modifier) {
//    Row(modifier = Modifier.fillMaxSize().padding(16.dp), verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceAround) {
//        Text(
//            text = "Hello",
//            modifier = modifier.background(Color.Blue)
//        )
//
//        Text(
//            text = "Hello",
//            modifier = modifier.background(Color.Yellow)
//        )
//
//        Text(
//            text = "Hello",
//            modifier = modifier.background(MaterialTheme.colorScheme.secondary)
//        )
//    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        repeat(30){ i ->
            Text(
                text = "elemento $i",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MiComposablePreview() {
    Mi_ProyectoTheme {
        MiComposable()
    }
}
