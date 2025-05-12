package intermediate

/*
fun ReceiverType.funName (arg1: type, arg2: type, etc,...): return type {
    body
}
*/

// Adds a swap function to Array<T>
fun <T> Array<T>.swap(index1: Int, index2: Int){
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = this[index1]
}

open class Vehicle {
    open fun invoke(){
        println("invoking Vehicle class extension function")
    }
}

class Tractor : Vehicle() {
    override fun invoke(){
        println("invoking Tractor class extension function")
    }
}

fun Vehicle.stop() {
    println("stopping Vehicle class extension function")
}

fun Tractor.stop() {
    println("stopping Tractor class extension function")
}

fun invokeVehicle(vehicle: Vehicle){
    vehicle.invoke()
}

fun stopVehicle(vehicle: Vehicle){
    vehicle.stop()
}

fun main() {
  // Adds a swap function to Array<T>
    val family = Array<String>(4) { "" }
    family[0] = "Murugan"
    family[1] = "Chithra"
    family[2] = "Nithika"
    family[3] = "Sabari"
    println("Original Family tree : ${family.joinToString()}")

    family.swap(2, 3)
    println("After Swap Family tree : ${family.joinToString()}\n")

  // Extensions are resolved statically
    val tractor: Tractor = Tractor()
    invokeVehicle(tractor)
    stopVehicle(tractor)
}