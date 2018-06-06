package net.ijichi.zaifvirtualcurrency.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.ui.itemview.BtcJpyItemView
import net.ijichi.zaifvirtualcurrency.ui.viewholder.BtcJpyViewHolder
import java.util.ArrayList
import java.util.stream.Stream

/**
 * BTC/JPY adapter
 */
class BtcJpyRecyclerAdapter(
    private val context: Context?,
    private val states: ArrayList<StreamStatus>,
    private val onClick: (Int)->Unit
) : AbstractRecyclerAdapter<StreamStatus>(states) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BtcJpyViewHolder(BtcJpyItemView(context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BtcJpyViewHolder -> {
                val item = states[position]
                holder.update(item)
            }
        }
    }

//    override fun getItemViewType(position: Int): Int {
//        val item = states[position]
//        return item.sectionType.ordinal
//    }

//    override fun hasFooter(): Boolean {
//        if (states.isEmpty()) return false
//        return states[states.size - 1].sectionType.isFooter()
//    }

//    override fun addFooter() {
//        states.add(BlomagaState.BlomagaStateItem(TabSectionType.FOOTER))
//    }
}