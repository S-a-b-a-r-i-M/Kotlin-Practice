package advance

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.future.await
import kotlinx.coroutines.runBlocking
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.concurrent.CompletableFuture

class UserRepository(private val httpClient: HttpClient) {

    private val request = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/users/1"))
        .GET()
        .build()

    suspend fun getUserSuspending() : Result<Any> { // Only Return One Value
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return try {
            Result.success(response.body().length)
        } catch (e: Exception) {
            currentCoroutineContext().ensureActive()

            Result.failure(e)
        }
    }

    fun getUserFlow() : Flow<Result<Any>> { // It can Return multiple values over the period
        return flow {
            val responseJobs = mutableListOf<CompletableFuture<HttpResponse<String>>>()
            repeat(10) {
                val job = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                responseJobs.add(job)
            }

            try {
                responseJobs.forEach {
                    val res = it.await()
                    emit(Result.success(res.body().length))
                }
            } catch (e: Exception) {
                currentCoroutineContext().ensureActive()

                emit(Result.failure(e))
            }
        }
    }
}


fun main() {

    val repo = UserRepository(HttpClient.newHttpClient())
    runBlocking {
        var start = System.currentTimeMillis()
        repeat(10) {
            println(repo.getUserSuspending())
        }
        println("Suspend Processing took ${System.currentTimeMillis() - start} ms")

        println("---------------------------------------------------------------")

        start = System.currentTimeMillis()
        repo.getUserFlow().collect {
            println(it)
        }
        println("Flow Processing took ${System.currentTimeMillis() - start} ms")
    }
}