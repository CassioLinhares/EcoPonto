package br.com.fiap.ecobairro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ecobairro.R
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme

data class EcoItem(
    val category: String,
    val title: String,
    val sourceName: String,
    val sourceLogoRes: Int,
    val date: String,
    val imageRes: Int
)

@Composable
fun newsScreen() {

    val ecoItems = listOf(
        EcoItem(
            category = "Brasil",
            title = "Projeto social transforma reciclagem em alimentos para mais de 600 famílias em Jundiaí",
            sourceName = "G1",
            sourceLogoRes = R.drawable.g1,
            date = "02/11/2025",
            imageRes = R.drawable.image1
        ),EcoItem(
                category = "Brasil",
        title = "Sem educação ambiental, reciclagem se torna desafio em Porto Alegre",
        sourceName = "sul21",
        sourceLogoRes = R.drawable.sul21,
        date = "25/12/2025",
        imageRes = R.drawable.image2
    ),  EcoItem(
            category = "Brasil",
            title = "Leilões: quando a retirada de veículos dos pátios vira ganho ambiental e social",
            sourceName = "Portal cidade Ivinhema",
            sourceLogoRes = R.drawable.pci,
            date = "02/02/2026",
            imageRes = R.drawable.image3
    ),EcoItem(
            category = "Brasil",
            title = "Empresas se adaptam às novas exigências de sustentabilidade",
            sourceName = "Terra",
            sourceLogoRes = R.drawable.terra,
            date = "02/11/2025",
            imageRes = R.drawable.image4
    ),
        EcoItem(
            category = "Brasil",
            title = "Desenvolvimento sustentável é a verdadeira arma contra o crime na Amazônia",
            sourceName = "CNN",
            sourceLogoRes = R.drawable.cnn,
            date = "14/01/2026",
            imageRes = R.drawable.image5
        )
    )

    Scaffold(
        containerColor = Color(0xFFF5F5F5),
        bottomBar = { MyBottomAppBar() }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Text(
                    text = "Notícias",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(ecoItems) { item ->
                EcoNewsItem(item)
            }
        }
    }
};

@Composable
fun EcoNewsItem(item: EcoItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.category,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = item.title,
            fontSize = 16.sp,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary,

        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.sourceLogoRes),
                contentDescription = "Logo da fonte ${item.sourceName}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = item.sourceName,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                imageVector = Icons.Default.Schedule,
                contentDescription = "Data",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(14.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = item.date,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "Mais opções",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun MyBottomAppBar() {
    Box(
        modifier = Modifier
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
                IconButton(onClick = { }) { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Gray) }
                IconButton(onClick = { }) { Icon(Icons.Default.List, contentDescription = "Atividade", tint = Color.Gray) }

                Spacer(modifier = Modifier.size(60.dp))

                IconButton(onClick = { }) { Icon(Icons.Default.Message, contentDescription = "Mensagens", tint = Color.Gray) }
                IconButton(onClick = { }) { Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.Gray) }
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

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    EcoBairroTheme {
        newsScreen()
    }
}