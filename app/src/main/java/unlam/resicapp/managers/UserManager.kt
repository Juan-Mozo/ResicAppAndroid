package unlam.resicapp.managers

import unlam.resicapp.data.User
import unlam.resicapp.repositories.UserRepository

class UserManager {

    // ToDo:: -9- *Agregar Try-Catch Personalizado* / Priority: Alta
    // Description:
    fun isUserValid(nickNameToFind: String, passwordToFind: String) : User? {
        return UserRepository.getUsers().find {
            it.nickName.lowercase() == nickNameToFind.lowercase() && it.password == passwordToFind
        }
    }

}