package net.ijichi.zaifvirtualcurrency.ui.viewholder

import android.support.v7.widget.RecyclerView
import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.ui.itemview.BtcJpyItemView
import java.util.stream.Stream

/**
 * blomaga タブのview holder
 */
class BtcJpyViewHolder(private val view: BtcJpyItemView) : RecyclerView.ViewHolder(view) {

    fun update(trade: Trade) {
        view.update(trade)

        // set clickListener

    }

}