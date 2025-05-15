package intermediate

// Product catalog with nested utility classes (static relationship)
class ProductCatalog {
    private val products = mutableMapOf<Int, Product>()

    // Nested class - doesn't need to access to outer class instance
    data class Product(
        val name: String,
        val price: Double,
        val category: Category
    ){
        val id: Int = productId++

        companion object {
            var productId = 1
        }
    }

    // Nested enum class for product categories
    enum class Category(val value: String) {
        BOOKS("BOOKS"),
        ELECTRONICS("ELECTRONICS & KITCHEN"),
        SPORTS("SPORTS"),
        CLOTHS("CLOTHS"),
        FURNITURE("FURNITURE")
    }

    // Nested utility class for searching and filtering
    inner class ProductFilter {
        fun filterByCategory(category: Category): List<Product> {
            TODO("Neram vara villai")
        }

        fun filterByPrice(price: Double): List<Product> {
            TODO("Neram vara villai")
        }

        fun filterByName(name: String): List<Product> {
            TODO("Neram vara villai")
        }
    }

    // Other Methods
    fun addProduct(name: String, price: Double, category: Category){
        val product = Product(name, price, category)
        products.put(product.id, product)
    }

    fun getProductById(id: Int): Product? = products.values.find { it.id == id }

    fun removeProduct(productId: Int) {
        TODO("Neram vara villai")
    }

    fun listAllProducts(){
        products.values.toList().forEach { println(it) }
    }
}

// User profile with inner classes (instance-bound relationship)
class UserProfile (
    val id: Int,
    val name: String,
    initialBalance: Double
) {
    private val purchaseHistory = mutableListOf<Order>()
    private var accountBalance = initialBalance

    // Inner class with access to user's account info
    data class CartItem(val product: ProductCatalog.Product, var quantity: Int = 1)
    inner class Cart {
        private val items = mutableListOf<CartItem>()

        fun addToCart(product: ProductCatalog.Product) {
            val existingItem: CartItem? = items.find { it -> it.product.id == product.id }
            if (existingItem != null)
                existingItem.quantity = existingItem.quantity + 1
            else
                items.add(CartItem(product, 1))
        }

        fun removeItem(item: CartItem){
            TODO("Neram vara villai")
        }

        fun listAllItems() {
            items.forEach { println(it) }
        }

        fun calculateTotalPrice() : Double = items.sumOf { it.product.price * it.quantity }

        fun checkout() {
            val totalPrice = calculateTotalPrice()
            if (accountBalance < totalPrice){
                println("Insufficient Balance")
                return
            }

            purchaseHistory.add(
                Order(
                    items.map { it.product },
                    items.size,
                    totalPrice
                )
            )
            items.clear()
        }
    }

    fun getCart() = Cart()

    // Inner class for order processing
    inner class PaymentProcess {
        fun credit(amount: Double): Boolean {
            if (amount < 0){
                println("Invalid amount")
                return false
            }
            accountBalance += amount
            return true
        }

        fun debit(amount: Double): Boolean {
            if (amount > accountBalance) {
                println("Insufficient balance")
                return false
            }

            accountBalance -= amount
            return true
        }
    }

    // Data class for orders
    data class Order(
        val products: List<ProductCatalog.Product>,
        val numberOfProducts: Int,
        val totalPrice: Double,
        val id: Int = orderId++
    ) {
        companion object {
            var orderId = 1
        }
    }

    fun listPurchaseHistory() = purchaseHistory.forEach { println(it) }
}


fun main() {
    val amazon = ProductCatalog()
    amazon.addProduct("VolleyBall", 1000.0, ProductCatalog.Category.SPORTS)
    amazon.addProduct("Programming Kotlin", 200.99, ProductCatalog.Category.BOOKS)

    val sarah = UserProfile(1, "Sarah Johnson", 2000.0)

    println("--------------- Products ---------------")
    amazon.listAllProducts()
    println("----------------------------------------")

    val sarahCart = sarah.getCart()
    amazon.getProductById(1)?.let {
        sarahCart.addToCart(it)
    } ?: println("Product with id is not found")

    println("--------------- Cart Items ---------------")
    sarahCart.listAllItems()
    println("------------------------------------------")

    sarahCart.checkout()
    println("--------------- Order History ---------------")
    sarah.listPurchaseHistory()
    println("---------------------------------------------")

    println("--------------- Cart Items ---------------")
    println("------------------------------------------")

}