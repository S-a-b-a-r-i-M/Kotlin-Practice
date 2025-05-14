package intermediate

typealias Signature<T> = (T) -> Boolean

private fun task(param: Signature<Int>): Boolean{
    return param(40)
}

fun main() {
    fun isPositiveFun(num: Int): Boolean = num > 0
    val isPositiveVariable: (Int) -> Boolean = { it > 0 }

    println(task(isPositiveVariable))
    println(task { num: Int -> num < 0 })
    println(task { it < 0 })
}