package net.ijichi.zaifvirtualcurrency.ui.itemview

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.widget.FrameLayout
import net.ijichi.zaifvirtualcurrency.R
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.api.model.extension.*
import net.ijichi.zaifvirtualcurrency.databinding.ItemStreamBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * BTC/JPY item view
 */
class StreamItemView(context: Context?) : FrameLayout(context, null, 0) {

    private val binding = DataBindingUtil.inflate<ItemStreamBinding>(
        LayoutInflater.from(context), R.layout.item_stream, this, true)

    init {
        applyLayoutPrams(matchParent)
        applySelectableItemBackground()
    }

    fun update(trade: Trade) {
        val displayColor =
            if(trade.tradeType.isBid)R.color.palette_red_8 else R.color.palette_green_7

        val sdf = SimpleDateFormat("yyyy/MM/dd kk:mm:ss", Locale.JAPAN)
        val date = Date( trade.date * 1000)
        binding.streamItemTimeText.applyText(sdf.format(date))
        binding.streamItemTradeActionText.applyTextRes(trade.tradeType.strRes).applyTextColor(displayColor)
        binding.streamItemTradeAmountText.applyText(trade.amount.toString()).applyTextColor(displayColor)
        binding.streamItemTradePriceText.applyText(trade.price.toString()).applyTextColor(displayColor)
    }

}