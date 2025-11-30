import intermediate.Vehicle

// This basic.crackers.main function is the entry point of Kotlin.

// Cmd + E -> Recent files
// Cmd + Ctrl + G -> multi line

fun main() {
    val RESET = "\u001B[0m"
    val RED = "\u001B[31m"
    val GREEN = "\u001B[32m"
    val YELLOW = "\u001B[33m"
    val BLUE = "\u001B[34m"
    val CYAN = "\u001B[36m"
    println("${GREEN}Hello! $RESET")

    // Cores Count
    println("Number of cores : ${Runtime.getRuntime().availableProcessors()}")

    // References (Kotlin Reflection)
    println("${Vehicle::class} \n${Vehicle()::class} \n${Vehicle::class.java}")

    println("180" as? Int)
}

//fun main(args: Array<String>){
//    print(args.contentToString())
//}