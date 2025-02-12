package unlam.resicapp.managers

import unlam.resicapp.data.Product
import unlam.resicapp.data.Purchase
import unlam.resicapp.data.User
import unlam.resicapp.managers.exceptions.InsufficientMoneyException
import unlam.resicapp.repositories.PurchaseRepository
import unlam.resicapp.managers.util.Date
import java.time.LocalDateTime

class PurchaseManager {
    private val userManager = UserManager()
    private fun getAllPurchases(): List<Purchase> {
        return PurchaseRepository.getAllPurchases()
    }

    fun getPurchasesOfUser(user: User): List<Purchase> {
        return getAllPurchases().filter{ it.userId == user.id }
    }

    fun getFinalPrice(product: Product, date: LocalDateTime): Double {
        return product.price + product.classification.calculateFee(product, Date.getDay(date))
    }
    fun newPurchase(user: User, product: Product, date: LocalDateTime, finalPrice: Double): Purchase {
        if(user.money <= product.price) {
            throw InsufficientMoneyException("Saldo insuficiente para realizar compra")
        }
        val newPurchase = Purchase(
            id = PurchaseRepository.getAllPurchases().last().id + 1,
            userId = user.id,
            productId = product.id,
            amount = finalPrice,
            createdDate = date.year.toString() + "/"
                    + date.monthValue.toString() + "/"
                    + date.dayOfMonth.toString()
        )
        PurchaseRepository.add(newPurchase)
        userManager.updateCurrentBalance(user, finalPrice)

        return newPurchase
    }

}