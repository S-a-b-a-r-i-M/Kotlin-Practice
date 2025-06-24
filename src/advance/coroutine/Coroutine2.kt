package advance.coroutine

import kotlinx.coroutines.*


fun main() {
    dispatchers()
}

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
fun dispatchers() {
    // DISPATCHERS
    runBlocking {
        val j1= launch { // context of the parent, main runBlocking coroutine
            println(" main runBlocking : I'm working in thread ${Thread.currentThread().name}")
        }
        val j2 = launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            println(" Unconfined       : I'm working in thread ${Thread.currentThread().name}")
        }
        val j3 = launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
            println(" Default          : I'm working in thread ${Thread.currentThread().name}")
        }
        val j4 =launch(newSingleThreadContext("Lion Thread")) { // will get its own new thread
            println("new ThreadContext : I'm working in thread ${Thread.currentThread().name}")
        }

        j1.join()
        j2.join()
        j3.join()
        j4.join()

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