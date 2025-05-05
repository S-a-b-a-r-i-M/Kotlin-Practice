package basic

// Note: The ranges of integral types, such as Int, Long, and Char, can be treated as arithmetic progressions.
// In Kotlin, these progressions are defined by special types: IntProgression, LongProgression, and CharProgression.

fun charRange(){
    for (i in 'A'..'z')
        print("$i (${i.code}), ")
}

fun main() {
    charRange()
}