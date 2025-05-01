package basic

// Compile-time constants (must be initialized with a value known at compile time)
const val API_KEY = "abcd1234"        // Only allowed at top level or in objects
const val MAX_ATTEMPTS = 3

// TYPE CONVERSION
fun typeConversion(){
    // 1. Explicit number type conversion
    val intValue: Int = 100
    val longValue: Long = intValue.toLong()  // Convert Int to Long
    val doubleValue: Double = intValue.toDouble()  // Convert Int to Double

    // 2. String conversions
    val numericString = "42"
    val parsedInt = numericString.toInt()  // Parse String to Int
    val backToString = parsedInt.toString()  // Convert Int to String

    println("Conversions: $longValue, $doubleValue, $parsedInt")
}


fun main() {
    // PART 1: BASIC VARIABLE DECLARATION

    // 1. Using 'val' for immutable (read-only) variables
    val name = "John"        // Type inference determines this is a String
    val age: Int = 30        // Explicitly specifying the type
    // name = "Jane"         // ERROR: Val cannot be reassigned

    // 2. Using 'var' for mutable variables
    var score = 100          // Type inference: Int
    var isActive: Boolean = true  // Explicit type declaration
    score = 150              // Works fine - var can be reassigned
    // score = "High"        // ERROR: Type mismatch - cannot assign String to Int

    println("Name: $name, Age: $age, Score: $score, Active: $isActive")

    // PART 2: NUMERIC DATA TYPES

    // 1. Integer types (based on size)
    val byte: Byte = 127                  // 8-bit signed integer (-128 to 127)
    val short: Short = 32767              // 16-bit signed integer (-32768 to 32767)
    val int: Int = 2147483647             // 32-bit signed integer (default for whole numbers)
    val long: Long = 9223372036854775807L // 64-bit signed integer (note the L suffix)

    // 2. Floating-point types
    val float: Float = 3.14f              // 32-bit floating point (note the f suffix)
    val double: Double = 3.14159265359    // 64-bit floating point (default for decimals)

    // 3. Number literals with readability
    val million = 1_000_000               // Underscores for readability
    val hexadecimal = 0xFF_EC_DE_5E       // Hexadecimal notation
    val binary = 0b1010_1100              // Binary notation

    println("Byte: $byte, Short: $short, Million: $million")
    println("Hex: $hexadecimal, Binary: $binary")

    // PART 3: CHARACTER AND STRING TYPES

    // 1. Character type (single character)
    val letter: Char = 'A'                // Single quotes for characters
    val digit: Char = '7'

    // 2. String type (text)
    val greeting: String = "Hello"        // Double quotes for strings
    val message = "Welcome to Kotlin"     // Type inference for String

    // 3. String templates
    val username = "Alice"
    val welcomeMessage = "Welcome, $username!"  // Simple variable reference
    val calculation = "Sum: ${2 + 2}"     // Expression in template

    // 4. Multiline strings
    val multiline = """
        This is a multiline string.
        No escape characters needed.
        You can use "quotes" freely.
    """.trimIndent()

    println(welcomeMessage)
    println(calculation)
    println(multiline)

    // PART 4: BOOLEAN TYPE

    val isCompleted: Boolean = false
    val isAuthenticated = true            // Type inference

    // Boolean operators
    val result = isCompleted || isAuthenticated  // Logical OR
    val andResult = isCompleted && isAuthenticated  // Logical AND
    val notResult = !isAuthenticated      // Logical NOT

    println("OR result: $result, AND result: $andResult, NOT result: $notResult")

    // PART 5: NULLABLE TYPES

    // 1. Regular variables cannot be null
    var nonNullName: String = "John"
    // nonNullName = null  // ERROR: Null cannot be a value of non-null type String

    // 2. Nullable types with ? suffix
    val nullableName: String? = null      // Can hold String or null
    var nullableAge: Int? = 25
    nullableAge = null                    // This is allowed

    // 3. Safe call operator (?.)
    val length = nullableName?.length     // Returns null if nullableName is null

    // 4. Elvis operator (?:)
    val nameLength = nullableName?.length ?: 0  // Use 0 if nullableName is null

    // 5. Not-null assertion (!!)
    // Use with caution - will throw NullPointerException if value is null
    // val forcedLength = nullableName!!.length  // Would throw NPE if nullableName is null

    println("Nullable name length: $length, With Elvis: $nameLength")

    // PART 6: CONSTANTS
    println("API Key: $API_KEY, Max Attempts: $MAX_ATTEMPTS")

    // PART 7: SCOPE AND VISIBILITY
    scopeDemo()
}

// Variables with different visibility modifiers
private val privateVar = "Private to this file"
public val publicVar = "Accessible from anywhere"  // public is the default
internal val internalVar = "Visible within the same module"

// Function to demonstrate variable scope
fun scopeDemo() {
    val functionScopedVar = "Only visible in this function"

    // Local function with its own scope
    fun nestedFunction() {
        val nestedVar = "Only visible in nested function"
        println("Accessing from nested function: $functionScopedVar, $nestedVar")
    }

    nestedFunction()
    println("In function: $functionScopedVar")
    // println(nestedVar)  // ERROR: Not accessible here
}

// PART 8: TYPE ALIASES
typealias UserMap = Map<String, InterOperable>  // Creating type alias for complex types
typealias Matrix = Array<Array<Int>>   // Creating type alias for nested arrays

// Usage of the typealiases would be:
fun processUsers(users: UserMap) {
    // Function that works with a map of users
}

fun createMatrix(): Matrix {
    return Array(3) { Array(3) { 0 } }  // 3x3 matrix of zeros
}

