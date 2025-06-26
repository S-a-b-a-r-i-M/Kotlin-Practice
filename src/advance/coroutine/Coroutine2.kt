package advance.coroutine

import kotlinx.coroutines.*


fun main() {
//    dispatchers()
    runBlocking {
        launch {
            delay(1000)
            println("World")
        }
    }
    println("Hello")

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