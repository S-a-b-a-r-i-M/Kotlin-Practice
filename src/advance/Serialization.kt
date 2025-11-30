package advance

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class User (
    val fName: String,
    val lName: String,
    val email: String,
    val age: Int,
)

fun main() {
    val user1 = User(
        "Sabari",
        "Murugan",
        "sabari@gmail.com",
        23
    )

    // Encode to JSON String
    val userJ = Json.encodeToString(user1)
    println("User Object: $user1")
    println("User Json String: $userJ")
}

