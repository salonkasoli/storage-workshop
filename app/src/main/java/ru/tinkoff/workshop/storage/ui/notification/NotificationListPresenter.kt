package ru.tinkoff.workshop.storage.ui.notification

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

class NotificationListPresenter(
    private val view: NotificationListView,
    lifecycle: Lifecycle
) : LifecycleObserver {

    private val compositeDisposable = CompositeDisposable()

    init {
        lifecycle.addObserver(this)
    }

    fun loadData() {
        // TODO
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        compositeDisposable.dispose()
    }
}