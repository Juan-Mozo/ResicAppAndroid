package unlam.resicapp.presentation.store.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.resicappandroid.databinding.FragmentPurchaseBinding
import unlam.resicapp.data.Product

class PurchaseFragment : Fragment() {

    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!
    private val args: PurchaseFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)

        // ToDo:: -6- *PurchaseFragment* / Priority: Alta
        // Description: Mostrar rv con los productos disponibles y permitir confirmar compra en otro fragment

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = args.product
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}