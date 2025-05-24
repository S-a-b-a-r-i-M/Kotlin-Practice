package crackersTips

val districts = arrayOf("Karur",  "Chennai", "Trichy")

// TIP - 1 : Enhancing Iteration
fun enhanceIteration() {
    // Step - 1
    print("By simple step : " )
    for (index in 0 until districts.size)
        print("${districts[index]}, ")
    // Step - 2
    print("\nBy using indices : ", )
    for (index in districts.indices)
        print("${districts[index]}, ")
    // Step - 3
    print("\nBy withIndex method : ", )
    for ((index, value) in districts.withIndex())
        print("${value}, ")
}

// TIP - 2 : null + null
fun nullPlus(){
    val result = null + null
    println("Null + Null= $result")
}


fun main() {
//    enhanceIteration()
//    nullPlus()

}