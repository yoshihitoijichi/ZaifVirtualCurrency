package net.ijichi.zaifvirtualcurrency.ui.itemview

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Typeface
import android.view.LayoutInflater
import android.widget.FrameLayout
import net.ijichi.zaifvirtualcurrency.MySharedPreferences.init
import net.ijichi.zaifvirtualcurrency.R
import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.api.model.extension.applyLayoutPrams
import net.ijichi.zaifvirtualcurrency.api.model.extension.applySelectableItemBackground
import net.ijichi.zaifvirtualcurrency.api.model.extension.matchParent
import net.ijichi.zaifvirtualcurrency.databinding.ItemBtcJpyBinding

/**
 * BTC/JPY item view
 */
class BtcJpyItemView(context: Context?) : FrameLayout(context, null, 0) {

    private val binding = DataBindingUtil.inflate<ItemBtcJpyBinding>(LayoutInflater.from(getContext()), R.layout.item_btc_jpy, this, true)

    init {
        applyLayoutPrams(matchParent)
        binding.btcJpyItemParent.applySelectableItemBackground()
    }

    fun update(state: StreamStatus) {
        binding.btcJpyItemText.text = "test"

//        binding.blomagaItemTitle.applyText(item.title).applyTypeface(Typeface.BOLD)
//        binding.blomagaItemDescription.applyHtmlText(item.description)
//
//        if (item.thumbnailUrl.isNullOrEmpty()) {
//            binding.blomagaItemImage.gone()
//        } else {
//            binding.blomagaItemImage.loadImage(item.thumbnailUrl, isAdjustHeight = true)
//        }z
//
//        if(item.isShowPurchase){
//            binding.blomagaItemPurchaseParent.visible()
//            binding.blomagaItemPurchaseText.applyText(R.string.tab_purchase_pay_text)
//        }else{
//            binding.blomagaItemPurchaseParent.invisible()
//        }
//
//        val tokyo = DateTimeZone.forID("+09:00")
//        val now = DateTime(tokyo)
//        val dt = DateTime(item.publishedAt, tokyo)
//
//        binding.blomagaItemTime.applyText(TimeUtil.pastTime(dt, now))
//        binding.blomagaItemCommentText.text = item.commentCount.toString()
    }

}