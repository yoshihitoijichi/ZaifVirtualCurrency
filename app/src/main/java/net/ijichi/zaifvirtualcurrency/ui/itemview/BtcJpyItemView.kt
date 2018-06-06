package net.ijichi.zaifvirtualcurrency.ui.itemview

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Typeface
import android.view.LayoutInflater
import android.widget.FrameLayout
import net.ijichi.zaifvirtualcurrency.MySharedPreferences.init
import net.ijichi.zaifvirtualcurrency.R
import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.api.model.extension.applyLayoutPrams
import net.ijichi.zaifvirtualcurrency.api.model.extension.applySelectableItemBackground
import net.ijichi.zaifvirtualcurrency.api.model.extension.applyText
import net.ijichi.zaifvirtualcurrency.api.model.extension.matchParent
import net.ijichi.zaifvirtualcurrency.databinding.ItemBtcJpyBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * BTC/JPY item view
 */
class BtcJpyItemView(context: Context?) : FrameLayout(context, null, 0) {

    private val binding = DataBindingUtil.inflate<ItemBtcJpyBinding>(
        LayoutInflater.from(context), R.layout.item_btc_jpy, this, true)

    init {
        applyLayoutPrams(matchParent)
        binding.btcJpyItemParent.applySelectableItemBackground()
    }

    fun update(trade: Trade) {
//        binding.btcJpyItemText.text = "test"

        val sdf = SimpleDateFormat("yyyy/MM/dd kk:mm:ss", Locale.JAPAN)
        val date = Date( trade.date * 1000)
        binding.btcJpyItemTimeText.applyText(sdf.format(date))
        binding.btcJpyItemTradeActionText.applyText(trade.tradeType)
        binding.btcJpyItemTradeAmountText.applyText(trade.amount.toString())
        binding.btcJpyItemTradePriceText.applyText(trade.price.toString())
    }

}