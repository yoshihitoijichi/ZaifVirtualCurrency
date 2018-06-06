package net.ijichi.zaifvirtualcurrency.ui.adapter

import android.support.v7.widget.RecyclerView

/**
 * abstract recycler adapter
 */
abstract class AbstractRecyclerAdapter<D>(private val states: ArrayList<D>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    open fun addFooter() {}

    fun getItem(position: Int): D {
        return states[position]
    }

    open fun hasFooter(): Boolean {
        return true
    }

    fun clear() {
        if (states.isEmpty()) return
        val size = states.size
        states.clear()
        notifyItemRangeRemoved(0, size)
    }

    fun addTop(state: D) {
        state?.let {
            this.states.add(0, state)
            notifyDataSetChanged()
        }
    }

    fun addAllTop(states: List<D>?) {
        states?.let {
            this.states.addAll(0, it.reversed())
            notifyDataSetChanged()
        }
    }

    fun isEmpty(): Boolean{
        return states.isEmpty()
    }

    override fun getItemCount(): Int {
        return states.size
    }

}