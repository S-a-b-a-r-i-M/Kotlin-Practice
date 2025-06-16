package intermediate

// Custom Exception

class AgeEligibilityException (message: String) : Exception(message)

class ResourceNotFoundError (message: String) : Exception(message)

fun canIVote(age: Int){
    require(age > 0)

    if (age <= 18) throw AgeEligibilityException("18 years is the eligible criteria for voting...")

    println("You are eligible to vote")
}

fun main() {
  // TRY-CATCH-FINALLY
    var age: Int = 0
    try {
        println("Enter your age")
        age = readln().toInt()
    } catch (exp: NumberFormatException) {
        println("Given age is not valid")
        println(exp.message)
    } catch (exp: IllegalArgumentException) {
        println("Given age is not valid")
        println(exp.message)
    } finally {
        println("Age : $age")
    }

  // AS EXPRESSION
  /*
    val salary: Float = try {
        readln().toFloat()
    } catch (exp: NumberFormatException) {
        println("Input salary is not valid, exp:${exp}")
        0.0f
    }

    println("Salary $salary")
     */
    val amIEligible = try {
        canIVote(age) // Returns data if successful
    } catch (exp: Exception) {
        println(exp)
        return // Exits the entire function
    }

    println("Am i eligible : $amIEligible")

}