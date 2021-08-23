package ru.tinkoff.workshop.storage.ui.notification

import ru.tinkoff.workshop.storage.ui.notification.rv.NotificationListItem

interface NotificationListView {

    fun renderData(list: List<NotificationListItem>)

    fun showError(error: Throwable)
}