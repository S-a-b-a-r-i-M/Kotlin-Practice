package designPatterns

// Adaptee (the incompatible service we want to use)
data class StripeChargeResponse(val id: Int, val status: String)

class StripeClient {
    // Note the completely different interface
    fun createCharge (
        amountInCents: Int,
        countryCode: String,
        stripeToken: String,
        idempotencyKey: String
    ) : StripeChargeResponse {
        println("Stripe API Invoked")
        return StripeChargeResponse(1, "succeeded")
    }
}

//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-//

// Data classes for our domain
data class CardDetails (
    val cardNumber: String,
    val expiryMonth: Int,
    val expiryYear: Int,
    val cvv: String
)

data class PaymentResult (
    val success: Boolean,
    val transactionId: Int?,
    val error: String?
)

// Target interface (what the client expects)
interface PaymentProcessor {
    fun processPayment(amount: Double, country: String, cardDetails: CardDetails): PaymentResult
}

// Adapter - Makes StripeAPIClient work with PaymentProcessor interface
class StripePaymentAdapter (private val stripeClient: StripeClient) : PaymentProcessor {
    override fun processPayment(
        amount: Double,
        country: String,
        cardDetails: CardDetails
    ): PaymentResult {
        try {
            // Convert data formats for Stripe
            val amountInCents = (amount * 100).toInt()
            val countryCode = country.substring(0, 2).uppercase() // Time being
            val stripeToken = createStripeToken(cardDetails)
            val idempotencyKey = getIdempotencyKey()

            // Call the adaptee
            val response: StripeChargeResponse = stripeClient.createCharge(
                amountInCents,
                countryCode,
                stripeToken,
                idempotencyKey
            )

            // Convert response back to our domain format
            return if (response.status == "succeeded") {
                PaymentResult(true, response.id, null)
            } else {
                PaymentResult(false, response.id, "Payment failed")
            }
        } catch (exp: Exception) {
            println("Error thrown at processPayment")
            return PaymentResult(false, null, exp.message)
        }
    }

    private fun createStripeToken(cardDetails: CardDetails): String {
        // Would actually call Stripe API to convert card to token
        return "tok_${cardDetails.cardNumber.takeLast(4)}"
    }

    private fun getIdempotencyKey() : String {
        return "idmp_${System.currentTimeMillis()}"
    }
}

// Client code - Only knows about PaymentProcessor interface
class CheckoutService (private val paymentProcessor: PaymentProcessor) {
    fun checkout(amount: Double, country: String, cardDetails: CardDetails) {
        val response = paymentProcessor.processPayment(amount, country, cardDetails)
        if (response.success)
            println("Payment process done. Move to next step")
        else
            println("Payment process failed. Move to previous step")
    }
}

fun main() {
    val stipeClient = StripeClient()
    val paymentProcessor: PaymentProcessor = StripePaymentAdapter(stipeClient)
    val checkoutService = CheckoutService(paymentProcessor)

    checkoutService.checkout(
        9800.00,
        "in",
        CardDetails("1232134", 4, 2027, "342")
    )
}


class Network {
    fun getCurrentDateTime() : Long {
        return System.currentTimeMillis()
    }
}

data class HumanReadable(val dateTime: String)

class Adapter {
    val network = Network()

    private fun fetchEpochTime(): Long = network.getCurrentDateTime()

    fun fetchHumanReadableTime() : HumanReadable {
        val epochTime = fetchEpochTime()
        return HumanReadable("2025-05-22T")
    }

    fun fetchStringFormatTime() : String {
        val epochTime = fetchEpochTime()
        return "2025-05-22T"
    }

    // TODO: C-C, C-B, C-TB
}

class HomeScreen () {
    val adapter = Adapter()

    fun showDateTime(){
        println(adapter.fetchHumanReadableTime())
    }
}

class Navbar {
    val adapter = Adapter()

    fun showDateTime(){
        println(adapter.fetchHumanReadableTime())
    }
}

class LockScreen {
    val adapter = Adapter()

    fun showDateTime(){
        println(adapter.fetchHumanReadableTime())
    }
}
