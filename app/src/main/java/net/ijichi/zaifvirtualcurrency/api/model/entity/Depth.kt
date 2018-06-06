package net.ijichi.zaifvirtualcurrency.api.model.entity

data class Depth(
    val asks: List<List<Double>>,
    val bids: List<List<Double>>
)

