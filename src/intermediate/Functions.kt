package intermediate

import basic.InterOperable

// OVERRIDING METHODS ALWAYS USE THE BASE METHOD'S DEFAULT PARAMETER VALUES.

open class Animal {
    // NOTE: by default class and functions are public and final
    @JvmOverloads
    open fun eat(food: String = "gross"){
        println("Animal eating $food")
    }
}

class Goat : Animal() {
    // NOTE: An overriding function is not allowed to specify default values for its parameters.
    override fun eat(food: String){
        println("Goat eating $food")
        println(title2)
        println(MyObject.title1)
    }

    object MyObject {
        val title1 = "MyObject"
    }

    companion object {
        val title2 = "MyCompanionObject"
    }
}


fun sing(song: String, duration: Double) {
    println("Singing songuu...")
}

// LOCAL FUNCTION
fun outer(param1: Any){
    fun inner(){
        println("Inner function can access Outer function's variables: $param1")
    }

    inner()
}

// EXTENSION FUNCTION

fun String.capitalize(): String = this[0].uppercase() + this.substring(1).lowercase()

fun main() {
      val goat = Goat()
      goat.eat()
      Goat.MyObject.title1
      Goat.title2
      Goat.Companion.title2

    // NAMED ARGUMENTS WON'T WORK WHILE CALLING JAVA FUNCTIONS
    val interOperable = InterOperable()
    //interOperable.sing(song="Why this kolaveri", duration=3.50) // ERROR: Named arguments are prohibited for non-Kotlin functions.
    interOperable.sing("Why this kolaveri", 3.50)
    sing(song = "Naan Pollathvan", duration = 3.5)

    //outer(123)
    println("EXTENSION FUNCTION IS USEFUL".capitalize())
}