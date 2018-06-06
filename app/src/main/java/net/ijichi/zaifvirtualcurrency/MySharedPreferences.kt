package net.ijichi.zaifvirtualcurrency

import android.content.Context
import android.content.SharedPreferences

/**
 * shared preference class
 * Created by ijichiyoshihito on 2018/01/07.
 */
object MySharedPreferences {

    private val PREFERENCE_NAME = "zaif_vertual_currency"
    private var mSharedPreferences: SharedPreferences? = null

    fun init(context: Context) {
        mSharedPreferences = mSharedPreferences ?: context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    private enum class Key(val str: String) {
        ACCESS_TOKEN("accessToken"),
        SHOP_CODE("shopCode"),
        RECEPTION_CODE("receptionCode"),
        RECEPTION_DATE("receptionDate")
    }

    var accessToken: String
        get() = mSharedPreferences?.getString(Key.ACCESS_TOKEN.str, "") ?: ""
        set(value) {
            mSharedPreferences?.edit()?.putString(Key.ACCESS_TOKEN.str, value)?.apply()
        }

    var shopCode: String
        get() = mSharedPreferences?.getString(Key.SHOP_CODE.str, "") ?: ""
        set(value) {
            mSharedPreferences?.edit()?.putString(Key.SHOP_CODE.str, value)?.apply()
        }

    var receptionCode: String
        get() = mSharedPreferences?.getString(Key.RECEPTION_CODE.str, "") ?: ""
        set(value) {
            mSharedPreferences?.edit()?.putString(Key.RECEPTION_CODE.str, value)?.apply()
        }

    var receptionDate: String
        get() = mSharedPreferences?.getString(Key.RECEPTION_DATE.str, "") ?: ""
        set(value) {
            mSharedPreferences?.edit()?.putString(Key.RECEPTION_DATE.str, value)?.apply()
        }
}
