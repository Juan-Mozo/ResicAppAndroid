package unlam.resicapp.presentation.store.purchase_history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.resicappandroid.R
import unlam.resicapp.data.Purchase

class PurchaseHistoryViewHolder(
    view: View
): RecyclerView.ViewHolder(view) {

    private val productImage = view.findViewById<ImageView>(R.id.itemImage)
    private val productNameText = view.findViewById<TextView>(R.id.itemNameText)
    private val purchaseAmountText = view.findViewById<TextView>(R.id.itemAmountText)
    private val dateText = view.findViewById<TextView>(R.id.itemDate)

    fun bind(item: Purchase) {
        // ToDo:: -4- *Agregar imagenes* / Priority: Medio
        // Description: Usar libreria picasso y agregar links
        productNameText.text = item.productName
        purchaseAmountText.text = item.amount.toString()
        dateText.text = item.createdDate
    }

}

class PurchaseHistoryAdapter(): ListAdapter<Purchase, PurchaseHistoryViewHolder>(DIFF_CONFIG) {

    companion object {
        val DIFF_CONFIG = object : DiffUtil.ItemCallback<Purchase>() {
            override fun areItemsTheSame(oldItem: Purchase, newItem: Purchase): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Purchase, newItem: Purchase): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseHistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.purchase_history_item, parent, false)
        return PurchaseHistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: PurchaseHistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}