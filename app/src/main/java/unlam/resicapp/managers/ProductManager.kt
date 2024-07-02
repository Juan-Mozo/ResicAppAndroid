package unlam.resicapp.managers

import unlam.resicapp.repositories.ProductRepository

class ProductManager {

    fun getListOfAvailableProducts() {
        ProductRepository.getProducts()
    }

}