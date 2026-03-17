package br.com.fiap.ecobairro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.R
import br.com.fiap.ecobairro.components.MyBottomAppBar
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme

val PrimaryGreen = Color(0xFF4CAF50)
val BackgroundGray = Color(0xFFCECECE)

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { MyBottomAppBar(navController)}
    ) { padding->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                ProfileHeader()

                SectionHeader(title = "Categorias")

                MenuItem(icon = Icons.Default.Person, title = "Sobre você")
                MenuItem(icon = Icons.Default.CardGiftcard, title = "Pedidos")
                MenuItem(icon = Icons.Default.FavoriteBorder, title = "Favoritos")
                MenuItem(icon = Icons.Default.LocationOn, title = "Endereços")
                MenuItem(icon = Icons.Default.CreditCard, title = "Cartões")
                MenuItem(icon = Icons.Default.Sync, title = "Transações")
                MenuItem(icon = Icons.Default.Notifications, title = "Notificações")

                SectionHeader(title = "Outros")

                MenuItem(
                    icon = Icons.Default.Shield,
                    title = "Versão",
                    showArrow = false,
                    trailingText = "1.0.0"
                )

                MenuItem(icon = Icons.Default.Code, title = "Modo de Desenvolvedor")

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
        }



@Preview
@Composable()
fun ProfileScreenPreview() {
    EcoBairroTheme {
    ProfileScreen(rememberNavController())
    }
}

@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 52.dp, bottom = 22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Surface(
                modifier = Modifier.size(120.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.tertiary
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Foto de Perfil"
                )
            }
            Surface(
                modifier = Modifier.size(32.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "icon Camera",
                    tint = Color.White,
                    modifier = Modifier.padding(6.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Pedro Aguiar", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(text = "@oirisco", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.MonetizationOn,
                contentDescription = "Icon money",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${0} Créditos",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
    }
}

@Composable
fun MenuItem(
    icon: ImageVector,
    title: String,
    showArrow: Boolean = true,
    trailingText: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        if (trailingText != null) {
            Text(text = trailingText, color = Color.LightGray, fontSize = 14.sp)
        }

        if (showArrow) {
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier
                    .clickable(onClick = { })
            )
        }
    }
}