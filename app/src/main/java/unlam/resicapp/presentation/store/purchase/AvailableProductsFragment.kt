package unlam.resicapp.presentation.store.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resicappandroid.R
import com.example.resicappandroid.databinding.FragmentAvailableProductsBinding
import unlam.resicapp.data.Product
import unlam.resicapp.managers.ProductManager

class AvailableProductsFragment : Fragment() {

    private var _binding: FragmentAvailableProductsBinding? = null
    private val binding get() = _binding!!

    private val productManager = ProductManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAvailableProductsBinding.inflate(inflater, container, false)

        // Recycler View & Adapter
        val recyclerView = binding.availableProductsRV
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val recyclerViewAdapter = AvailableProductsAdapter { product ->
            navigateToPurchaseFragment(product)
        }
        recyclerView.adapter = recyclerViewAdapter

        // Load list
        recyclerViewAdapter.submitList(productManager.getListOfAvailableProducts())

        return binding.root

    }

    private fun navigateToPurchaseFragment(product: Product) {
        val action =
            AvailableProductsFragmentDirections.actionAvailableProductsFragmentToPurchaseFragment(
                product
            )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}