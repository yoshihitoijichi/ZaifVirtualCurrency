package net.ijichi.cryptocurrencychecker.api.service

import io.reactivex.Single
import net.ijichi.zaifvirtualcurrency.api.ApiUtil

import net.ijichi.zaifvirtualcurrency.api.caller.ZaifCaller
import net.ijichi.zaifvirtualcurrency.api.model.entity.*
import net.ijichi.zaifvirtualcurrency.api.model.enum.ExchangeType

/**
 * coincheck api service
 * Created by ijichiyoshihito on 2018/01/09.
 */
class ZaifService {
    private val caller = ApiUtil.generateCaller(ZaifCaller::class.java, ApiUtil.UrlType.ZAIF)

    fun getLastPrice(exchangeType: ExchangeType): Single<LastPrice> {
        return caller.getLastPrice(exchangeType.name.toLowerCase())
    }

    fun getTicker(exchangeType: ExchangeType): Single<Ticker> {
        return caller.getTicker(exchangeType.name.toLowerCase())
    }

    fun getTrades(exchangeType: ExchangeType): Single<List<Trade>> {
        return caller.getTrades(exchangeType.name.toLowerCase())
    }

    fun getDepth(exchangeType: ExchangeType): Single<Depth> {
        return caller.getDepth(exchangeType.name.toLowerCase())
    }

    enum class CurrencyPairType { ALL, BTC_JPY }
    fun getCurrencyPairs(currencyPairType: CurrencyPairType): Single<List<CurrencyPair>> {
        return caller.getCurrencyPairs(currencyPairType.name.toLowerCase())
    }

    enum class CurrencyType { ALL, BTC }
    fun getCurrencies(currencyType: CurrencyType): Single<List<Currency>> {
        return caller.getCurrencies(currencyType.name.toLowerCase())
    }


}