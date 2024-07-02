package unlam.resicapp.data

data class User(
    val id: Long,
    val nickName: String,
    val password: String,
    val name: String,
    val surname: String,
    val money: Double,
    val createdDate: String
)
