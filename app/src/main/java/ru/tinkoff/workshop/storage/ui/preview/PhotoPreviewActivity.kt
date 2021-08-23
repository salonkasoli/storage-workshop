package ru.tinkoff.workshop.storage.ui.preview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import ru.tinkoff.workshop.storage.R

class PhotoPreviewActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_URI = "uri"

        fun intent(context: Context, uri: Uri): Intent {
            return Intent(context, PhotoPreviewActivity::class.java).apply {
                putExtra(EXTRA_URI, uri.toString())
            }
        }
    }

    private val uri: Uri
        get() = Uri.parse(intent.getStringExtra(EXTRA_URI))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_preview)
        findViewById<View>(R.id.shareButton).setOnClickListener {
            shareImage()
        }
        findViewById<ImageView>(R.id.imageView).setImageURI(uri)
    }

    private fun shareImage() {
       // TODO()
    }
}