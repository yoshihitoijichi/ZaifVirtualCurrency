package net.ijichi.zaifvirtualcurrency.ui.viewholder

import android.support.v7.widget.RecyclerView
import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.api.model.extension.applySelectableItemBackground
import net.ijichi.zaifvirtualcurrency.ui.itemview.BtcJpyItemView
import timber.log.Timber
import java.util.stream.Stream

/**
 * blomaga タブのview holder
 */
class BtcJpyViewHolder(private val view: BtcJpyItemView) : RecyclerView.ViewHolder(view) {

    fun update(trade: Trade, isEvenNumber: Boolean, onClick: ()->Unit) {
        view.update(trade, isEvenNumber)

        view.setOnClickListener {
            onClick()
        }

    }

}