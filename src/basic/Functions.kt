@file:JvmName("Functions") // We can set the name of .class
package basic

import kotlin.math.abs
import kotlin.math.pow


// Unit return type, No return value.
fun greet(name: String): Unit { // Adding Unit is optional
    println("Welcome $name")
}


//A function with two Int parameters and Int return type:
//fun sum(x: Int, y: Int): Int {
//    return x + y
//}

// Generic Fun
fun <T1, T2> genericFun(x: T1, y: T2) {
    println("x -> $x, y -> $y")
}


//A function body can be an expression. Its return type is inferred:
fun sub(x: Int, y: Int) = abs(x - y)


// Default Args
@JvmOverloads
// While Calling From Java, It Expects Us To Provide The Default Value also.
// Hence, This Annotation Creates
fun sum(x: Int, y: Int, z: Int = 0): Int { // Overloading Is Possible
    return x + y + z
}

fun powerOf(number: Double, exponent: Int = 2) = number.pow(exponent)


// Named argument
fun addStudent(
    studentId: Int,
    name: String,
    isPresent: Boolean = true,
    dob: String,
    parentName: String,
    parentContact: String? = null
) {
    println("Student $name added successfully !!!")
}


fun main() {
    greet("sabari")

//  var a, b --> Not Valid
//  Reason: In Kotlin, you must specify each variable separately with var or val.
//          Kotlin does not allow multiple variable declarations in a single line with a shared var.

    // Variables declared without initialization
    var b: Int
    var a: Int

    println("Enter two inputs for addition")
    a = readln().toInt()
    b = readln().toInt()

    val sum = sum(a, b)
    println("Sum of $a, $b is : ${sum(a, b)}") // Calling Fun

    println("Enter two inputs for subtraction")
    a = readln().toInt()
    b = readln().toInt()

    println("Sub of $a, $b is : ${sub(a, b)}")

//     Calling Default Argument Function
    println("Power of number 2 with exp 4 : ${powerOf(2.0, 4)}")
    println("Power of number 2 without exp : ${powerOf(2.0)}")

    addStudent(1, "Sabari", dob="05/02/2002", parentName = "Murugan")
}