package intermediate

fun interface Greeter {
    fun greet(name: String): String
    fun greet2(name: String): Unit {
        // The functional interface can have several non-abstract member functions
        // but only one abstract member function.
    }
}

fun main() {
    // Traditional implementation
    val traditionalGreet = object : Greeter {
        override fun greet(name: String): String = "Welcome! $name"
    }

    // SAM conversion using lambda
    val modernGreet = Greeter { name: String -> "Hey $name"}

    println(traditionalGreet.greet("Sabari"))
    println(modernGreet.greet("Nithika"))
}