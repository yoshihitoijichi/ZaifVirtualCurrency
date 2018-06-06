package net.ijichi.zaifvirtualcurrency

import android.util.Log
import timber.log.Timber

/**
 * my crash tree
 * Created by ijichiyoshihito on 2018/01/07.
 */
class MyCrashTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        if (priority == Log.ERROR) {
        }

        if (priority == Log.DEBUG) {
        }

        if (priority == Log.WARN) {
        }

        if (priority == Log.INFO) {
        }

    }
}