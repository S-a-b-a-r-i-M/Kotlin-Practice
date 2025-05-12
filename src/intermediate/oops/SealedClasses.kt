package intermediate.oops

import intermediate.ResourceNotFoundError

sealed class SealedResult<out T> {
    data class Success<T>(val data: T): SealedResult<T>()
    data class Error(val exp: Exception) : SealedResult<Nothing>()
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
