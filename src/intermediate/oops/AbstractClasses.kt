package intermediate.oops

abstract class AbstractVehicle{
    // Abstract property (must be implemented by subclasses)
    abstract val maxSpeed: Int
    abstract val color: String // needs an override
    var defaultColor: String = "red" /* This is NOT final by default.
    It's a concrete property with a backing field, but it's not marked as open, so it cannot be overridden.
    However, its value can be changed (reassigned) in subclasses.*/
    open var secondaryColor: String = "red" // if you want you can override
    val finalVariable = 0 // It can't be overridden

    // Concrete property with custom getter
    val isHighSpeedVehicle: Boolean
        get() = maxSpeed > 100

    // Abstract method (must be implemented by subclasses)
    abstract fun start(): Boolean

    // Concrete method (already implemented But Open)
    open fun horn(){ // By default, implemented methods are "final"
        println("Beep!! Beep!!")
    }
}

abstract class FlyingVehicle {

}

class Flight : FlyingVehicle() {

}


class Scooter(override val color: String, override val maxSpeed: Int) : AbstractVehicle() {
    override fun start(): Boolean {
        println("Bike is started")
        this.defaultColor = ""
        return true
    }

    override fun horn() {
        super.horn()
    }
}

fun main() {
    var pulsar = Scooter("Blue with Black", 100)
}