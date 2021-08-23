package ru.tinkoff.workshop.storage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.tinkoff.workshop.storage.ui.makephoto.MakePhotoActivity
import ru.tinkoff.workshop.storage.ui.notification.NotificationListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.internalStorageButton).setOnClickListener {
            startActivity(MakePhotoActivity.intent(this))
        }
        findViewById<View>(R.id.notificationList).setOnClickListener {
            startActivity(NotificationListActivity.intent(this))
        }
        findViewById<View>(R.id.notificationPermission).setOnClickListener {
            startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
        }
    }
}