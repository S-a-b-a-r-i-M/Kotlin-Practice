@file:JvmName("ScopeFunctions")
package intermediate

fun getDBConnection() = if ((Math.random() * 10) < 9) DatabaseConnection(5432, "Main", "localhost") else null

data class DatabaseConnection(val port: Int, var name: String, var host: String)

fun letDemo() {

}

fun main() {
    println("--------------------------- LET ---------------------------")
    var dbConnection: DatabaseConnection? = getDBConnection()
    println("Received connection : $dbConnection")

    dbConnection?.let { conn ->
        dbConnection = getDBConnection()
        conn.host = "let"
    }

    println("After let the dbConnection: $dbConnection")

    // let will also return the lambda result
    val connectionString = dbConnection?.let {
        "${it.port}, ${it.host}, ${it.name}"
    }

    println("Connection string : $connectionString")

    println("--------------------------- ALSO ---------------------------")
    // also will return Context object
    val dbConnection2 = DatabaseConnection(5432, "also", "also").also { it.name = ""}
    println("connectionString2 modified by also : $dbConnection2")

    println("--------------------------- RUN ---------------------------")
    val portWithHost = dbConnection?.run { "${this.port} - ${this.host}"}
    println("portWithHost: $portWithHost")
}