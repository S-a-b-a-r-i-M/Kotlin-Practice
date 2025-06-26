package advance.coroutine

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main() {
//    dispatchers()

//    dispatchersThreadLimit()

    runBlockVsCoroutineScope()
    println("Welcome 🙏")
}

suspend fun runBlockVsCoroutineScope() {
    runBlocking {
        launch {
            delay(200)
            println("Inside run blocking...i'll block the calling thread")
            delay(100)
        }
    }
    println("Welcome runBlocking 🙏")
}

suspend fun dispatchersThreadLimit() {
    println("\n------------------------- Dispatchers.Default -------------------------")
    coroutineScope {
        // Dispatchers.Default Using all the cores (each core with 1 thread)
        repeat(200) {
            launch {
                List(1_000) { Random.nextBytes(5) } // Giving some work
                println("Running on thread: ${Thread.currentThread().name}")
            }
        }
    }

    println("\n------------------------- Dispatchers.IO -------------------------")
    // The 64-thread limit for Dispatchers.IO is a soft limit, not a hard ceiling.
    coroutineScope {
        // Dispatchers.Default Using all the cores (each core with 1 thread)
        repeat(2000) {
            launch (Dispatchers.IO) {
                List(1_00_000) { Random.nextBytes(5) } // Giving some work
                if (Thread.currentThread().name.contains("DefaultDispatcher-worker-7"))
                    println("Running on thread: ${Thread.currentThread().name}")
            }
        }
    }

    println("\n------------------------- Dispatchers.Unconfined -------------------------")
    coroutineScope {
        // Dispatchers.Default Using all the cores (each core with 1 thread)
        repeat(100) {
            launch (Dispatchers.Unconfined) {
                List(1_000) { Random.nextBytes(5) } // Giving some work
                println("Running on thread: ${Thread.currentThread().name}")
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
fun dispatchers() {
    // DISPATCHERS
    runBlocking {
        launch { // context of the parent, main runBlocking coroutine
            println(" main runBlocking : I'm working in thread ${Thread.currentThread().name}")
        }.join()
        launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            println(" Unconfined       : I'm working in thread ${Thread.currentThread().name}")
        }.join()
        launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
            println(" Default          : I'm working in thread ${Thread.currentThread().name}")
        }.join()
        launch(Dispatchers.IO) { // will get dispatched to DefaultDispatcher
            println(" IO               : I'm working in thread ${Thread.currentThread().name}")
        }.join()
        launch(newSingleThreadContext("Lion Thread")) { // will get its own new thread
            println("New ThreadContext : I'm working in thread ${Thread.currentThread().name}")
        }.join()

        println("------- --------- ------- ---------- ----------- ---------- -----------")

        launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
            delay(500)
            println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
        }
        launch { // context of the parent, main runBlocking coroutine
            println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
            delay(1000)
            println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
        }
    }
}