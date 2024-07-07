package unlam.resicapp.presentation.store.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.resicappandroid.databinding.FragmentProductDetailBinding
import unlam.resicapp.data.Product
import unlam.resicapp.presentation.util.ImageTransformation

class ProductDetailFragment : Fragment() {
    // ToDo:: -6- *ProductDetailFragment* / Priority: Alta
    // Description: Mostrar producto seleccionado y permitir confirmar compra
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ProductDetailFragmentArgs by navArgs()

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
        setupViews(product)

        binding.buyButton.setOnClickListener{

        }

    }
    private fun setupViews(product: Product) {
    // imagen del producto
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