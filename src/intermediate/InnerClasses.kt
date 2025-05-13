package intermediate

class Outer {
    private val outerValue = 10

    class NestedClass {
        // Cannot access outerValue directly
        fun printValue() {
            // This would cause a compilation error:
            // println(outerValue)

            println("Nested class cannot access outer class members")
        }
    }

    inner class InnerClass {
        // Can access outerValue directly
        fun printValue() {
            println("Inner class can access outer value: $outerValue")
        }
    }
}

fun main() {
    // Creating nested class instance (does not need Outer instance)
    val nested = Outer.NestedClass()
    nested.printValue()

    // Creating inner class instance (requires Outer instance)
    val outer = Outer()
    val inner = outer.InnerClass()
    val inner2 = outer.InnerClass()
    inner.printValue()
}