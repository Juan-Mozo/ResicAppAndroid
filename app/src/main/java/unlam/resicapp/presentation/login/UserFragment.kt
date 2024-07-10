package unlam.resicapp.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.resicappandroid.databinding.FragmentUserBinding
import unlam.resicapp.managers.UserManager


class UserFragment : Fragment() {

    private val userManager = UserManager()

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)

        val user = userManager.getUserLogged()

        binding.nickname.text = user.nickName.uppercase()
        binding.userName.text = user.name
        binding.userSurname.text = user.surname
        binding.userCreatedDate.text = user.createdDate
        binding.userScreenMoney.text = user.money.toString()

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}