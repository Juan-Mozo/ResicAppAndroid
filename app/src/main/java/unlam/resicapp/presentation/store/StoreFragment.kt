package unlam.resicapp.presentation.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resicappandroid.R
import com.example.resicappandroid.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        // ToDo:: -10- *No permitir volver atrás* / Priority: Media
        // Description: Lanzar snackbar preguntando si quiere cerrar la sesión

        binding.buttonToPurchase.setOnClickListener {
            val action =  R.id.action_storeFragment_to_availableProductsFragment
            findNavController().navigate(action)
        }

        binding.buttonToPurchaseHistory.setOnClickListener {
            val action =  R.id.action_storeFragment_to_purchaseHistoryFragment
            findNavController().navigate(action)
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}