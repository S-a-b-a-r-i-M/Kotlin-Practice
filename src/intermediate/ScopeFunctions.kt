@file:JvmName("ScopeFunctions")
package intermediate

fun getDBConnection() = if ((Math.random() * 10) < 9) DatabaseConnection(5432, "Main", "localhost") else null

data class DatabaseConnection(val port: Int, var dbName: String, var host: String, var schema: String = "public") {

    fun connect(){
        println("Connecting...")
        Thread.sleep(500)
        println("Connected with $dbName")
    }
}

fun letDemo() {
    val dbConnection: DatabaseConnection? = getDBConnection()
    println("Received connection : $dbConnection")

    dbConnection?.let { conn ->
        conn.host = "let"
    }

    println("After 'let', dbConnection: $dbConnection")

    // let will also return the lambda result
    val connectionString = dbConnection?.let {
        "${it.port}, ${it.host}, ${it.dbName}"
    }

    println("Connection string : $connectionString")

    listOf("Logan", "Ragavan", "Kalai").let(::println) // Passing the method ref, with single param (it)
}

fun withDemo() {
    // With can be read as " with this object, do the following. "
    val ages = listOf(13, 23, 45, 47)
    val sumOfOddAges = with(ages) {
        var sum = 0
        forEach { age -> if(age % 2 == 1) sum += age }
        sum
    }
    println("Sum of odd ages : $sumOfOddAges")
}

fun runDemo() {
    val portWithHost = DatabaseConnection(5432, "run", "scope").run {
        println("We can try to check the connection will happen or not")
        "$port - $host"
    }

    // run can be read as " run the code block and compute the result. "
    val fullName = run {
        println("Enter your First Name:")
        val firstName = readln()
        println("Enter your Father's Name:")
        val fatherName = readln()
        println("Enter your Sur Name:")
        val surName = readln()

        "${fatherName[0]}.$firstName $surName"
    }
    println("fullName: $fullName")
}


fun main() {
    println("---------------------------- LET ---------------------------")
    letDemo()

    println("--------------------------- WITH ---------------------------")
    withDemo()

    println("--------------------------- RUN ----------------------------")
    runDemo()

    println("--------------------------- ALSO ---------------------------")
    // you see also in code, you can read it as " and also do the following with the object. "
    val dbConnection = DatabaseConnection(5432, "also", "also").also { it.dbName = ""}
    println("connectionString2 modified by also : $dbConnection")

    println("-------------------------- APPLY --------------------------")
    // Common use case for apply is for object configuration.
    // Such calls can be read as " apply the following assignments to the object. "
    dbConnection.apply { schema = "userSchema" }
}