package intermediate

fun iterate2DMatrix(matrix: Array<Array<Int>>) {
    println("------- Return -------")
    matrix.forEach outer@ { row ->
        for (col in row) {
            // If a column contains an even number skip the entire row
//             if (col % 2 == 0) continue *WRONG*
            if (col % 2 == 0 && col % 3 == 0) {
                println()
                return@outer
            }
            print("$col, ")
        }
        println()
    }

    println("------- Break --------")
    outerfor@
    for (row in matrix) {
        for (col in row) {
            // If a column contains an even number skip the entire row
//             if (col % 2 == 0) continue *WRONG*
            if (col % 2 == 0 && col % 3 == 0) {
                println()
                break@outerfor
            }
            print("$col, ")
        }
        println()
    }
}

fun main() {
    val matrix = arrayOf(arrayOf(1, 3), arrayOf(3, 4), arrayOf(5, 6, 8), arrayOf(7, 7, 12))
    iterate2DMatrix(matrix)

    println("------- Return Only Works On Fun -------")
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print("done with explicit label")
}