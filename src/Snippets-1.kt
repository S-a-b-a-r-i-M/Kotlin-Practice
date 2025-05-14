
// 1. LEXICAL SCOPE PRIORITY
/*
  In Kotlin, when a function is called without a qualifier (like this. or a class name),
  the compiler looks for functions in the following order:
      1. Local functions in the current scope
      2. Extension functions in the current scope
      3. Member functions of the class
      4. Imported functions
 */
/*
fun main() {
    fun printLine() { println("Local function") }

    class A {
        fun printLine() { println("Member function") }
        fun invokePrintLine() {
            printLine()
        }
    }

    A().invokePrintLine()
}
*/

// 2. DE-DUPLICATING LIST
fun main() {
    val animals = listOf(
        "Lion",
        "Tiger",
        "BEAR",
        "Cheetah",
        "Lion",
        "LION",
        "BeAR",
        "Cheetah",
        "CHEEtah",
    )

    // Distinct (case-sensitive)
    var uniqueAnimals = animals.distinct()
    println("\nUnique Animals by using distinct method : $uniqueAnimals\n")

    // Distinct By
    uniqueAnimals = animals.distinctBy { it.lowercase() }
    println("Unique Animals by using distinct by method : $uniqueAnimals\n")

    // List -> Set
    val uniqueAnimalsSet = animals.toSet()
    println("Unique Animals by using toSet method : $uniqueAnimalsSet\n")
}