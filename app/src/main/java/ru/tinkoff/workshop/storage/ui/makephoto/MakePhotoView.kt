package ru.tinkoff.workshop.storage.ui.makephoto

import android.net.Uri

interface MakePhotoView {
    fun navigateToPhotoPreview(uri: Uri)
    fun showError(message: String)
}