package intermediate


fun main() {
    // Syntax: val lambda = { param1: Type1, param2: Type2 -> body_of_function }

    // 1. Simple Lambda
    val areaOfCircle: (Double) -> Double = { r: Double -> 3.14 * r * r }
    println("Area of the circle(r=4.2): ${areaOfCircle(4.2)}")

    // 2. Lambda with No Parameters
    val greet = { println("Hello User!") }
    greet()

    // 3. Lambda as Function Parameter & with Implicit Parameter
    val nums = listOf(1, 2, 3, 4, 5)

      // Filter fun with lambda
    val evens = nums.filter { num -> num % 2 == 0 } // Without implicit param
    val odds = nums.filter { it % 2 != 0 } // With implicit param

    println("Odds are $odds and Evens are $evens")

    // 4. Multi-line Lambda Function
    val grade: (Int) -> String = { internalMark: Int ->
        println("Enter your external mark")
        val totalMark: Int = readln().toInt() + internalMark
        when {
            totalMark > 90 -> "A"
            totalMark > 70 -> "B"
            totalMark > 40 -> "C"
            else -> "F"
        }
    }

    println("The grade of student with 60 ex, 25 in : ${grade(25)}")

    // 5. Returning from Lambda Functions
    val findFirstEven = { numbers: List<Int> ->
        numbers.forEach {
            if (it % 2 == 0) return@forEach  // Local return
            println("Processing $it")
        }
    }

    findFirstEven(listOf(1, 3, 4, 5, 6))

    // 6. Higher-Order Functions with Lambdas
    fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    val result1 = operateOnNumbers(5, 3) { x, y -> x + y }  // Addition
    val result2 = operateOnNumbers(5, 3) { x, y -> x * y }  // Multiplication

    println("Addition result: $result1")  // Output: Addition result: 8
    println("Multiplication result: $result2")  // Output: Multiplication result: 15
}