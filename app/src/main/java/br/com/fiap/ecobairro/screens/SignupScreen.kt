package br.com.fiap.ecobairro.screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.R
import br.com.fiap.ecobairro.model.User
import br.com.fiap.ecobairro.navigation.Destination
import br.com.fiap.ecobairro.repository.SharedPreferencesUserRepository
import br.com.fiap.ecobairro.ui.theme.EcoBairroTheme

@Composable
fun SignupScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButtonComponentSignUpScreen(
                onClick = {
                    navController.navigate(Destination.InialScreen.route)
                },
                navController = navController)
        }

        Spacer(modifier = Modifier.height(20.dp))

        LogoImageCasdatro()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Crie sua conta", // Adaptei o texto para o contexto de cadastro
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(40.dp))

        CadastroUserForm(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    EcoBairroTheme {
        SignupScreen(rememberNavController())
    }
}

@Composable
fun BackButtonComponentSignUpScreen(
    navController: NavHostController,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = {onClick()},
        modifier = modifier
            .padding(bottom = 50.dp)
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
fun LogoImageCasdatro() {
    Box(
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "imagem do logotipo",
            modifier = Modifier
                .size(85.dp)
        )
    }
}

@Composable
fun TextComponentcadastro() {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroUserForm(modifier: Modifier = Modifier, navController: NavHostController) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val userRepository = SharedPreferencesUserRepository(LocalContext.current)

    var isNameError by remember { mutableStateOf((false)) }
    var isEmailError by remember { mutableStateOf((false)) }
    var isPasswordError by remember { mutableStateOf((false)) }

    var showDiaologError by remember { mutableStateOf(false) }
    var showDiaologSuccess by remember { mutableStateOf(false) }

    fun validate(): Boolean{
        isNameError = name.length < 4
        isEmailError = email.length < 4 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()
        isPasswordError = password.length < 4
        return !isNameError && !isEmailError && !isPasswordError
    }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome",
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.tertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            ),
            isError = isNameError,
            trailingIcon = {
                if (isNameError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Icone de erro",
                        tint = MaterialTheme.colorScheme.error

                    )
                }
            },
            supportingText = {
                if (isNameError){
                    Text(
                        text = "O nome deve ter no mínimo 4 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
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
            isError = isEmailError,
            trailingIcon = {
                if (isEmailError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Icone de erro",
                        tint = MaterialTheme.colorScheme.error

                    )
                }
            },
            supportingText = {
                if (isEmailError){
                    Text(
                        text = "O Email deve ter no mínimo 4 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
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
            isError = isPasswordError,
            trailingIcon = {
                if (isPasswordError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Icone de erro",
                        tint = MaterialTheme.colorScheme.error

                    )
                }
            },
            supportingText = {
                if (isPasswordError){
                    Text(
                        text = "A senha deve ter no mínimo 4 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        //btn cadastrar
        Button(
            onClick = {
                if (validate()){
                    userRepository.saveUser(
                        User(
                            name = name,
                            password = password,
                            email = email
                        )
                    )
                    showDiaologSuccess = true
                } else {showDiaologError = true}
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "Cadastrar",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.surface
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Já tem conta?",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelMedium
            )
            TextButton(
                onClick = { navController.navigate(Destination.LoginScreen.route) },
                contentPadding = PaddingValues(start = 4.dp)
            ) {
                Text(
                    text = "Entrar",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
        if (showDiaologError){
            AlertDialog(
                onDismissRequest = { showDiaologError = false },
                title = {
                    Text(text = "Erro")
                },
                text = {
                    Text(text = "Preencha todos os campos corretamente")
                },
                confirmButton = {
                    TextButton(
                        onClick = { showDiaologError = false }
                    ) {
                        Text(text = "OK")
                    }
                }

            )
        }
        if (showDiaologSuccess){
            AlertDialog(
                onDismissRequest = { showDiaologError = false },
                title = {
                    Text(text = "Sucesso")
                },
                text = {
                    Text(text = "Conta criada com sucesso")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDiaologSuccess = false
                            navController.navigate(Destination.LoginScreen.route) }
                    ) {
                        Text(text = "OK")
                    }
                }

            )
        }
    }
}