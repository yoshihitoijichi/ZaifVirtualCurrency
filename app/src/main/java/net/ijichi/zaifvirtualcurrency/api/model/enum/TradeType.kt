package net.ijichi.zaifvirtualcurrency.api.model.enum

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import net.ijichi.zaifvirtualcurrency.R
import java.lang.reflect.Type

/**
 * Trade Type
 * Created by ijichiyoshihito on 2018/06/07.
 */

enum class TradeType(val str: String, val strRes: Int) {
    BID("bid", R.string.bid), ASK("ask", R.string.ask), ;

    val isBid: Boolean
        get() = this == BID

    val isAsk: Boolean
        get() = this == ASK

    companion object {
        fun of(str: String): TradeType? {
            return values().firstOrNull { it.str == str }
        }

        val adapter = (TradeType::class.java to TradeTypeDeserializer())
    }

    class TradeTypeDeserializer : JsonDeserializer<TradeType> {
        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): TradeType {
            return TradeType.of(json!!.asString)!!
        }
    }
}