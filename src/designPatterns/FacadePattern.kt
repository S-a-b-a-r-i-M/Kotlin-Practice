package designPatterns

import java.lang.Exception

class OutOfStockException (message: String) : Exception(message)
class PaymentFailedException (message: String) : Exception(message)

data class Product(val id: Int, var name: String, var price: Double)
data class User(val id: Int, var name: String, var address: String?)

class Inventory {
    fun isStockAvailabe(productId: Int, quantity: Int): Boolean {
        println("Stock is available")
        return true
    }
}

class Payment {
    fun makePayment(amount: Double): Boolean {
        println("Making payment")
        return true
    }
}

class Delivery {
    fun prepareDelivery(product: Product, toAddress: String){
        println("Delivery started")
    }
}

class FraudDetection {
    fun isUserFraud(user: User): Boolean {
        println("User isn't a fraud")
        return false
    }
}

class ProductFacade {
    // TODO: Get these values from constructor
    private val fraudDetection = FraudDetection()
    private val inventory = Inventory()
    private val payment = Payment()
    private val delivery = Delivery()

    fun buyProduct(product: Product, user: User){
        if (fraudDetection.isUserFraud(user))
            throw IllegalStateException("User is fraud")

        if (!inventory.isStockAvailabe(product.id, 1))
            throw OutOfStockException("out of stock")

        if (!payment.makePayment(product.price))
            throw PaymentFailedException("payment failed")
        if (user.address == null){
            println("Enter users address")
            user.address = readln()
        }

        user.address?.let { delivery.prepareDelivery(product, it) }
    }
}

// Client Side
fun main() {
    // Just Working with ProductFacade
    val productFacade = ProductFacade()
    productFacade.buyProduct(
        Product(1, "bat", 2000.0),
        User(1, "Sabari", "xxx,yyy,zzz.")
    )
}