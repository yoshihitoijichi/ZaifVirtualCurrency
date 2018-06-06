package net.ijichi.zaifvirtualcurrency.api.model.entity

data class CurrencyPair(
    val auxUnitPoint: Int,
    val itemJapanese: String,
    val auxUnitStep: String,
    val description: String,
    val itemUnitMin: Double,
    val eventNumber: Double,
    val currencyPair: String,
    val isToken: Boolean,
    val auxUnitMin: Double,
    val auxJapanese: String,
    val id: Int,
    val itemUnitStep: Double,
    val name: String,
    val seq: Int,
    val title: String
)

