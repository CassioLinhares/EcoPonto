package br.com.fiap.ecobairro.components

import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyBottomAppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            color = Color.White,
            shadowElevation = 15.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) { Icon(Icons.Default.Home, contentDescription = "Home", tint = MaterialTheme.colorScheme.secondary) }
                IconButton(onClick = { }) { Icon(Icons.Default.List, contentDescription = "Atividade", tint = MaterialTheme.colorScheme.secondary) }

                Spacer(modifier = Modifier.size(60.dp))

                IconButton(onClick = { }) { Icon(Icons.Default.VolunteerActivism, contentDescription = "Doações", tint = MaterialTheme.colorScheme.secondary) }
                IconButton(onClick = { }) { Icon(Icons.Default.Person, contentDescription = "Perfil", tint = MaterialTheme.colorScheme.secondary) }
            }
        }

        Surface(
            modifier = Modifier
                .padding(bottom = 27.dp)
                .size(65.dp)
                .clickable {},
            shape = CircleShape,
            color = Color(0xFF2ECC71),
            shadowElevation = 8.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Recycling,
                    contentDescription = "Botão Reciclar",
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun MyBottomAppBarPreview() {
    EcoBairroTheme {
        MyBottomAppBar()
    }

}