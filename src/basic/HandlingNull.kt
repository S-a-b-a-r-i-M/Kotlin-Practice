package basic

fun giveSomething(): Int? {
    return null
}

// Note: While accessing this method in java explicitly we have to handle nullability
fun getBrand() = if (Math.random() * 10 <= 6) "Vivo" else null

fun main() {
    var phoneBrand = getBrand()
    println("My phone's brand is $phoneBrand(${phoneBrand?.length})")

    if (phoneBrand is String) // Smart Cast
        println("Phone brand length: (${phoneBrand.length})")

    val interOperable = InterOperable()
    // Without ?. the below line will throw NPException
    println("Access interOperable's name ${interOperable.name}(${interOperable.name?.length})")

    val num = giveSomething()
    println("giveSomething given ${num?.minus(0)}")
}