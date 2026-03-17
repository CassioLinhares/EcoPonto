package br.com.fiap.ecobairro.repository

import br.com.fiap.ecobairro.R
import br.com.fiap.ecobairro.model.EcoItem

fun ecoItems() = listOf<EcoItem>(
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