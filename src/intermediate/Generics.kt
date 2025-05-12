package intermediate

// GENERIC CLASS
class ArrayUtils<T> (val array: Array<T>) {
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

    val arrayUtils = ArrayUtils<Int>(nums)
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
