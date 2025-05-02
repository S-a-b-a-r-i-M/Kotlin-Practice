package basic

fun checkTypes(obj: Any){
//    if (obj is String) println("Given object is String")
//    else if (obj is Int) println("Given object is Integer")
//    else if (obj is Float) println("Given object is float")
//    else println("Given object is not a Sting or Int or Float")
    //Note: We can use !is also
    when (obj){
        is String -> println("Given object is String")
        is Int -> println("Given object is not an Integer")
        is Float -> println("Given object isn't float")
        else -> println("Given object is not a Sting or Int or Float")
    }
}

fun main() {
    checkTypes("dan")
    checkTypes(9.0)
}