package net.ijichi.zaifvirtualcurrency.ui.viewholder

import android.support.v7.widget.RecyclerView
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.ui.itemview.StreamItemView

/**
 * blomaga タブのview holder
 */
class StreamViewHolder(private val view: StreamItemView) : RecyclerView.ViewHolder(view) {

    fun update(trade: Trade, isEvenNumber: Boolean, onClick: ()->Unit) {
        view.update(trade, isEvenNumber)

        view.setOnClickListener {
            onClick()
        }

    }

}