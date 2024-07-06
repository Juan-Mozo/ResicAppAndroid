package unlam.resicapp.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resicappandroid.R
import com.example.resicappandroid.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import unlam.resicapp.managers.UserManager

class LoginFragment : Fragment() {

    private val userManager = UserManager()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            val user = binding.userEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (user.isEmpty() || password.isEmpty()) {
                Snackbar.make(requireView(), R.string.message_empty_text, Snackbar.LENGTH_SHORT).show()
            }

            if (userManager.isUserValid(user, password) != null) {
                // ToDo:: -3- *Pasar usuario por navegación* / Priority: Alta
                // Description:
                navigateToStore(user)
            } else {
                Snackbar.make(requireView(), R.string.message_incorrect_login, Snackbar.LENGTH_SHORT).show()
            }
        }

        return binding.root

    }

    private fun navigateToStore(user: String) {
        val action =  LoginFragmentDirections.actionLoginFragmentToStoreFragment(user)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}