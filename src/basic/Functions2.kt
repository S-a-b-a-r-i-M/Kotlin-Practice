package basic

import kotlin.system.measureTimeMillis

fun main() {
    println("Here we are going to explore about Inline, crossline and noinline functions...")

    processUser("Sabari Murugan", "Sachin Tendulkar", "Rohit Sharma") { fName, lName ->
        //if (lName.startsWith("T")) return // Without inline you cannot add non-local return
        println("The first name is : $fName")
        println("The last name is : $lName")
    }

    println("\n================= With Filter Function =================")
    val complexFilter: (Int) -> Boolean = { x ->
        // Complex logic that JIT struggles with
        val result = x.toString().length > 2
        if (result) {
            x % 2 != 0
        } else {
            x % 2 == 0
        }
    }
    var timeTaken = measureTimeMillis {
        val onlyEven = (1..30_00_000).toList().myFilter(complexFilter)
        println("onlyEven: ${onlyEven.size}")
    }
    println("timeTaken for normal function: $timeTaken")

    timeTaken = measureTimeMillis {
        val onlyEven = (1..30_00_000).toList().filter(complexFilter)
        println("onlyEven: ${onlyEven.size}")
    }
    println("timeTaken for inline function: $timeTaken")
}

inline fun processUser(vararg fullNames: String, processName: (String, String) -> Unit) {
    for (name in fullNames) {
        val (fName, lName) = name.split(" ")
        processName(fName, lName)
        println("Process completed for $name\n")
    }
}

fun <T> List<T>.myFilter(predicate: (T) -> Boolean): List<T> {
    val result = ArrayList<T>()
    for (ele in this)
        if (predicate(ele))
            result.add(ele)

    return result
}