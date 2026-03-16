package br.com.fiap.ecobairro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.ecobairro.screens.newsScreen
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoBairroTheme {
                //LoginScreen
                newsScreen()
            }

            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcoBairroTheme {
        newsScreen()
    }
}