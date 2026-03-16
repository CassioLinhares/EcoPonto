package br.com.fiap.ecobairro.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.R
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme
import br.com.fiap.ecobairro.navigation.NavigationRoute
import br.com.fiap.ecobairro.navigation.Destination

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.vector),
                contentDescription = "Fundo verde",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.matchParentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LoginLogoImage()

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "EcoBairro",
                    color = MaterialTheme.colorScheme.surface,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        TitleComponent()

        Spacer(modifier = Modifier.weight(1f))

        ButtonsComponent(navController)

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Ao entrar ou se cadastrar, você concorda com nossos Termos de Serviço e Política de Privacidade",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun Wave(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.vector),
        contentDescription = "Fundo verde",
        contentScale = ContentScale.FillWidth,
        modifier = modifier.fillMaxWidth()
    )
}


@Preview
@Composable
private fun loginScreenPreview() {
    EcoBairroTheme {
        LoginScreen(rememberNavController())
    }

}

@Composable
fun TitleComponent(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.bem_vindo),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.reciclar_cuidar_da_nossa_casa),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium
        )
    }
}


@Composable
fun LoginLogoImage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            )
    {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "imagem do logotipo",
            modifier = Modifier
                .size(200.dp)
        )
    }
}

@Composable
fun ButtonsComponent(navController: NavController) {
    val ecoGreen = Color(0xFF00C86F) // lembrar de padronizar as cores usando o matherial theme , não consigo ajusta-lo

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button (
            onClick = {
                navController.navigate(Destination.SignupScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ecoGreen),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "Entrar",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.surface
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton (
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = ecoGreen),
            border = BorderStroke(2.dp, ecoGreen),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "Registrar-se",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}