
// This basic.crackers.main function is the entry point of Kotlin.

// Cmd + E -> Recent files
// Cmd + Ctrl + G -> multi line

fun String.uppercase(): String {
    return ""
}

fun main() {
    val name = "Kotlin".uppercase()
    println("Hello, $name!")

    for (i in 1..5) {
        println("i = $i")
    }
}

//fun main(args: Array<String>){
//    print(args.contentToString())
//}