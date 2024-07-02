package unlam.resicapp.managers

import unlam.resicapp.data.Product
import unlam.resicapp.data.Purchase
import unlam.resicapp.data.User
import unlam.resicapp.repositories.ProductRepository
import unlam.resicapp.repositories.PurchaseRepository
import unlam.resicapp.util.Date
import java.time.LocalDateTime

class PurchaseManager {

    fun getAllPurchases(): List<Purchase> {
        return PurchaseRepository.getAllPurchases()
    }

    fun sellProduct(userId: Long, product: Product, date: LocalDateTime): Purchase {
        return Purchase(
            id = PurchaseRepository.getAllPurchases().last().id + 1,
            userId = userId,
            productId = product.id,
            productName = product.name,
            amount = product.price + product.classification.calculateFee(product, Date.getDay(date)),
            createdDate = date.toString()
        )
    }

}