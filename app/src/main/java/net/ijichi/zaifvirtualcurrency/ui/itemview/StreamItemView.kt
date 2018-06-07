package net.ijichi.zaifvirtualcurrency.ui.itemview

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.widget.FrameLayout
import net.ijichi.zaifvirtualcurrency.R
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.api.model.extension.*
import net.ijichi.zaifvirtualcurrency.databinding.ItemBtcJpyBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * BTC/JPY item view
 */
class StreamItemView(context: Context?) : FrameLayout(context, null, 0) {

    private val binding = DataBindingUtil.inflate<ItemBtcJpyBinding>(
        LayoutInflater.from(context), R.layout.item_stream, this, true)

    init {
        applyLayoutPrams(matchParent)
        applySelectableItemBackground()
    }

    fun update(trade: Trade, isEvenNumber: Boolean) {
//        setBackgroundColor(if(isEvenNumber)Color.CYAN else Color.BLUE)

        val sdf = SimpleDateFormat("yyyy/MM/dd kk:mm:ss", Locale.JAPAN)
        val date = Date( trade.date * 1000)
        binding.streamItemTimeText.applyText(sdf.format(date))
        binding.streamItemTradeActionText.applyTextRes(trade.tradeType.strRes)
        binding.streamItemTradeAmountText.applyText(trade.amount.toString())
        binding.streamItemTradePriceText.applyText(trade.price.toString())
    }

}