package intermediate
import kotlinx.coroutines.*

sealed class SealedResult<out T> {
    data class Success<T>(val data: T): SealedResult<T>()
    data class Error(val exp: Exception) : SealedResult<Nothing>()
}

object Pending : SealedResult<Unit>()

fun fetchUser(userId: Int): SealedResult<Any> {
    return when (userId) {
        1 -> SealedResult.Success("Arasu")
        2 -> SealedResult.Success("Sabari")
        else -> SealedResult.Error(ResourceNotFoundError("User Not Found"))
    }
}

fun main() {
    // FETCH USER
    when(val result = fetchUser((Math.random() * 4).toInt())){
        is SealedResult.Success -> println("Success ${result.data}")
        is SealedResult.Error -> println("Error ${result.exp}")
        is Pending -> println("Pending...")
    }
}


