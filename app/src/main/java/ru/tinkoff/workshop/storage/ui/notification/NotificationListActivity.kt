package ru.tinkoff.workshop.storage.ui.notification

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.tinkoff.workshop.storage.R
import ru.tinkoff.workshop.storage.ui.notification.rv.NotificationListAdapter
import ru.tinkoff.workshop.storage.ui.notification.rv.NotificationListItem

class NotificationListActivity : AppCompatActivity(), NotificationListView {

    companion object {

        fun intent(context: Context): Intent {
            return Intent(context, NotificationListActivity::class.java)
        }
    }

    private val adapter = NotificationListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_list)
        findViewById<RecyclerView>(R.id.list).adapter = adapter
        NotificationListPresenter(this, lifecycle).loadData()
    }

    override fun renderData(list: List<NotificationListItem>) {
        adapter.data.clear()
        adapter.data.addAll(list)
        adapter.notifyDataSetChanged()
        Toast.makeText(this, "data loaded, size = ${list.size}", Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this, error.javaClass.simpleName, Toast.LENGTH_SHORT).show()
        Log.wtf("lol", "error = $error")
    }
}