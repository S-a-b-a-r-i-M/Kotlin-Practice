package intermediate.oops

fun interface Greeter {
    fun greet(name: String): String
}

fun main() {
    // Traditional implementation
    val traditionalGreet = object : Greeter {
        override fun greet(name: String): String = "Welcome! $name"
    }

    // SAM conversion using lambda
//    val modernGreet: Greeter = { name: String -> "Hey $name"}


    println(traditionalGreet.greet("Sabari"))
//    println(modernGreet.greet("Nithika"))
}