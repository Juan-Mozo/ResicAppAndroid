package unlam.resicapp.data

data class Product(
    // ToDo:: -4- *Agregar referencia a imagen* / Priority: Media
    // Description:
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
)