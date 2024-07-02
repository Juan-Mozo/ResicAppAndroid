package unlam.resicapp.data

data class Purchase(
    val id: Long,
    val userId: Long,
    val productId: Long,
    val productName: String,
    val amount: Double,
    val createdDate: String,
)
