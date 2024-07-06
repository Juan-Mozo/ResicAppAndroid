package unlam.resicapp.presentation.store.purchase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.resicappandroid.R
import unlam.resicapp.data.Product

class AvailableProductsViewHolder(
    view: View
): RecyclerView.ViewHolder(view) {

    private val productImage = view.findViewById<ImageView>(R.id.itemImage)
    private val productNameText = view.findViewById<TextView>(R.id.itemNameText)
    private val amountTitleText = view.findViewById<TextView>(R.id.amountTitle)

    fun bind(item: Product) {
        // ToDo:: -4- *Agregar imagenes* / Priority: Medio
        // Description: Usar libreria picasso y agregar links
        amountTitleText.visibility = View.INVISIBLE
        productNameText.text = item.name
    }

}

class AvailableProductsAdapter(
    private val listener : (Product) -> Unit
): ListAdapter<Product, AvailableProductsViewHolder>(DIFF_CONFIG) {

    companion object {
        val DIFF_CONFIG = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvailableProductsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.purchase_history_item, parent, false)
        return AvailableProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvailableProductsViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { listener(getItem(position)) }
    }

}