package unlam.resicapp.presentation.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resicappandroid.R

class HeaderViewHolder(
    view: View
): RecyclerView.ViewHolder(view) {

    private val headerTitle = view.findViewById<TextView>(R.id.header_title)

    fun bind(title: String?) {
        if (title != null) {
            headerTitle.text = title
        }
    }

}

class HeaderAdapter(
    private val headerTitle: String?
): RecyclerView.Adapter<HeaderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_item, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(headerTitle)
    }

    override fun getItemCount(): Int {
        return 1
    }
}