package intermediate

sealed class SealedResult<out T> {
    data class Success<T>(val data: T): SealedResult<T>()
    data class Error(val exp: Exception) : SealedResult<Nothing>()
    data class Authorized(private val authCode: String) : PaymentStatus() {
        fun isAuthorizationValid(): Boolean {
            return authCode.isNotEmpty() && System.currentTimeMillis() < expirationTime
        }

        private val expirationTime = System.currentTimeMillis() + 3600000 // 1 hour
    }
}

fun fetchUser(userId: Int) = when (userId) {
    1 -> SealedResult.Success("Arasu")
    2 -> SealedResult.Success("Sabari")
    else -> SealedResult.Error(ResourceNotFoundError("User Not Found"))
}

fun main() {
    // FETCH USER
    when(val user = fetchUser(1)){
        is SealedResult.Success -> println("Success")
        is SealedResult.Error -> println("Error")
    }
}
open class PaymentStatus {

}

