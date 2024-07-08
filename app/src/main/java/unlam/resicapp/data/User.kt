package unlam.resicapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Long,
    val nickName: String,
    val password: String,
    // ToDo:: -10- *Decidir si utilizar estos datos* / Priority: Baja
    val name: String,
    val surname: String,
    val money: Double,
    val createdDate: String
):Parcelable
