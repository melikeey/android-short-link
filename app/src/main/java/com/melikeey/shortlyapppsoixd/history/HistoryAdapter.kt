package com.melikeey.shortlyapppsoixd.history

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.melikeey.shortlyapppsoixd.R
import com.melikeey.shortlyapppsoixd.database.History


class HistoryAdapter :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private lateinit var historyList: List<History>

    private var mHistoryAdapterCallback: HistoryAdapterCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    fun setItem(historyList: List<History>) {
        this.historyList = historyList
    }

    fun setCallBack(callbackHistory: HistoryAdapterCallback) {
        this.mHistoryAdapterCallback = callbackHistory
    }

    override fun getItemCount(): Int = historyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvShortLink.text = historyList[position].shortUrl
        holder.etLink.setText(historyList[position].url)
        holder.btnCopy.setOnClickListener {
            val clipboard: ClipboardManager? =
                holder.itemView.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
            val clip = ClipData.newPlainText(
                historyList[position].shortUrl,
                historyList[position].shortUrl
            )
            clipboard?.setPrimaryClip(clip)
            holder.btnCopy.text = holder.itemView.context.getString(R.string.copied)
            holder.btnCopy.setBackgroundColor(Color.BLACK)
            holder.btnCopy.setTextColor(Color.WHITE)
        }

        holder.etLink.setOnClickListener {
            mHistoryAdapterCallback?.itemDeleted(historyList[position].id);
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvShortLink: TextView = view.findViewById(R.id.tv_short_link)
        val etLink: EditText = view.findViewById(R.id.et_link)
        val btnCopy: Button = view.findViewById(R.id.btn_copy)
    }
}