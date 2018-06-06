package net.ijichi.zaifvirtualcurrency.api.model.extension

import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.text.Html
import android.widget.TextView
import net.ijichi.zaifvirtualcurrency.R



/**
 * TextView Extension
 */

fun TextView.applyTypeface(typeface: Int): TextView {
    setTypeface(Typeface.MONOSPACE, typeface)
    return this
}

fun TextView.applyTextColor(resId: Int): TextView {
    setTextColor(ContextCompat.getColor(context, resId))
    return this
}

fun TextView.applyTextColorGraphics(colorId: Int): TextView {
    setTextColor(colorId)
    return this
}

fun TextView.applyText(text: String?): TextView {
    this.text = text
    return this
}

fun TextView.applyTextRes(resId: Int): TextView {
    text = resources.getString(resId)
    return this
}

fun TextView.applyTextRes(resId: Int, vararg formatArgs: Any?): TextView {
    text = resources.getString(resId, *formatArgs)
    return this
}

fun TextView.applyBack(resId: Int): TextView {
    background = ResourcesCompat.getDrawable(resources, resId, null)
    return this
}

fun TextView.applyTag(tag: Int): TextView {
    this.tag = tag
    return this
}

fun TextView.applyHtmlText(text: String?): TextView {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY))
    } else {
        setText(Html.fromHtml(text))
    }
    return this
}
