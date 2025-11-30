package basic

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object DateFormats {
    const val MONTH_WITH_LEADING_0 = "MM"    // 01–12
    const val MONTH_WITHOUT_LEADING_0 = "M"   // 1–12
    const val MONTH_ABBREVIATED = "MMM"  // Jan, Feb
    const val MONTH_FULL = "MMMM"        // January, February

    const val DAY_WITHOUT_LEADING_0 = "d"     // 1–31
    const val DAY_WITH_LEADING_0 = "dd"      // 01–31

    const val YEAR_FULL = "yyyy"         // 2025
    const val YEAR_TWO_DIGIT = "yy"      // 25

    const val HOURS_24 = "HH"           // 00 - 23
    const val HOURS_12 = "hh"           // 01 - 12
    const val MINUTES = "mm"            // 00 - 59

    const val DATE_DDMMYYYY = "$DAY_WITH_LEADING_0/$MONTH_WITH_LEADING_0/$YEAR_FULL"
}

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

fun formatEpochTime(epochTime: Long) {
    val instant = Instant.ofEpochSecond(epochTime)
    val format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val format2 = DateTimeFormatter.ofPattern("MMM dd, yyyy")
    println("ZoneId.systemDefault(): ${ZoneId.systemDefault()}")
    val zonedDateTime = instant.atZone(ZoneId.systemDefault())
    println(zonedDateTime.format(format1))
    println(zonedDateTime.format(format2))
}


fun String.toEpochSeconds(format: String = "dd/MM/yyyy : HH"): Long {
    val formatter = DateTimeFormatter.ofPattern(format)
    // Parse into LocalDate
    val localDate = LocalDate.parse(this, formatter)
    // Convert to epoch seconds (start of day in UTC)
    return localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC)
}

fun Long.fromEpochSeconds(format: String = "dd/MM/yyyy : HH"): String {
    val instant = Instant.ofEpochSecond(this)
    val zonedDateTime = instant.atZone(ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern(format)
    return formatter.format(zonedDateTime)
}

fun main() {
    /*
    val localDateTime = LocalDateTime.now()
    println(1 - (-1))
    println("LocalDateTime: ${LocalDateTime.now()}")
    formatEpochTime(1753133136)
 */
    val datetimeStr = "30/08/2025 : 04" // This is my local date time
    val epochTime = datetimeStr.toEpochSeconds()
    println("It should be, 30/08/2025 = ${epochTime.fromEpochSeconds()}")

    // Parse into LocalDate
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy : HH")
    val localDateTime = LocalDateTime.parse(datetimeStr, formatter)
    // Parsing UTC epoch seconds by giving date time with my zone info
    val epochSeconds = localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond()
    println("Epoch second for $datetimeStr : $epochSeconds")
    println("Locale Date Time $epochSeconds : ${epochSeconds.fromEpochSeconds("dd/MM/yyyy : HH")}")
}