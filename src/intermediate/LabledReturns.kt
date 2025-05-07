package intermediate

fun iterate2DMatrix(matrix: Array<Array<Int>>) {
    matrix.forEach outer@ { row ->
        for (col in row) {
            // If a column contains an even number skip the entire row
            // if (col % 2 == 0) continue *WRONG*
            if (col % 2 == 0) {
                println()
                return@outer
            }
            print("$col ")
        }
        println()
    }
}

fun main() {
    val matrix = arrayOf(arrayOf(1, 3), arrayOf(3, 4), arrayOf(6, 5), arrayOf(7, 7))
    iterate2DMatrix(matrix)
}