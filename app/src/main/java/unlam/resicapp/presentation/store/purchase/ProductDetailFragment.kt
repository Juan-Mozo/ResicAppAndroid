package unlam.resicapp.presentation.store.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.resicappandroid.R
import com.example.resicappandroid.databinding.FragmentProductDetailBinding
import unlam.resicapp.data.Product
import unlam.resicapp.data.User
import unlam.resicapp.data.exeptions.InsufficientMoneyException
import unlam.resicapp.managers.PurchaseManager
import unlam.resicapp.managers.UserManager
import unlam.resicapp.presentation.util.ImageTransformation
import java.time.LocalDateTime


class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ProductDetailFragmentArgs by navArgs()
    private val userManager = UserManager()
    private val purchaseManager = PurchaseManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = args.product
        val user = userManager.getUserLogged()
        val date = LocalDateTime.now()

        setupViews(product, user)

        val productPriceTextView = binding.productPrice
        val productFinalPrice = purchaseManager.getFinalPrice(product, date)
        productPriceTextView.text = productFinalPrice.toString()

        binding.buyButton.setOnClickListener {
            try {
                purchaseManager.newPurchase(user, product, date, productFinalPrice)
                showToast(getString(R.string.message_succesfully_purchase))
                findNavController().popBackStack() //retorna al usuario al fragment anterior

            } catch (e: InsufficientMoneyException) {
                showToast(e.message!!)
            }
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun setupViews(product: Product, user: User) {
        // Titulo Toolbar
        val moneyTextToolbar = binding.userMoney
        moneyTextToolbar.text = user.money.toString()

        // Imagen del producto
        val productImgUrl = product.logo
        val image = ImageTransformation(productImgUrl)
        image.loadItemSizeImage(binding.productLogo)

        // Nombre del producto
        val productNameTextView = binding.productName
        productNameTextView.text = product.name

        // Autor
        val productAuthorTextView = binding.productAuthor
        productAuthorTextView.text = product.author

        // Tipo de producto
        val productTypeTextView = binding.productType
        productTypeTextView.text = product.type.toString()

        // Clasificación del producto
        val productClassificationTextView = binding.productClassification
        productClassificationTextView.text = product.classification.toString()

        // Fecha de lanzamiento
        val productReleasedDateTextView = binding.productReleasedDate
        productReleasedDateTextView.text = product.releasedDate.toString()

        // Categoría
        val productCategoryTextView = binding.productCategory
        productCategoryTextView.text = product.category

        // Estrellas
        val productStarsTextView = binding.productStars
        productStarsTextView.text = product.stars.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}