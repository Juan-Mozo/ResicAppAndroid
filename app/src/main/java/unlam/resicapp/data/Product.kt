package unlam.resicapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Long,
    val name: String,
    val type: ProductType,
    val classification: ProductClasification,
    val releasedDate: String,
    val category: String,
    val stars: Double,
    val price: Double,
    val logo: String,
    val author: String
): Parcelable