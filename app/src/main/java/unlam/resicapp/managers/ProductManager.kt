package unlam.resicapp.managers

import unlam.resicapp.data.Product
import unlam.resicapp.repositories.ProductRepository

class ProductManager {
    fun getListOfAvailableProducts(): List<Product> {
        return ProductRepository.getProducts()
    }

    fun getProductById(id: Long): Product? {
        return ProductRepository.getProductById(id)
    }

}