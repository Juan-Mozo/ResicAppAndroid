package unlam.resicapp.repositories

import unlam.resicapp.data.User

object UserRepository {

    private val users = mutableListOf<User>()
    private var userLogged : User? = null

    init {
        users.add(User(1504L, "bbayarri", "abc123", "Brian", "Bayarri", 3500000.50, "2022/12/10"))
        users.add(User(2802L, "AHOZ", "lock_password", "Aylen", "Hoz", 200000.50, "2021/01/11"))
        users.add(User(1510L, "Diegote", "@12345", "Diego", "Gonzalez", 120000.0, "2018/04/15"))
        users.add(User(1515L, "Leo", "Leo123", "Leonardo", "Toloza", 190000.0, "2024/02/14"))
    }

    fun getUsersList(): List<User> = users

    fun setUserLogged(user: User){
        userLogged = user
    }

    fun getUserLogged(): User {
        return userLogged!!
    }
}