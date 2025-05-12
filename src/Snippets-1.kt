
// LEXICAL SCOPE PRIORITY
/*
  In Kotlin, when a function is called without a qualifier (like this. or a class name),
  the compiler looks for functions in the following order:
      1. Local functions in the current scope
      2. Extension functions in the current scope
      3. Member functions of the class
      4. Imported functions
 */
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