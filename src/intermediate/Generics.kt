package intermediate

// GENERIC CLASS
class ArrayUtils<T: Number> (val array: Array<T>) { // Number is the 'Upper Bound'
    fun findElement(target: T, callBack: (index: Int, element: T?) -> Unit) {
        for (i in array.indices)
            if (array[i] == target) {
                callBack(i, array[i])
                return
            }

        return callBack(-1, null)
    }
}

// GENERIC FUNCTION
fun <T> findElement(array: Array<T>, target: T, callBack: (index: Int, element: T?) -> Unit) {
    for (i in array.indices)
        if (array[i] == target) {
            callBack(i, array[i])
            return
        }

    return callBack(-1, null)
}

fun main() {
    val nums = arrayOf(101, 102, 103, 104)
    val names = arrayOf("Sabari", "Ram", "George")

//    val arrayUtils = ArrayUtils(names) // ERROR: String is Not a subtype of Number.
    val arrayUtils = ArrayUtils(nums) // the parameters can be inferred, for example, from the constructor arguments
    arrayUtils.findElement(104) {
        index, element ->
            if (index != -1)
                println("Num Found!!! Index $index")
            else
                println("Num Not Found...")
    }

    findElement(names, "Ram") {
        index, element ->
            if (index != -1)
                println("Name Found!!! Index $index")
            else
                println("Name Not Found...")
    }
}
