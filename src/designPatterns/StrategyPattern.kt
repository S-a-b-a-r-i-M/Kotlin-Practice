package designPatterns

data class PaymentResponse(val success: Boolean, val transactionId: String?, val error: String?)

// 1. Define the Strategy interface
interface PaymentStrategy {
    fun pay(amount: Double): PaymentResponse
}

// Define concrete strategies
class CreditCardStrategy (
    val cardNumber: String,
    val expiryDate: String,
    val cvv: String
) : PaymentStrategy {
    override fun pay(amount: Double): PaymentResponse {
        println("Processing $amount payment using Credit Card: ${cardNumber.takeLast(4)}")
        return PaymentResponse(true, "CC-${System.currentTimeMillis()}", null)
    }
}

class UPIStrategy (val upiId: String) : PaymentStrategy {
    override fun pay(amount: Double): PaymentResponse {
        println("Processing $amount payment using upi: $upiId")
        return PaymentResponse(true, "UPI-${System.currentTimeMillis()}", null)
    }
}

class BankTransferStrategy (val accountNumber: String) : PaymentStrategy {
    override fun pay(amount: Double): PaymentResponse {
        println("Processing $amount payment using bank transfer: $accountNumber")
        return PaymentResponse(true, "BT-${System.currentTimeMillis()}", null)
    }
}

// Create a context that uses the strategy
class PaymentProcessor2 (private var paymentStrategy: PaymentStrategy) {

    public fun setPaymentStrategy(paymentStrategy: PaymentStrategy) {
        this.paymentStrategy = paymentStrategy
    }

    fun processPayment(amount: Double) : PaymentResponse {
        if (amount <= 0) return PaymentResponse(false, null, "Invalid Amount")

        return paymentStrategy.pay(amount)
    }
}

// Client code
fun main() {
    // Create strategies
    val creditCardStrategy = CreditCardStrategy("1234-5678-9012-3456", "123", "12/25")
    val payPalStrategy = UPIStrategy("customer@pthdfc")

    // Create processor with initial strategy
    val paymentProcessor = PaymentProcessor2(creditCardStrategy)

    // Process payment with credit card
    val result1 = paymentProcessor.processPayment(100.0)
    println("Payment result: ${if (result1.success) "Success" else "Failed"}, ID: ${result1.transactionId}")

    // Change strategy at runtime based on user selection
    paymentProcessor.setPaymentStrategy(payPalStrategy)

    // Process payment with PayPal
    val result2 = paymentProcessor.processPayment(200.0)
    println("Payment result: ${if (result2.success) "Success" else "Failed"}, ID: ${result2.transactionId}")
}