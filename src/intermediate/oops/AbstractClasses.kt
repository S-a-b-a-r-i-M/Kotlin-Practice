package intermediate.oops

abstract class AbstractVehicle{
    // Abstract property (must be implemented by subclasses)
    abstract val color: String
    abstract val maxSpeed: Int

    // Concrete property with custom getter
    val isHighSpeedVehicle: Boolean
        get() = maxSpeed > 100

    // Abstract method (must be implemented by subclasses)
    abstract fun start(): Boolean

    // Concrete method (already implemented But Open)
    open fun horn(){
        println("Beep!! Beep!!")
    }
}

class Scooter(override val color: String, override val maxSpeed: Int) : AbstractVehicle() {
    override fun start(): Boolean {
        println("Bike is started")
        return true
    }
}

fun main() {
    var pulsar = Scooter("Blue with Black", 100)
}