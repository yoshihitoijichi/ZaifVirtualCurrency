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

//{
//    "asks":[[30000.0, 0.1],[30010.0, 0.2],...],
//    "bids":[[29500.0, 0.5],[29300.0, 0.1],...],
//    "trades":[{"currenty_pair":"btc_jpy","trade_type":"ask","price":30001,"tid":123,"amount":0.02,"date":1427879761},{}...],
//    "timestamp":"2015-04-01 18:16:01.739990",
//    "last_price:{"action":"ask","price":30001},
//    "currency_pair":"btc_jpy"
//}
