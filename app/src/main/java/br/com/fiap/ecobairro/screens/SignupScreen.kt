package br.com.fiap.ecobairro.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.R
import br.com.fiap.ecobairro.navigation.Destination
import br.com.fiap.ecobairro.repository.SharedPreferencesUserRepository
import br.com.fiap.ecobairro.repository.UserRepository
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme


@Composable
fun SignupScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButtonComponent(navController = navController, onClick = {})
        }

        Spacer(modifier = Modifier.height(20.dp))

        LogoImage()

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(R.string.bem_vindo),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(30.dp))

        SocialLoginButtons()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "ou entrar com E-mail",
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        SignupUserForm(navController = navController)
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    EcoBairroTheme {
        SignupScreen(rememberNavController())
    }
}


@Composable
fun BackButtonComponent(
    navController: NavHostController,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = {navController.navigate(Destination.LoginScreen.route)},
        modifier = modifier
            .size(48.dp)
            .border(
                width = 1.5.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Voltar para a tela anterior",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}


@Composable
fun LogoImage() {
    Box(
        modifier = Modifier
    )
    {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "imagem do logotipo",
            modifier = Modifier
                .size(85.dp)
        )
    }
}


@Composable
fun TextComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.bem_vindo),
            color = MaterialTheme.colorScheme.primary
        )
    }
}


@Composable
fun SocialLoginButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B5998)),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Logo Facebook",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Entrar com FACEBOOK",
                    color = MaterialTheme.colorScheme.surface,
                    style = MaterialTheme.typography.titleSmall,
                )

                Spacer(modifier = Modifier.weight(1f))

                Spacer(modifier = Modifier.size(24.dp))
            }
        }

        Spacer(modifier = Modifier.height(9.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color.Gray),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Logo Google",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Entrar com GOOGLE",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall,
                )

                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.size(24.dp))
            }
        }
    }
}


@Composable
fun SignupUserForm(modifier: Modifier = Modifier, navController: NavHostController) {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }

    var authenticatorError by remember {
        mutableStateOf(false)
    }

    val userRepository: UserRepository =
        SharedPreferencesUserRepository(LocalContext.current)


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email.value,
            onValueChange = { emailvalue ->
                email.value = emailvalue
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "E-mail", style = MaterialTheme.typography.labelSmall) },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.tertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            ),
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { passwordvalue ->
                password.value = passwordvalue
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Senha", style = MaterialTheme.typography.labelSmall) },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.tertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            ),
            trailingIcon = {
                val image = if (showPassword){
                    Icons.Default.Visibility
                } else {
                    Icons.Default.VisibilityOff
                }
                IconButton(
                    onClick = {showPassword = !showPassword}
                ) {
                    Icon(
                        imageVector = image,
                        contentDescription = "Mostrar senha",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            },
            visualTransformation = if (showPassword){
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val authenticate = userRepository.login(email.value, password.value)
                if (authenticate){
                    navController.navigate(Destination.NewsScreen.route)
                }
                else {
                    authenticatorError = true
                }

            },
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "Entrar",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.surface
            )
        }

        if (authenticatorError){
            Row {
                Icon(
                    imageVector = Icons.Default.Error,
                    contentDescription = "Icone de erro",
                    tint = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Authenticator Error",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }

        Text(
            text = "Esqueceu a senha?",
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Ainda não tem conta?",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelMedium
            )
            TextButton(
                onClick = { navController.navigate(Destination.Cadastro.route) },
                contentPadding = PaddingValues(start = 4.dp)
            ) {
                Text(
                    text = "Registrar-se",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}