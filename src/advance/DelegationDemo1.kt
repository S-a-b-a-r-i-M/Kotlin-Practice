package advance

interface MusicInstrument {
    fun makeSound()
    fun changeTune()
}

class Piano : MusicInstrument {
    private var isPedalsPressed = false

    override fun makeSound() {
         println("piano...piano")
    }

    override fun changeTune() {
        println("Piano tune is getting changed...")
        makeSound()
        println("Piano tune set!!!")
    }

    // Functions specific to piano
    fun pressPedals() {
        isPedalsPressed = true
        println("Pedals are pressed")
    }

    fun releasePedals() {
        isPedalsPressed = false
        println("Pedals are released")
    }
}

class Delegate(instrument: MusicInstrument) : MusicInstrument by instrument {
    override fun makeSound() {
        println("delegate...delegate")
    }
}

class ModernPiano : MusicInstrument by Piano() {

}

fun main() {
    val piano: MusicInstrument = Piano()
    piano.makeSound()

    println()

    val delegate = Delegate(piano)
    delegate.makeSound()
    delegate.changeTune() // delegate only has access to its own implementations, not the overriding ones from the delegating class.

    println()

    val modernPiano = ModernPiano()
    modernPiano.makeSound()
}