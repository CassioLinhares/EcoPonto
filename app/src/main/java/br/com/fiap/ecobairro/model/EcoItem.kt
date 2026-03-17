package br.com.fiap.ecobairro.model

data class EcoItem(
    val category: String,
    val title: String,
    val sourceName: String,
    val sourceLogoRes: Int,
    val date: String,
    val imageRes: Int
)