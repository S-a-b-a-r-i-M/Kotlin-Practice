package crackersTips

// FULLY QUALIFIED NAMES
/*
fun stop(){
    println("stops other functionalities...(top level)")
}

class MusicPlayer {
    fun play(){
        crackersTips.stop() // FULLY QUALIFIED NAME
        println("Playing song....")
    }

    fun pause(){
        println("Pausing song...")
    }

    fun stop(){
        println("Stopping song...")
    }
}

fun main() {
    val player = MusicPlayer()
    player.play()
    player.stop()
}
 */

// RETURN - THROW WITH ELVIS
fun getNullableValue(): String? = if (Math.random() < 0.7) "not null" else null

fun main() {
    // Doing nothing
    var nullable = getNullableValue()
    println("uppercase: ${nullable?.uppercase()}")

    // Return
    nullable = getNullableValue() ?: run {
        println("Oops! got an null. Terminating program !!!")
        return
    }
    println("uppercase: ${nullable.uppercase()}")

    // Throw
    nullable = getNullableValue() ?: error("it's a damn null....")
    println("uppercase: ${nullable.uppercase()}")
}

