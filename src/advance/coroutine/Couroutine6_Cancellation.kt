package advance.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // Regular Job : 1 child cancels -> parent cancels -> all child cancels
        println("------------------ Regular Job ------------------")
        val scope = CoroutineScope(Dispatchers.Default + Job())
        runningJobs(scope)

        // SuperVisor Job : 1 child cancels -> nothing affected
        println("----------------- Supervisor Job ------------------")
        val svScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
        runningJobs(svScope)
    }
}

suspend fun runningJobs(scope: CoroutineScope) {
    val job1 = scope.launch {  // Child 1
        delay(1000)
        println("Child 1 done ✅")
    }

    val job2 = scope.launch {  // Child 2 — throws exception
        delay(500)
        throw RuntimeException("Child 2 failed! 💥")
    }

    val job3 = scope.launch {  // Child 3
        delay(2000)
        println("Child 3 done ✅")
    }

    job1.join()
    job2.join()
    job3.join()
}