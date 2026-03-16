package br.com.fiap.ecobairro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.ecobairro.navigation.NavigationRoute
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoBairroTheme {
                NavigationRoute()
            }

            }
        }
    }


