package unlam.resicapp.managers

import unlam.resicapp.data.User
import unlam.resicapp.repositories.UserRepository

class UserManager {

    fun isUserValid(nickNameToFind: String, passwordToFind: String) : User? {
        return UserRepository.getUsers().find {
            it.nickName.lowercase() == nickNameToFind && it.password == passwordToFind
        }
    }

}