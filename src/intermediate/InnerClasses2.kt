package intermediate
// **************************** NESTED CLASSES ****************************
class Cart {
    data class Product(val productName: String, val price: Double)

    private val products = mutableListOf<Product>()

    fun addToCart(productName: String, price: Double): Boolean{
        products.add(Product(productName, price))
        println("Product added to cart")
        return true
    }

    fun displayItems(){
        for (item in products.withIndex())
            println("id: ${item.index + 1} product details: ${item.value}")
    }
}

class OrderHistory {
    private data class Item(
        val productName: String,
        val price: Double,
        val quantity: Int,
        val orderedAt: String,
        val deliveredAt: String
    )

    private val items = mutableListOf<Item>()

    fun purchaseItem(){
        TODO("As of now no need to implement")
    }

    fun displayItems(){
        for (item in items.withIndex())
            println("id: ${item.index+1} product details: ${item.value}")
    }
}

// **************************** INNER CLASSES ****************************
class Person(val name: String, val dob: String, val gender: String) {

    inner class Education{
        internal var currentEducation = "schooling"

        internal fun isPengalScholarship(): Boolean = this@Person.gender == "girl"
    }
}

fun main() {

    // NESTED CLASS
    val cart = Cart()
    cart.addToCart("Shoe", 900.0)
    cart.addToCart("Drimmer", 1100.0)
    cart.addToCart("Skipper", 190.0)
    cart.displayItems()

    // INNER CLASS
    val sabari = Person("sabari", "05/02/2002", "male")
    val sabariEdu1 = sabari.Education()
    val sabariEdu2 = sabari.Education()
    sabariEdu2.currentEducation = "college"

    println("Sabari Education1 - ${sabariEdu1.currentEducation}, Education2 - ${sabariEdu2.currentEducation} ")
}