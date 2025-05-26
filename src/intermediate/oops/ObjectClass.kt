package intermediate.oops

object Settings {
    val DB_PORT = 5432;
    val DB_PASSWORD = 123456;
    val DB_NAME = "Settings"

    // Other Configs

    fun getDBurl(): String {
        return "$DB_NAME $DB_PORT $DB_PASSWORD"
    }
}

fun main() {
    val mySettings = Settings
    println(mySettings.getDBurl())
}