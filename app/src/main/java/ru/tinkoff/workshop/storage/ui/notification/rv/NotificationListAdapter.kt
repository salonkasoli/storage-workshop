package ru.tinkoff.workshop.storage.ui.notification.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.tinkoff.workshop.storage.R

class NotificationListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: MutableList<NotificationListItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.notification_item, parent, false) as ViewGroup
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        holder as Holder
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class Holder(
        container: ViewGroup
    ) : RecyclerView.ViewHolder(container) {

        private val packageText = container.findViewById<TextView>(R.id.packageText)

        fun bind(item: NotificationListItem) {
            packageText.text = item.packageText
        }
    }
}

data class NotificationListItem(
    val packageText: String
)