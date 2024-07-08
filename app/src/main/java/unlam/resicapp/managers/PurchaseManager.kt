package unlam.resicapp.managers

import unlam.resicapp.data.Product
import unlam.resicapp.data.Purchase
import unlam.resicapp.repositories.PurchaseRepository
import unlam.resicapp.managers.util.Date
import java.time.LocalDateTime

class PurchaseManager {
    // ToDo:: -7- *Traer compras por id del usuario* / Priority: Media
    // Description:

    fun getAllPurchases(): List<Purchase> {
        return PurchaseRepository.getAllPurchases()
    }

    // ToDo:: -8- *Revisar lógica* / Priority: Alta
    // Description: Actualizar cuando se cambie el enum del ProductClassification.
    // Cheackear saldo del usuario antes de realizar la compra.
    // Lanzar exception por saldo insuficiente o restar del total si se realiza la compra.

    fun newPurchase(userId: Long, product: Product, date: LocalDateTime): Purchase {
        val newPurchase = Purchase(
            id = PurchaseRepository.getAllPurchases().last().id + 1,
            userId = userId,
            productId = product.id,
            amount = product.price + product.classification.calculateFee(product, Date.getDay(date)),
            createdDate = date.toString()
        )
        PurchaseRepository.add(newPurchase)

        return newPurchase
    }

}