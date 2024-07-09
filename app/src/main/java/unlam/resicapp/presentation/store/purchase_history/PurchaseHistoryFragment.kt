package unlam.resicapp.presentation.store.purchase_history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resicappandroid.databinding.FragmentPurchaseHistoryBinding
import unlam.resicapp.data.User
import unlam.resicapp.managers.PurchaseManager
import unlam.resicapp.managers.UserManager

class PurchaseHistoryFragment : Fragment() {

    private var _binding: FragmentPurchaseHistoryBinding? = null
    private val binding get() = _binding!!

    private val purchaseManager = PurchaseManager()
    private val userManager = UserManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPurchaseHistoryBinding.inflate(inflater, container, false)
        val user = userManager.getUserLogged()
        // Recycler View
        val recyclerView = binding.purchaseHistoryRV
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val recyclerViewAdapter = PurchaseHistoryAdapter()
        recyclerView.adapter = ConcatAdapter(recyclerViewAdapter)

        // Load list
        recyclerViewAdapter.submitList(purchaseManager.getPurchasesOfUser(user))

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}