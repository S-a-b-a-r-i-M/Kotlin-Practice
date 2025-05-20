package designPatterns

// Function type as strategy
typealias DiscountStrategy = (Double) -> Double

// Concrete strategies as functions
val regularDiscount: DiscountStrategy = { it * 0.05 }
val premiumDiscount: DiscountStrategy = { it * 0.15 }
val blackFridayDiscount: DiscountStrategy = { it * 0.30 }

// Context
class PriceCalculator(private var discountStrategy: DiscountStrategy) {
    fun setDiscountStrategy(strategy: DiscountStrategy) {
        this.discountStrategy = strategy
    }

    fun calculateFinalPrice(basePrice: Double): Double {
        val discount = discountStrategy(basePrice)
        return basePrice - discount
    }
}

// Usage
fun main() {
    val calculator = PriceCalculator(regularDiscount)
    val regularPrice = calculator.calculateFinalPrice(100.0) // 95.0

    calculator.setDiscountStrategy(blackFridayDiscount)
    val salePrice = calculator.calculateFinalPrice(100.0) // 70.0
}