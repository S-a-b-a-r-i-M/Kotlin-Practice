package intermediate

enum class Subject {
    TAMIL,
    ENGLISH,
    MATHEMATICS,
    SCIENCE,
    SOCIAL,
}

enum class StatusInt(var value: Int) {
    PENDING(1),
    COMPLETED(2),
    REJECTED(3); // <- Added a semicolon to separate constants from members

    companion object  {
        fun fromValue(givenValue: Int): StatusInt? = entries.find { it.value == givenValue }
    }
}

fun main() {
    var sub = Subject.ENGLISH

    // USING WHEN EXPRESSION
    when (sub) {
        Subject.TAMIL -> println("Tamil is selected")
        Subject.ENGLISH -> println("English is selected")
        Subject.MATHEMATICS -> println("Maths is selected")
        Subject.SCIENCE -> println("Science is selected")
        Subject.SOCIAL -> println("Social is selected")
    }

    println("-------------------------------------------------------------")
    println("valueOf : ${Subject.valueOf("ENGLISH")}\n")
    try {
        println("valueOf : ${Subject.valueOf("NOT AVAILABLE")}\n")
    } catch (exp: Exception) {
        println("'NOT AVAILABLE' is not present in Subject enum\n")
    }
    println("Entries : ${Subject.entries}")
    println("Entries of StatusInt : ${StatusInt.entries}")
    // Subject.entries.forEach { println(it) }
    println("name of Maths : ${Subject.MATHEMATICS.name}, ordinal: ${Subject.MATHEMATICS.ordinal}")
    println("-------------------------------------------------------------")

    // Access Name From Value
    println("Name of value 2 in StatusInt : ${StatusInt.fromValue(2)}")
    println("Name of value 12 in StatusInt : ${StatusInt.fromValue(12)}")
}