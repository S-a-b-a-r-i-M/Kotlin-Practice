package advance.coroutine

import kotlinx.coroutines.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.system.measureTimeMillis

object ApiClient {
    private val httpClient = HttpClient.newHttpClient()

    // Sync Api Call
    fun fetchUserSync(userId: Int): String {
        val req = HttpRequest
            .newBuilder(URI.create("https://jsonplaceholder.typicode.com/users/$userId"))
            .GET()
            .build()

        val response = httpClient.send(req, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }

    // Async Api Call
    suspend fun fetchUserASync(userId: Int): String = withContext(Dispatchers.IO) {
        val req = HttpRequest
            .newBuilder(URI.create("https://jsonplaceholder.typicode.com/users/$userId"))
            .GET()
            .build()

        val response = httpClient.send(req, HttpResponse.BodyHandlers.ofString())
        response.body()
    }
}

fun main() {
    val numberOfReq = 15
    val userIds = (1..numberOfReq).toList()
    println(userIds)

    // SYNCHRONOUS APPROACH - One after another
    println("\n1️⃣ SYNCHRONOUS APPROACH:")
    val syncTime = measureTimeMillis {
        val users = userIds.map { userId ->
            println("  → Fetching user $userId...")
            ApiClient.fetchUserSync(userId)
        }
        println(" Completed ${users.size} requests")
    }

    // ASYNCHRONOUS APPROACH - All at once
    println("\n2️⃣ ASYNCHRONOUS APPROACH:")
    val asyncTime = measureTimeMillis {
        runBlocking {
            val users = userIds.map { userId ->
                println("  → Sending request for user $userId...")
                async {
                    ApiClient.fetchUserASync(userId)
                }
            }.awaitAll()
            println(" Completed ${users.size} requests")
        }
    }

    println("\n" + "=" * 60)
    println("   RESULTS:")
    println("   Synchronous:      ${syncTime}ms")
    println("   Asynchronous:     ${asyncTime}ms")
    println("\n Speed Improvement:")
    println("   Async is ${String.format("%.1f", syncTime.toDouble() / asyncTime)}x faster!")
}

operator fun String.times(n: Int): String = this.repeat(n)