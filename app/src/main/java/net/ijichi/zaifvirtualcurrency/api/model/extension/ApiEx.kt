package net.ijichi.zaifvirtualcurrency.api.model.extension

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * api extension
 * Created by ijichiyoshihito on 2018/01/09.
 */
fun <T> Single<T>.fetch(onSuccess: ((T)->Unit), onError: ((Throwable)->Unit)): Disposable {
    return subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(object : DisposableSingleObserver<T>() {
            override fun onSuccess(t: T) {
                onSuccess.invoke(t)
            }
            override fun onError(e: Throwable) {
                Timber.e(e)
                onError.invoke(e)
            }
        })
}
