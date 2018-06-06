package net.ijichi.zaifvirtualcurrency.api.model.entity

import net.ijichi.zaifvirtualcurrency.api.model.enum.TradeType


data class Trade(
    val date: Long,
    val price: Double,
    val amount: Double,
    val tid: Double,
    val currencyPair: String,
    val tradeType: TradeType
)