package net.ijichi.zaifvirtualcurrency

import android.app.Application
import android.content.Context
import timber.log.Timber

/**
 * application class
 * Created by ijichiyoshihito on 2018/01/07.
 */
class ZaifApplication: Application(){

    companion object {
        private lateinit var mInstance: ZaifApplication

        val instance: ZaifApplication
            get() = mInstance
        val context: Context
            get() = instance.applicationContext
    }

    init {
        mInstance = this
    }

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        MySharedPreferences.init(this)
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        else
            Timber.plant(MyCrashTree())
    }
}