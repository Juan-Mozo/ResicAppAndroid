package unlam.resicapp.repositories

import unlam.resicapp.data.Purchase

object PurchaseRepository {

    private val purchases = mutableListOf<Purchase>()

    init {
        purchases.add(Purchase(1L, 1504L, 1L,"El Principito", 350.50, "2023/01/01"))
        purchases.add(Purchase(2L, 1504L, 4L,"Los arboles mueren de pie", 100.75, "2023/01/01"))
        purchases.add(Purchase(3L, 1504L, 7L,"Animal", 250.50, "2023/01/01"))
        purchases.add(Purchase(4L, 1504L, 10L,"1984", 50.00, "2023/01/01"))
        purchases.add(Purchase(5L, 1504L, 3L,"Abbey Road", 1350.15, "2023/01/01"))
        purchases.add(Purchase(6L, 2802L, 2L,"Shingeki no Kyojin", 20.30, "2023/01/01"))
        purchases.add(Purchase(7L, 2802L, 9L,"Harry Potter y la piedra filosofal", 450.75, "2023/01/01"))
        purchases.add(Purchase(8L, 2802L, 2L,"Shingeki no Kyojin", 500.00, "2023/01/01"))
        purchases.add(Purchase(9L, 1510L, 6L,"Caravana", 350.50, "2023/01/01"))
        purchases.add(Purchase(10L, 1510L, 5L,"Dark Side of the Moon", 150.00, "2023/01/01"))
        purchases.add(Purchase(11L, 1515L, 1L,"El Principito", 100.00, "2024/01/01"))
    }

    fun add(purchase: Purchase) = purchases.add(purchase)

    fun getAllPurchases(): List<Purchase> = purchases.toList()


}