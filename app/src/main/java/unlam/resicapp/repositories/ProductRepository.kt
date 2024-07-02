package unlam.resicapp.repositories

import unlam.resicapp.data.Product
import unlam.resicapp.data.ProductClasification
import unlam.resicapp.data.ProductType

object ProductRepository {

    private val products = mutableListOf<Product>()

    init {
        products.add(
            Product(
                1L,
                "El Principito",
                ProductType.BOOK,
                ProductClasification.SILVER,
                "1943/04/06",
                "Literatura infantil",
                4.7,
                150000.00,
                "https://vreditoras.com.ar//uploads/libros/9595ce5ecd589f1f08d7256c287704f4El-principito-edicion-de-lujo-TAPA-WEB.jpg",
                "Antoine Saint-Exupery"
            )
        )

        products.add(
            Product(
                2L,
                "Shingeki no Kyojin",
                ProductType.BOOK,
                ProductClasification.PLATINUM,
                "2009/09/09",
                "Manga",
                4.9,
                1500.00,
                "https://i.pinimg.com/originals/84/75/57/8475573b0413f5826d175f39621db234.png",
                "Hajime Isayama"
            )
        )

        products.add(
            Product(
                3L,
                "Abbey Road",
                ProductType.DISC,
                ProductClasification.GOLD,
                "1969/09/24",
                "Rock",
                5.0,
                55000.00,
                "https://upload.wikimedia.org/wikipedia/en/4/42/Beatles_-_Abbey_Road.jpg",
                "The Beatles"
            )
        )

        products.add(
            Product(
                4L,
                "Los arboles mueren de pie",
                ProductType.BOOK,
                ProductClasification.BRONZE,
                "1949/04/01",
                "Obra teatral",
                2.3,
                35000.00,
                "https://images.cdn2.buscalibre.com/fit-in/360x360/41/40/414025393e2bccd4b8ab3c23ea5317dd.jpg",
                "Alejandro Casona"
            )
        )

        products.add(
            Product(
                5L,
                "Dark Side of the Moon",
                ProductType.DISC,
                ProductClasification.PLATINUM,
                "1973/03/01",
                "Progressive Rock",
                5.0,
                60000.00,
                "https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png",
                "Pink Floyd"
            )
        )

        products.add(
            Product(
                6L,
                "Caravana",
                ProductType.DISC,
                ProductClasification.GOLD,
                "2020/10/23",
                "Hip Hop",
                4.6,
                52000.00,
                "https://indiehoy.com/wp-content/uploads/2019/10/wos-caravana.jpg",
                "Wos"
            )
        )

        products.add(
            Product(
                7L,
                "Animal",
                ProductType.DISC,
                ProductClasification.SILVER,
                "2021/07/16",
                "Reggaeton",
                4.4,
                49000.00,
                "https://upload.wikimedia.org/wikipedia/en/5/58/Maria_Becerra_-_Animal.jpeg",
                "María Becerra"
            )
        )

        products.add(
            Product(
                8L,
                "Cien años de soledad",
                ProductType.BOOK,
                ProductClasification.GOLD,
                "1967/05/30",
                "Realismo mágico",
                4.8,
                450.00,
                "https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg",
                "Gabriel García Márquez"
            )
        )

        products.add(
            Product(
                9L,
                "Harry Potter y la piedra filosofal",
                ProductType.BOOK,
                ProductClasification.BRONZE,
                "1997/06/26",
                "Fantasy",
                4.9,
                650.00,
                "https://images.cdn2.buscalibre.com/fit-in/360x360/e6/5f/e65f54742ad7bbc41903d17f75b77d78.jpg",
                "J.K. Rowling"
            )
        )

        products.add(
            Product(
                10L,
                "1984",
                ProductType.BOOK,
                ProductClasification.GOLD,
                "1949/06/08",
                "Novela distópica",
                4.6,
                480.00,
                "https://images.cdn1.buscalibre.com/fit-in/360x360/b0/39/b039af065268818b7bd3b0e016f8db65.jpg",
                "George Orwell"
            )
        )
    }

    fun getProducts(): List<Product> = products.toList()

    fun getProductById(id: Long) = products.find { it.id == id }

}