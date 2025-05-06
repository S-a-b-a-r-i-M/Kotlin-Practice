package basic

fun iterateUsingFor() {
    println("Iterating String ------------------> ")
    val userName = "Sabari"
    for (ch in userName)
        print("$ch, ")

    // Using Range
    println("\n\nWorking with Ranges ------------------> ")
    var nums = 1..7
    println("Nums from 1 to 7 : $nums, Count of numbers: ${nums.count()}, All numbers ${nums.joinToString()}")
    println("\nAll numbers using for-each")
    nums.forEach{ num -> println(num) }

    println("\nstart and end includes : ")
    for (i in 1..6) print("$i, ")

    println("\nstart includes and end excludes : ")
    for (i in 1..<6) print("$i, ")

    println("\ns&e includes. Step incrementing by 2 : ")
    for (i in 1 until 6 step 2) print("$i, ") // Note: Step can't be negative

    println("\nprinting in reverse order : ")
    for (i in 6 downTo 1) print("$i, ")

    println("\ns&e includes. Step decrementing by2 : ")
    for (i in 6.downTo(0) step 2) print("$i, ")

    // Iterating Over Array
    println("\n\nIterating Over Array ------------------> ")
    val osList = arrayOf("windows", "macOs", "linux", "funtouch")
    for (os in osList) print("$os, ")
}

fun iterateUsingWhile(){
    // Syntax wise no changes
    // While - Entry check
    var x = readln().toInt()
    var reverseOfX: Int = 0
    while(x > 0){
        val reminder = x % 10
        reverseOfX = (reverseOfX * 10) + reminder
        x /= 10
    }
    println("Reverse of $x is $reverseOfX")

    // Do-While - Exit check
    do {
        println("Welcome to do while")
    } while (false)
}

fun usageOfJumpingStatements() {
    for (i in 1..100) {
        if (i / 4 > 4) break
        print("$i, ")
    }

    println()
    // Using Label
    outerLoop@ for (i in 1..3)
        for (j in 1..3) {
            if (j == 3) break@outerLoop
            println("i: $i, j:$j")
        }

    println()
    outerLoop@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) continue@outerLoop// Skip to next iteration of outer loop
            println("i = $i, j = $j")
        }
    }
}

fun main() {
    iterateUsingFor()

//    iterateUsingWhile()

//    usageOfJumpingStatements()
}