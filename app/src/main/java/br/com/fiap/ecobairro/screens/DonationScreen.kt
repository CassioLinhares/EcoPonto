package br.com.fiap.ecobairro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.R
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme
import br.com.fiap.ecobairro.components.MyBottomAppBar

data class DonationItem(
    val title: String,
    val description: String,
    val orgName: String,
    val orgLogoRes: Int,
    val imageRes: Int
)

@Composable
fun DonationScreen(navController: NavHostController) {

    val donationItems = listOf(
        DonationItem(
            title = "Doe para o Greenpeace",
            description = "Você pode fazer a diferença e ajudar a proteger o meio ambiente no Brasil",
            orgName = "Greenpeace",
            orgLogoRes = R.drawable.greenpeace,
            imageRes = R.drawable.greenpeacefotos
        ),
        DonationItem(
            title = "Doação de alimentos em São Paulo",
            description = "Recebemos doações individuais e de empresas através do PIX",
            orgName = "Ong Mais",
            orgLogoRes = R.drawable.ongmais,
            imageRes = R.drawable.ongmaisfoto
        ),
        DonationItem(
            title = "Doação de ração para animais de estimação",
            description = "Cada doação faz a diferença na vida dos animais",
            orgName = "Instituto Caramelo",
            orgLogoRes = R.drawable.caramelo,
            imageRes = R.drawable.institutocaramelofoto
        )
    )

    Scaffold(
        containerColor = Color(0xFFF5F7FA),
        bottomBar = { MyBottomAppBar() }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Doações",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
                )
            }

            items(donationItems) { item ->
                DonationCard(item)
            }
        }
    }
}

@Composable
fun DonationCard(item: DonationItem) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
    ) {
        Column {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = item.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.description,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = item.orgLogoRes),
                        contentDescription = "Logo ${item.orgName}",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = item.orgName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF32CD32)),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Doação",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DonationScreenPreview() {
    EcoBairroTheme {
        DonationScreen(rememberNavController())
    }
}