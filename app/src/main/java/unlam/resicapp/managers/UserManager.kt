package unlam.resicapp.managers

import unlam.resicapp.data.User
import unlam.resicapp.repositories.UserRepository

class UserManager {
    fun isUserValid(nickNameToFind: String, passwordToFind: String) : User? {
        return UserRepository.getUsersList().find { user ->
                user.nickName.lowercase() == nickNameToFind.lowercase() && user.password == passwordToFind
        }

    }

    fun setUserLogged(user: User){
        UserRepository.setUserLogged(user)
    }

    fun getUserLogged(): User {
        return UserRepository.getUserLogged()
    }

    fun updateCurrentBalance(user: User, paid: Double) {
        UserRepository.setBalance(user.id, user.money - paid)
    }
}