package net.ijichi.zaifvirtualcurrency.api.model.entity

data class StreamStatus(
    val asks: List<List<Double>>,
    val bids: List<List<Double>>,
    val trades: List<Trade>,
    val timestamp: String,
    val lastPrice: LastPrice,
    val currencyPair: String
){
    data class LastPrice(
        val action: String,
        val price: Int
    )
}
