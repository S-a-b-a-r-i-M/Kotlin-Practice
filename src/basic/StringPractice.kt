package basic

fun compare(){
    var userName1: String = "Sabari"
    var userName2: String = "Sabari"

    println("String Comparisons")
    println("$userName1 == $userName2 : ${userName1 == userName2}")
    println("$userName1.equals($userName2) : ${userName1.equals(userName2)}")
    // YOU CAN SEE THE SAME HASHCODE BECAUSE OF THE STRING POOL CONCEPT(not creating separate memory for same string object)
    println("HashCodes of, userName1:${System.identityHashCode(userName1)} userName2:${System.identityHashCode(userName2)}")

    // IgnoreCase
}

fun main() {
    compare()
}