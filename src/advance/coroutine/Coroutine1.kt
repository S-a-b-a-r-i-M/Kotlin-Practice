package advance.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/*
fun main() {
    runBlocking { // this: CoroutineScope
        println("this : $this")
        val job = launch { // launch a new coroutine and continue
            delay(1000) // non-blocking delay for 1 second (default time unit is ms)
            println("Murugan")
        }
        launch {
            delay(500)
            print(" ")
        }
//        job.cancel()
        println("Sabari") // main coroutine continues while a previous one is delayed
        println("job $job")
        job.join() // Waits for the coroutine to complete
        println("after join job: $job")
    }
    println("\nThis Out of the runBlock prints at last. Because runBlock blocked the main thread")
}
 */

// CREATING 100,000 CO-ROUTINES
/*
suspend fun main() = coroutineScope {
    val time = measureTimeMillis {
        var oldCount = 0 // 7_00_00_000 Will Result in OutOfMemory Error
        val jobs = List(1_00_00_000) { count ->
            launch {
                delay(1000)
                print("${count}   ")
//                oldCount = count
            }
        }
        jobs.forEach { it.join() }
    }
    println("\nTime taken to execute 1Lakh coroutines : $time ms")
}
*/

// CREATING THREADS
/*
fun main() {
    val time = measureTimeMillis {
        val threads = List(4100) { count ->
            Thread {
                Thread.sleep(1000)
                print("$count   ")
            }
        }

        threads.forEach { it.start() }
        threads.forEach { it.join() }
    }
    println("\nTime taken to execute 1000 coroutines : $time ms")
}
*/


// Example of Tag team match
/*
suspend fun tagOut() {
    println("Tagout !")
    yield()
}

fun tagMatch() {
    runBlocking {
        launch {
            println("Brock: Suplexcity 🫂")
            println("Brock: F5 💥")
            tagOut()
            println("Brock: Suplexcity 🫂")
            println("Brock: Punch ")
            tagOut()
            println("Brock: pinning...1..2..3")
            println("Undertaker - Brock, Won the Match 🏆🏆🏆")
        }
        launch {
            println("Undertaker: Big foot 🦶")
            tagOut()
            println("Undertaker: Ded Smack ☠️")
            tagOut()
        }
    }
}

fun main() {
    tagMatch()
}
*/

// Example of building a house
enum class Product(val description: String, val delayTime: Long) {
    DOORS("doors", 2000),
    WINDOWS("windows", 1750)
}

// Without coroutine
/*
fun orderProduct(orderItem: String): Product {
    val product = when (orderItem) {
        Product.WINDOWS.description -> Product.WINDOWS
        Product.DOORS.description -> Product.DOORS
        else -> error("Product($orderItem) not exist ")
    }
    println("ORDER RECEIVED: Your ${product.description} is on the way")
    Thread.sleep(product.delayTime)
    println("ORDER DELIVERED: Your ${product.description} is delivered")
    return product
}

fun work(product: Product) {
    println("WORK STARTED: installing ${product.description}")
    Thread.sleep(1000)
    println("WORK COMPLETED: installed ${product.description}")
}

fun main() {
    val start = System.currentTimeMillis()

    val windows = orderProduct("windows")
    val doors = orderProduct("doors")
    println("Laying bricks...")
    work(windows)
    work(doors)

    val end = System.currentTimeMillis()
    println("Total time taken to complete the work : ${(end - start) / 1000.0} seconds")
}
*/

// With coroutine

suspend fun orderProduct(orderItem: String): Product {
    val product = when (orderItem) {
        Product.WINDOWS.description -> Product.WINDOWS
        Product.DOORS.description -> Product.DOORS
        else -> error("Product($orderItem) not exist ")
    }
    println("ORDER RECEIVED  -> Your ${product.description} is on the way")
    delay(product.delayTime)
    println("ORDER DELIVERED -> Your ${product.description} is delivered")
    return product
}

suspend fun work(item: String) {
    println("WORK STARTED   -> installing $item")
    delay(1000)
    println("WORK COMPLETED -> installed $item")
}

fun main() {
    val start = System.currentTimeMillis()

    // CONCURRENCY
    /*
    runBlocking {
        val windows = async { orderProduct("windows") }
        val doors = async { orderProduct("doors") }
        launch {
            println("Laying bricks...")
            work(windows.await().description)
            work(doors.await().description)
        }
    }
    */

    // PARALLELISM

    runBlocking {
        val windows = async(Dispatchers.IO) { orderProduct("windows") }
        val doors = async(Dispatchers.IO) { orderProduct("doors") }
        launch(Dispatchers.Default) {
            println("Laying bricks...")
            launch{ work(windows.await().description) }
            launch{ work(doors.await().description) }
        }
    }

    val end = System.currentTimeMillis()
    println("Total time taken to complete the work : ${(end - start) / 1000.0} seconds")
}
