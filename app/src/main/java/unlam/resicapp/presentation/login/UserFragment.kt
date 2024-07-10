package unlam.resicapp.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resicappandroid.R
import com.example.resicappandroid.databinding.FragmentUserBinding
import com.google.android.material.snackbar.Snackbar
import unlam.resicapp.managers.UserManager
import unlam.resicapp.managers.exceptions.UserNotFoundException


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

    private fun navigateToStore() {
        val action =  R.id.action_loginFragment_to_availableProductsFragment
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}