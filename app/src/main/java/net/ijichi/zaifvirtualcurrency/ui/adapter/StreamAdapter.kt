package net.ijichi.zaifvirtualcurrency.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.ui.itemview.StreamItemView
import net.ijichi.zaifvirtualcurrency.ui.viewholder.StreamViewHolder
import java.util.*

/**
 * BTC/JPY adapter
 */
class StreamAdapter(
    private val context: Context?,
    private val states: ArrayList<Trade>,
    private val onClick: ()->Unit
) : AbstractRecyclerAdapter<Trade>(states) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StreamViewHolder(StreamItemView(context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is StreamViewHolder -> {
                val item = states[position]
                holder.update(item, position % 2 == 0, onClick)
            }
        }
    }
}