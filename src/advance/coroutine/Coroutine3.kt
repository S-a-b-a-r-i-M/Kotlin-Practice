package advance.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Simulating API calls with delays
suspend fun fetchUserProfile(userId: Int) : String {
    delay(1000) // Simulate network delay
    return "Profile for User $userId"
}

suspend fun fetchUserSettings(userId: Int): String {
    delay(800) // Simulate network delay
    return "Settings for User $userId"
}

suspend fun fetchUserPosts(userId: Int): List<String> {
    delay(1200) // Simulate network delay
    return listOf("Post 1 by User $userId", "Post 2 by User $userId")
}

// =========================== COROUTINE SCOPE EXAMPLE ===========================
suspend fun fetchUserWithCS(userId: Int): String {
    println("Starting fetchUserWithCS on thread: ${Thread.currentThread().name}")

    val result = coroutineScope {
        println("Inside coroutineScope on thread: ${Thread.currentThread().name}")

        // Parallel Execution
        val profileDeferred = async {
            println("Fetching profile on thread: ${Thread.currentThread().name}")
            fetchUserProfile(userId)
        }

        val settingsDeferred = async {
            println("Fetching settings on thread: ${Thread.currentThread().name}")
            fetchUserSettings(userId)
        }

        val postsDeferred = async {
            println("Fetching posts on thread: ${Thread.currentThread().name}")
            fetchUserPosts(userId)
        }

        val profile = profileDeferred.await()
        val settings = settingsDeferred.await()
        val posts = postsDeferred.await()

        "UserData: $profile, $settings, Posts: ${posts.joinToString()}"
    }

    println("🎯 Returning from coroutineScope on thread: ${Thread.currentThread().name}")
    return result
}

// =========================== RUN BLOCKING EXAMPLE ===========================
fun fetchUserWithRB(userId: Int): String {
    println("Starting fetchUserWithRB on thread: ${Thread.currentThread().name}")

    val result = runBlocking {
        println("Inside runBlocking on thread: ${Thread.currentThread().name}")

        // This BLOCKS the calling thread until completion
        val profileDeferred = async {
            println("Fetching profile on thread: ${Thread.currentThread().name}")
            fetchUserProfile(userId)
        }

        val settingsDeferred = async {
            println("Fetching settings on thread: ${Thread.currentThread().name}")
            fetchUserSettings(userId)
        }

        val postsDeferred = async {
            println("Fetching posts on thread: ${Thread.currentThread().name}")
            fetchUserPosts(userId)
        }

        val profile = profileDeferred.await()
        val settings = settingsDeferred.await()
        val posts = postsDeferred.await()

        "UserData: $profile, $settings, Posts: ${posts.joinToString()}"
    }

    println("Returning from runBlocking on thread: ${Thread.currentThread().name}")
    return result
}

// =========================== DEMONSTRATION

suspend fun demonstrateCS() {
    println("\n==================== COROUTINE SCOPE DEMO ====================")
    println("🎬 This will NOT block the calling thread")

    val time = measureTimeMillis {
        coroutineScope {
            // Multiple operations that can run concurrently
            val user1Data = async { fetchUserWithCS(1) }
            val user2Data = async { fetchUserWithCS(2) }

            println("⏳ Both operations started, doing other work...")
            println("💭 Current thread: ${Thread.currentThread().name}")

            // We could do other work here while waiting
            repeat(3) {
                delay(500)
                println("🔄 Doing other work while waiting... step ${it + 1}")
            }

            // Collect results
            println("\n📊 Results:")
            println("User 1: ${user1Data.await()}")
            println("User 2: ${user2Data.await()}")
        }
    }

    println("⏱️ Total time: ${time}ms")
}

fun demonstrateRB() {
    println("\n==================== RUN BLOCKING DEMO ====================")
    println("🔒 This WILL block the calling thread")

    val time = measureTimeMillis {
        // This blocks the thread completely
        val user1Data = fetchUserWithRB(1)
        println("📊 User 1 data: $user1Data")

        // This can only start after the first one completes
        val user2Data = fetchUserWithRB(2)
        println("📊 User 2 data: $user2Data")
    }

    println("⏱️ Total time: ${time}ms")
}

fun main() {
    runBlocking {
        println("🎯 COROUTINE SCOPE vs RUN BLOCKING DEMONSTRATION")
        println("Main thread: ${Thread.currentThread().name}")

        // Demo 1: Performance comparison
        demonstrateCS()

        // Demo 2: Blocking behavior
        demonstrateRB()
    }
}