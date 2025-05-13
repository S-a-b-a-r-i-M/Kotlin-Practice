package intermediate

/* Requirements For Data Class,
 * 1. Data class must have at least one primary constructor parameter.
 * 2. Primary constructor of data class must only have property ('val' / 'var') parameters.
 * 3. Data classes can't be abstract, open, sealed, or inner.
*/

open class SuperUser(val id: Int) // We can inherit this class to data class

data class UserData(val userName: String, val age: Int){
    val email: String = "" // This won't reflect in toString().

    constructor(userName: String, age: Int, email: String): this(userName, age){
        println("Secondary constructor of ${this.javaClass}")
    }
}

enum class Status {
    INCOMPLETE,
    COMPLETE
}

data class Result(val result: Int, val status: Status)
fun function(): Result {
    // computations

    return Result(100, Status.COMPLETE)
}

class User(val userName: String, val age: Int)

fun main() {
    // Creating Objects
    val user = User("Muthu", 21)
    val userData = UserData("Sabari", 23, "")

    // Print as string
    println("\n-------------------------- Print as string ----------------------")
    println("user $user")
    println("userData $userData")

    // Compare instances
    val user2 = User("Muthu", 21)
    val userData2 = UserData("Sabari", 23)
    println("\n-------------------------- Compare instances ----------------------")
    println("user1 == user2 : ${user == user2}")
    println("userData1 == userData2 : ${userData == userData2}")

    // Copy instance
    val userData3 = userData.copy()
    println("\n-------------------------- Copy instance ----------------------")
    println("userData3 : $userData3")


    // Destructuring
    println("\n-------------------------- Destructuring ----------------------")
    val (name, age) = userData // Destructuring happening by positional
    println("userName: $name, age: $age")
//    val (ageOfUser) = user.component() // IN NORMAL CLASS IT WON'T WORK
    val ageFromFunction = userData.component2()
    println("age from Component function age : $ageFromFunction")

    // returning two values from a function
    val (result, status) = function()
}