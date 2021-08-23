package ru.tinkoff.workshop.storage.ui.makephoto

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.fotoapparat.result.PhotoResult
import io.reactivex.disposables.Disposable

class MakePhotoPresenter(
    private val view: MakePhotoView,
    lifecycle: Lifecycle
) : LifecycleObserver {

    private var disposable: Disposable? = null

    init {
        lifecycle.addObserver(this)
    }

    fun saveImage(photoResult: PhotoResult) {
        // TODO()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        disposable?.dispose()
    }
}