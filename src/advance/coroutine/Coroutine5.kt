package advance.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val scope = CoroutineScope(Dispatchers.Default)

    val job = scope.launch {
        launch {
            delay(2000)
            println("Launcher-1")
        }

        launch {
            delay(1000)
            println("Launcher-2")
            // throw RuntimeException("\"Throwing exception from Launcher-2\"")
            // this will cancel the siblings and child coroutines as well [NOTE : Exception Upwardsi]
        }

        val child = launch {
            val grandChild1 = launch {
                println("Launcher of grandChild-1")
            }

            val grandChild2 = launch {
                delay(1000)
                println("Launcher of grandChild-2")
            }

            cancel() // this will cancel the grandChild2 [NOTE : Cancellation Downwards]
        }

        println("Parent scope isActive : $isActive ")
    }

    runBlocking {
        job.join()
    }

    println("Main Finished.")
}