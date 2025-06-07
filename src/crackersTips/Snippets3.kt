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


// TIP - 3 : Null values on operator overload functions
class Vec2(var x: Int, var y: Int) {
    operator fun plus(other: Vec2?): Vec2 {
        val otherVec = other ?: Vec2(0, 0)
        this.x += otherVec.x
        this.y += otherVec.y
        return this
    }

    override fun toString(): String {
        return "x: $x, y: $y"
    }
}

operator fun Vec2?.plus(other: Vec2): Vec2 {
    return other + this
}


fun main() {
//    enhanceIteration()

//    nullPlus()

    println(Vec2(3, 4) + Vec2(7, 6))
    println(Vec2(3, 4) + null)
    println(null + Vec2(7, 6))
}