package intermediate

sealed class PaymentMethod

data class UpiPayment(val upiId: String) : PaymentMethod()

data class BankTransfer(val accountNo: String) : PaymentMethod()

data class CreditCardPayment(
    val cardNo: String,
    val expiryMonth: Int,
    val expiryYear: Int
) : PaymentMethod()

fun processUpiPayment(amount: Double, upiId: String) {
    println("processUpiPayment")
}

fun processBankTransfer(amount: Double, accountNo: String) {
    println("processBankTransfer")
}

fun processCreditCardPayment(amount: Double, cardNo: String, expiryMonth: Int, expiryYear: Int) {
    println("processCreditCardPayment")
}

fun paymentProcessor(amount: Double, paymentMethod: PaymentMethod){
    when (paymentMethod) {
        is UpiPayment -> processUpiPayment(amount, paymentMethod.upiId)
        is BankTransfer -> processBankTransfer(amount, paymentMethod.accountNo)
        is CreditCardPayment -> processCreditCardPayment(
            amount,
            paymentMethod.cardNo,
            paymentMethod.expiryMonth,
            paymentMethod.expiryYear
        )
    }
}

fun main() {
    paymentProcessor(23458.09, UpiPayment("sabari@pthdfc"))
}