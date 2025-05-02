package basic

fun creationOfArray(){
    // Creation
    /* To create arrays in Kotlin, we can use:
     * functions, such as arrayOf(), arrayOfNulls() or emptyArray()
     * the Array constructor.
     */
    // 1. arrayOf(val1, val2, val3, ... )
    var colors: Array<String> = arrayOf("Red", "Blue", "Green")
    println("colors array using arrayOfNulls : ${colors.joinToString(" - ")}")

    println("Before adding new element $colors")
    // Adding an element will create a new array, and it will assign in (behind the scene)
    colors += "Violet"
    println("After added new element $colors\n") // You can notice the memory changes

    // Mixed Type of Elements
    var mixedArrays: Array<Any> = arrayOf(2, "Skoda", true, 'A')
    println("Mixed type of elements in single array : ${mixedArrays.joinToString(limit = 2)}\n")

    // 2. arrayOfNulls
    var nullValues = arrayOfNulls<Int>(5)
    println("nullValues array using arrayOfNulls : ${nullValues.joinToString()}\n")

    // 3. emptyArray
    var emptyValues: Array<Int> = emptyArray()
    println("emptyValues array using emptyArray : ${emptyValues.joinToString()}\n")

    // 4. Array Constructor
    var arrayCon = Array(3) {"A"}
    println("arrayCon array using Array Constructor : ${arrayCon.joinToString()}\n")

    var numbers = Array(3) {i -> i * i}
    println("numbers array using Array Constructor : ${arrayCon.joinToString()}\n")
}


fun modificationOfArray(){
    val colors = arrayOf("Blue", "Green", "Red", "Violet")
    val twoDArray = Array<Array<Int>>(2) { Array<Int>(2) { 0 } }
}


fun main() {
//    creationOfArray()

    modificationOfArray()
}
