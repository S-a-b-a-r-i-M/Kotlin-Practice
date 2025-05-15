package advance

interface MusicInstrument {
    fun play()
    fun playLoudly()
}

class Piano : MusicInstrument {
    override fun play() {
         println("piano...piano")
    }

    override fun playLoudly() {
        println("Piano is getting loud...")
        play()
        println("Piano got louder!!!")
    }
}

class Delegate(instrument: MusicInstrument) : MusicInstrument by instrument {
    override fun play() {
        println("delegate...delegate")
    }
}

class ModernPiano : MusicInstrument by Piano() {

}

fun main() {
    val piano: MusicInstrument = Piano()
    piano.play()

    println()

    val delegate = Delegate(piano)
    delegate.play()
    delegate.playLoudly() // delegate only has access to its own implementations, not the overriding ones from the delegating class.

    println()

    val modernPiano = ModernPiano()
    modernPiano.play()
}