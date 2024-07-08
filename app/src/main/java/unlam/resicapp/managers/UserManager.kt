package unlam.resicapp.managers

import unlam.resicapp.data.User
import unlam.resicapp.repositories.UserRepository

class UserManager {
    // ToDo:: -9- *Agregar Try-Catch Personalizado* / Priority: Alta
    // Description:
    fun isUserValid(nickNameToFind: String, passwordToFind: String) : User? {
        return UserRepository.getUsersList().find {
            it.nickName.lowercase() == nickNameToFind.lowercase() && it.password == passwordToFind
        }
    }

    fun setUserLogged(user: User){
        UserRepository.setUserLogged(user)
    }

    fun getUserLogged(): User {
        return UserRepository.getUserLogged()
    }
}