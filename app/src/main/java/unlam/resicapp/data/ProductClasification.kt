package unlam.resicapp.data

import unlam.resicapp.managers.util.Date

enum class ProductClasification {
    GOLD {
        override fun calculateFee(product: Product, date: Date): Double {
            return product.price.times(0.02)
        }
    },
    SILVER {
        override fun calculateFee(product: Product, date: Date): Double {
            return if (date.isEvening) {
                product.price.times(0.01)
            } else {
                product.price.times(0.03)
            }
        }
    },
    PLATINUM {
        override fun calculateFee(product: Product, date: Date): Double {
            return when (date) {
                is Date.DayOfTheWeek -> product.price.times(0.0075)
                is Date.Weekend -> product.price.times(0.03)
            }
        }
    },
    BRONZE {
        override fun calculateFee(product: Product, date: Date): Double {
            return 0.0
        }
    };

    abstract fun calculateFee(product: Product, date: Date): Double
}