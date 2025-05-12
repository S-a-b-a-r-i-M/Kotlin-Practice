package intermediate.oops

interface Messenger {
    val parentCompany: String
    val productName: String
    val version: String

    fun send()
    fun open()
    fun read()
}

interface Messenger2 : Messenger {

    override fun send(){
        println("message sent")
    }
    fun download()
    fun voiceCall()
    fun videoCall()
}


// Interfaces can contain both abstract methods and method implementations
interface VehicleInterface {
    var isStarted: Boolean

    // Abstract method - no implementation
    fun startEngine(): Boolean

    // Method with default implementation
    fun horn(){
        println("Ponk!! Ponk!!")
    }

    fun display(){
        println("Vehicle's display")
    }
}

class CarImpl : VehicleInterface {
    override var isStarted = false

    override fun startEngine(): Boolean{
        isStarted = true
        println("Car engine started")
        return true
    }
}

class BikeImpl : VehicleInterface {
    override var isStarted = false

    override fun startEngine(): Boolean{
        isStarted = true
        println("Bike engine started")
        return true
    }

    override fun horn() {
        println("Beep... Beep...")
    }
}



fun main() {
    var maruti = CarImpl()
    maruti.horn()
}