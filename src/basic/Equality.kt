package basic

fun structural() {
    // Compares the content/value
    val num1 = 10
    println("Enter num2: ")
    val num2 = readln().toInt()

    println("num1 == num2 : ${num1 == num2}")

    val nums1 = listOf<Int>(1, 2, 3)
    val nums2 = nums1
    val nums3 = listOf<Int>(1, 2, 3)

    println("nums1 == nums2 : ${nums1 == nums2}")
    println("nums1 == nums3 : ${nums1 == nums3}")

    val age: Int? = 10
    println("num1 == age: ${num1 == age}")
}

fun referential() {
    // Compares the address
    val nums1 = listOf<Int>(1, 2, 3)
    val nums2 = nums1
    val nums3 = listOf<Int>(1, 2, 3)

    println("nums1 === nums2 : ${nums1 === nums2}") // true
    println("nums1 === nums3 : ${nums1 === nums3}") // false

    val num1 = 10
    val num2 = 10
    var num3: Int? = 10
    num3 = null
    println("num1 == num2: ${num1 === num2}") // true
    println("num1 == num3: ${num1 === num3}") // false
}

fun arrays() {
    val nums1 = arrayOf<Int>(1, 2, 3)
    val nums2 = nums1
    val nums3 = arrayOf<Int>(1, 2, 3)

    println("nums1 == nums2 : ${nums1 == nums2}") // true
    println("nums1 === nums2 : ${nums1 === nums2}") // true
    println("nums1 == nums3 : ${nums1 == nums3}") // false, because == will check reference in arrays
    println("nums1 === nums3 : ${nums1 === nums3}") // false, reference check
    println("nums1.contentEquals(nums3) : ${nums1.contentEquals(nums3)}")
}

fun main() {
    println("------------------ Structural ---------------------")
    structural()

    println("\n------------------ Referential ---------------------")
    referential()

    println("\n------------------ Arrays ---------------------")
    arrays()
}