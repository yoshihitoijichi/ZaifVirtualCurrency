package net.ijichi.zaifvirtualcurrency.api.model.entity

data class Ticker(
    val last: Double,
    val high: Double,
    val low: Double,
    val vwap: Double,
    val volume: Double,
    val bid: Double,
    val ask: Double
)
