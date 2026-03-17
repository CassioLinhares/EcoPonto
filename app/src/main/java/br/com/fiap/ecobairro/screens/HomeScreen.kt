package br.com.fiap.ecobairro.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.components.MyBottomAppBar
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme

val EcoGreen = Color(0xFF34C759)
val SoftGray = Color(0xFFF2F2F7)

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { MyBottomAppBar(navController = navController) },
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            //passar user.name do db
            HomeHeader(userName = "Cássio")

            SearchInput()

            MenuButtonSection()

            Banner()

            SectionTitle(title = "Disponível para retirada")
            RecentDonationsRow()

            //consumir api ecopontos e fazer um loop
            SectionTitle(title = "Ecopontos próximos")
            EcoPointItem(name = "EcoBairro Pinheiros", type = "Plásticos e Vidros")
            EcoPointItem(name = "Recicla Centro", type = "Eletrônicos e Óleo")

            Spacer(modifier = Modifier.height(100.dp)) // Espaço para não cobrir o menu inferior
        }
    }

}
@Preview
@Composable
fun HomeScreenPreview() {
    EcoBairroTheme() {
        HomeScreen(rememberNavController())
    }
}

@Composable
fun HomeHeader(userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            modifier = Modifier
                .padding(top = 25.dp)
        ){
            Text(
                text = "Olá, $userName!",
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = "O que vamos reciclar hoje?",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        //Botão de créditos
        Surface(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.MonetizationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "120",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}

@Composable
fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults
            .colors(
                unfocusedBorderColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
            ),
        label = {
            Text(
                text = "Procure por pontos de reciclagem",
                style = MaterialTheme.typography.labelSmall
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Icon search",
                tint = MaterialTheme.colorScheme.secondary
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun MenuButtonSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ActionButton(icon = Icons.Default.DeleteOutline, label = "Descartar", color = MaterialTheme.colorScheme.primary)
        ActionButton(icon = Icons.Default.Handshake, label = "Doar", color = Color(0xFF5856D6))
        ActionButton(icon = Icons.Default.ConfirmationNumber, label = "Cupons", color = Color(0xFFFF9500))
    }
}
@Composable
fun ActionButton(icon: ImageVector, label: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            modifier = Modifier.size(60.dp),
            color = color.copy(alpha = 0.1f),
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(
                icon,
                contentDescription = "Icon",
                tint = color,
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun Banner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Seu Impacto",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Você já evitou que 15kg de lixo fossem descartados incorretamente.",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun RecentDonationsRow() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(5) {
            Card(
                modifier = Modifier.size(width = 160.dp, height = 200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.LightGray)
                    )
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "EcoPonto de doação de roupas",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            maxLines = 1
                        )
                        Text(
                            text = "A 500m de você",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EcoPointItem(name: String, type: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .background(
                MaterialTheme.colorScheme.primary,
                RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = "Icon location",
            tint = MaterialTheme.colorScheme.background
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = type,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
    )
}
