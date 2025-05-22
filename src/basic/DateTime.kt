package basic

import java.time.*

fun dateTimeManipulation() {
    // Current date and time
    val now = LocalDateTime.now()
    val today = LocalDate.now()
    val currentTime = LocalTime.now()

    println("DateTime: $now")
    println("Today: $today")
    println("Time: $currentTime")

    // Specific date and time
    LocalDateTime.of(2002, 2, 5, 10, 0, 0, 400)
    LocalDateTime.of(2012, 8, 14, 0, 0)

    println("My birthday:")

    // From string

}