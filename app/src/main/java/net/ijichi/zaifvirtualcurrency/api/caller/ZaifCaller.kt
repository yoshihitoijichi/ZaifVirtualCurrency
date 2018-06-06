package net.ijichi.zaifvirtualcurrency.api.caller

import io.reactivex.Single
import net.ijichi.zaifvirtualcurrency.api.model.entity.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Zaif caller
 * Created by ijichiyoshihito on 2018/01/09.
 */

interface ZaifCaller {

    // マーケットの一覧
    @GET("last_price/{exchangeType}")
    fun getLastPrice(
        @Path("exchangeType") exchangeType: String
    ): Single<LastPrice>

    // ティッカー
    @GET("last_price/{exchangeType}")
    fun getTicker(
        @Path("exchangeType") exchangeType: String
    ): Single<Ticker>

    // 全ての取引履歴
    @GET("trades/{exchangeType}")
    fun getTrades(
        @Path("exchangeType") exchangeType: String
    ): Single<List<Trade>>

    // 板情報
    @GET("depth/{exchangeType}")
    fun getDepth(
        @Path("exchangeType") exchangeType: String
    ): Single<Depth>

    // currency_pairs : trade_history等で利用可能な通貨ペア情報。allをしていするとすべての通貨ペア情報を取得できます。
    @GET("currency_pairs/{currencyPairType}")
    fun getCurrencyPairs(
        @Path("currencyPairType") currencyPairType: String
    ): Single<List<CurrencyPair>>

    // currencies : deposit_history等で利用可能な通貨情報。allをしていするとすべての通貨ペア情報を取得できます。
    @GET("currencies/{exchangeType}")
    fun getCurrencies(
        @Path("exchangeType") exchangeType: String
    ): Single<List<Currency>>
}