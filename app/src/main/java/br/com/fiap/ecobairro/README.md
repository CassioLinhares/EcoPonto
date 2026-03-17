# 🌿 EcoBairro

> **reciclar é cuidar da nossa casa**

EcoBairro é um aplicativo Android voltado para a **gestão sustentável de resíduos em comunidades**. A proposta é simples: ajudar vizinhos a descartarem as coisas da forma certa — encontrando ecopontos próximos, combinando a retirada de itens que seriam jogados fora e acompanhando o próprio impacto ambiental. Quem usa o app ainda acumula créditos e ganha cupons de desconto em lojas parceiras.

---

## 📱 Plataforma

| Item | Detalhe          |
|------|------------------|
| Plataforma | Android          |
| IDE | Android Studio   |
| Linguagem | Kotlin           |
| Min SDK | 28 (Android 9.0) |


---

## 🗂️ Estrutura de Telas

O app possui **8 telas** organizadas em dois fluxos: autenticação e navegação principal.

### Fluxo de Autenticação
```
SplashActivity
    ├── LoginFragment       → Entrar com e-mail/senha
    └── RegisterFragment    → Criar nova conta
```

### Fluxo Principal (após login)
```
MainActivity
    ├── HomeFragment        → Página inicial com impacto, atalhos e ecopontos
    ├── NewsFragment        → Feed de notícias sobre sustentabilidade
    ├── MapFragment         → Mapa com ecopontos próximos
    ├── DonationsFragment   → Doações para ONGs parceiras
    └── ProfileFragment     → Perfil do usuário e configurações
```

---

## 🔐 Autenticação — SharedPreferences

Como o Firebase ainda **não foi integrado**, o sistema de login/cadastro utiliza **SharedPreferences** para simular a persistência de sessão localmente no dispositivo.

### Como funciona

**Cadastro (`RegisterFragment`):**
```kotlin
val prefs = requireContext().getSharedPreferences("ecobairro_prefs", Context.MODE_PRIVATE)

prefs.edit()
    .putString("user_name", name)
    .putString("user_email", email)
    .putString("user_password", password)
    .putBoolean("is_logged_in", true)
    .apply()
```

**Login (`LoginFragment`):**
```kotlin
val prefs = requireContext().getSharedPreferences("ecobairro_prefs", Context.MODE_PRIVATE)

val savedEmail    = prefs.getString("user_email", null)
val savedPassword = prefs.getString("user_password", null)

if (email == savedEmail && password == savedPassword) {
    prefs.edit().putBoolean("is_logged_in", true).apply()
    // navegar para Home
}
```

**Verificação de sessão (ao abrir o app):**
```kotlin
val isLoggedIn = prefs.getBoolean("is_logged_in", false)

if (isLoggedIn) {
    // vai direto para HomeFragment
} else {
    // exibe tela de boas-vindas
}
```

**Logout (`ProfileFragment`):**
```kotlin
prefs.edit().putBoolean("is_logged_in", false).apply()
```

> ⚠️ **Atenção:** SharedPreferences não é recomendado para produção pois armazena dados sem criptografia. A integração com **Firebase Authentication** está prevista em versões futuras.

---

## 🧭 Navegação — Navigation Component

A navegação entre telas é gerenciada pelo **Jetpack Navigation Component** com `NavController`, sem necessidade de gerenciar a backstack manualmente.

### Dependências (`build.gradle`)
```gradle
dependencies {
    implementation "androidx.navigation:navigation-fragment-ktx:2.7.7"
    implementation "androidx.navigation:navigation-ui-ktx:2.7.7"
}
```


---

## 📂 Estrutura do Projeto

```
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/com/ecobairro/
│   ├── ui/
│   │   ├── auth/
│   │   │   ├── SplashActivity.kt
│   │   │   ├── LoginFragment.kt
│   │   │   └── RegisterFragment.kt
│   │   ├── home/
│   │   │   └── HomeFragment.kt
│   │   ├── news/
│   │   │   └── NewsFragment.kt
│   │   ├── map/
│   │   │   └── MapFragment.kt
│   │   ├── donations/
│   │   │   └── DonationsFragment.kt
│   │   └── profile/
│   │       └── ProfileFragment.kt
│   └── MainActivity.kt
└── res/
    ├── layout/          → XMLs das telas
    ├── navigation/
    │   └── nav_graph.xml
    ├── drawable/        → ícones e assets
    └── values/
        ├── colors.xml
        ├── strings.xml
        └── themes.xml
```

---
🚀 Como Rodar o Projeto

Extraia o arquivo .zip recebido em uma pasta de sua preferência.
Abra o Android Studio.
Na tela inicial, clique em Open e selecione a pasta extraída do projeto.
Aguarde a sincronização do Gradle concluir (pode levar alguns minutos na primeira vez).
Execute em um emulador ou dispositivo físico com Android 7.0+:

---

## 🔮 Próximos Passos

- [ ] Integrar **Firebase Authentication** (substituir SharedPreferences)
- [ ] Integrar **Firebase Firestore** para sincronização de dados na nuvem
- [ ] Adicionar **Google Maps SDK** para geolocalização real dos ecopontos
- [ ] Consumir **API de notícias** (NewsAPI ou RSS) para feed dinâmico
- [ ] Implementar sistema de **créditos e cupons** com backend próprio
- [ ] Adicionar **notificações push** via Firebase Cloud Messaging
- [ ] Publicar na **Google Play Store**

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos e de prototipagem.

---

<p align="center">
  Feito com 💚 pelo time EcoBairro
</p>