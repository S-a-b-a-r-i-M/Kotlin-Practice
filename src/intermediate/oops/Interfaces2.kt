package intermediate.oops

import basic.giveSomething
import intermediate.SuperUser

interface Car { // By default, interfaces are "PUBLIC"
    var model: String // It's not like java. Here this property belongs to object

    companion object { // We can have companion objects
        var brand = ""
    }

    // protected fun start() // Error: Modifier 'protected' is not applicable inside 'interface'.
    fun start()
    fun stop(){
        this.model = "Audi"
        println("Default implementation for stop inside Car($model)")
    }
    fun fillFuel()
}

abstract class  AbstractCar {
    var model: String = ""

    companion object {
        var brand = ""
    }

    abstract fun start()

    fun stop(){
        this.model = "Audi"
        println("Default implementation for crackers.stop inside Car($model)")
    }

    abstract fun fillFuel()
}

interface Robot {
    val name: String

    fun start()
    fun stop(){ // By default, implemented methods are "open"
        println("Default implementation for crackers.stop inside Robot($name)")
    }
    fun charge()
    fun attack(superPower: String? = null) {
        println("Fight started !!!")
        println("Reverse Punch 🥊")
        println("Head Kick")
        superPower?.let { println("Super Shot >> $superPower") }
        println("Won the fight \uD83C\uDFC6")
    }
}

class Transformer(override var model: String, override val name: String, var mode: String = "car") : Car, Robot {
    private var superPower = "Fire Bullet"

    fun setSuperPower(superPower: String) {
        this.superPower = superPower
    }

    fun attack() {
        super.attack(superPower)
    }

    override fun start() {
        println("Transformer ${this.name} Awoken")
    }

    override fun stop() {
        super<Robot>.stop() // Diamond problem solution
    }

    override fun fillFuel() {
        TODO("Not supported")
    }

    override fun charge() {
        println("Charging....")
        println("Charge full....")
    }

    fun transform(){
        mode = if (mode == "car") "robot" else "car"
        println("Transformed into $mode !!!")
    }
}

private class EvCar(override var model: String) : Car {
    override fun start() {
        println("EvCar started")
    }

    override fun fillFuel() {
        println("filling fuel...")
        println("Fuel is full !")
    }

}

//private class EvCarFromJava : JavaCar {
//    fun setBrand() {
//        //this.brand // Static won't visible in inheritance
////        JavaCar.brand
//    }
//
//    override fun crackers.stop() {
//        TODO("Not yet implemented")
//    }
//}

fun main() {
    val transformer = Transformer("Hyundai", "Kakashi")
    transformer.start()
    transformer.transform()
    transformer.charge()
    transformer.attack()
    transformer.stop()
    println(AbstractCar)
    // EvCar
    /*
    val evCar = EvCar("BMW")
    println("Model of my evCar ${evCar.model}")
    evCar.stop()
    println("Model of my evCar after crackers.stop ${evCar.model}")
    */
}