package net.ijichi.zaifvirtualcurrency.api.model.extension

import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.LinearLayout
import net.ijichi.zaifvirtualcurrency.R
import timber.log.Timber


const val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
const val matchParent = ViewGroup.LayoutParams.MATCH_PARENT

fun <T: View>  T.visible(): T {
    visibility = View.VISIBLE
    return this
}

fun <T: View>  T.invisible(): T {
    visibility = View.INVISIBLE
    return this
}

fun <T: View>  T.gone(): T {
    visibility = View.GONE
    return this
}

fun View.applyLayoutPrams(width: Int = wrapContent, height: Int = wrapContent): View {
    layoutParams = ViewGroup.LayoutParams(width, height)
    return this
}

fun View.applySelectableItemBackground(): View {
    val typedArray = context.obtainStyledAttributes(intArrayOf(R.attr.selectableItemBackground))
    if(this is FrameLayout){
        foreground = typedArray.getDrawable(0)
    }else{
        background = typedArray.getDrawable(0)
    }

    typedArray.recycle()
    return this
}
