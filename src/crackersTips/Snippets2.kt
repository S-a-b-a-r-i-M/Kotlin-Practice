package crackersTips

// FULLY QUALIFIED NAMES
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