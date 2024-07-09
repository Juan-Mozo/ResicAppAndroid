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

        setupViews(product, user)


        binding.buyButton.setOnClickListener {
            purchaseManager.newPurchase(user.id, product, LocalDateTime.now())
            showToast(getString(R.string.message_succesfully_purchase))
            findNavController().popBackStack() //retorna al usuario al fragment anterior
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun setupViews(product: Product, user: User) {
        // Titulo Toolbar
        val moneyTextToolbar = binding.userMoneyText
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
        val productAuthor = "Autor: ${product.author}"
        productAuthorTextView.text = productAuthor

        // Tipo de producto
        val productTypeTextView = binding.productType
        val productType = "Tipo: ${product.type}"
        productTypeTextView.text = productType

        // Clasificación del producto
        val productClassificationTextView = binding.productClassification
        val productClassification = "Clasificación: ${product.classification}"
        productClassificationTextView.text = productClassification

        // Fecha de lanzamiento
        val productReleasedDateTextView = binding.productReleasedDate
        val productReleasedDate = "Fecha de lanzamiento: ${product.releasedDate}"
        productReleasedDateTextView.text = productReleasedDate

        // Categoría
        val productCategoryTextView = binding.productCategory
        val productCategory = "Categoría: ${product.category}"
        productCategoryTextView.text = productCategory

        // Estrellas
        val productStarsTextView = binding.productStars
        val productStars = "Estrellas: ${product.stars}"
        productStarsTextView.text = productStars

        // Precio
        val productPriceTextView = binding.productPrice
        val productPrice = "Precio: ${product.price}"
        productPriceTextView.text = productPrice
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}