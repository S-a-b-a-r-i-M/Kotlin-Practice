package basic

// Note: All the arrays are fixed-size arrays in Kotlin. Once an array is created, its size cannot be changed.

fun creationOfArray(){
    // Creation
    /* To create arrays in Kotlin, we can use:
     * functions, such as arrayOf(), arrayOfNulls() or emptyArray()
     * or the Array constructor.
     */
    // 1. arrayOf(val1, val2, val3, ... )
    var colors: Array<String> = arrayOf("Red", "Blue", "Green")
    println("colors array using arrayOfNulls : ${colors.joinToString(" - ")}")

    println("Before adding new element $colors")
    // colors[3] = "Yellow" // ERROR: Index range out
    // Adding an element will create a new array, and it will assign in (behind the scene)
    colors += "Violet"
    println("After added new element $colors\n") // You can notice the memory changes

    var bigNums = arrayOf(1L, 2L, 3L)
    var bigNumsViaConstructor = Array<Long>(3) { 1L }
    println("bigNums : ${bigNums.joinToString(" - ")}")
    println("bigNumsViaConstructor : ${bigNumsViaConstructor.joinToString(" - ")}")

    // Mixed Type of Elements
    var mixedArrays: Array<Any> = arrayOf(2, "Skoda", true, 'A')
    println("Mixed type of elements in single array : ${mixedArrays.joinToString(limit = 2)}\n")

    // 2. arrayOfNulls
    var nullValues = arrayOfNulls<Int?>(5)
    println("nullValues array using arrayOfNulls : ${nullValues.joinToString()}\n")

    // 3. emptyArray
    var emptyValues: Array<Int> = emptyArray()
    println("emptyValues array using emptyArray : ${emptyValues.joinToString()}\n")

    // 4. Array Constructor
    var arrayCon = Array(3) {"A"}
    println("arrayCon array using Array Constructor : ${arrayCon.joinToString()}\n")

    var nums = Array(3) { i -> i * i }
    println("numbers array using Array Constructor : ${nums.joinToString()}\n")

    // For primitive types (specialized arrays)
    val numbers = IntArray(5)
//    val numbers = intArrayOf(1, 2, 3, 4, 5)
    val bytes = byteArrayOf(1, 2, 3)
    val shorts = shortArrayOf(1, 2, 3)
    val longs = longArrayOf(1L, 2L, 3L)
    val floats = floatArrayOf(1.0f, 2.0f, 3.0f)
    val doubles = doubleArrayOf(1.0, 2.0, 3.0)
    val booleans = booleanArrayOf(true, false, true)
    val chars = charArrayOf('a', 'b', 'c')

    // Using The Array Constructors Directly
    IntArray(1)

  // ITERATION
    // Using 'in'
    println("\nUsing in -> ")
    for (color in colors)
        println(color)

    println("\nUsing indices property")
    for (index in colors.indices)
        println("index: $index, value: ${colors[index]}")
}


fun modificationOfArray(){
    val colors = arrayOf("Blue", "Green", "Red", "Violet")
    val twoDArray = Array<Array<Int>>(2) { Array<Int>(2) { 0 } }
}

fun twoDimensional(){
    // Two Dimensional
    val products = Array(3) {
            i -> Array(3) {
            j -> i * j
        }
    }

    for(num in products)
        println(num.joinToString())

    // Three Dimensional
    val threeDimensional = Array<Array<Array<Int>>>(2) { Array(2) { Array(2) {0} } }
}


fun main() {
    creationOfArray()

//    modificationOfArray()

//    twoDimensional()
}
