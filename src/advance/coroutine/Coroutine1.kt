package advance.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        print("Murugan")
    }
    launch {
       delay(500)
        print(" ")
    }
    print("Sabari") // main coroutine continues while a previous one is delayed
}

// Example of Tag team match

suspend fun tagOut() {
    println("Tagout !")
    yield()
}

fun main(args: Array<String>) {
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