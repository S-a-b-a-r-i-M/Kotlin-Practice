package basic

fun giveSomething(): Int? {
    return null
}

fun main() {
    var phoneBrand: String? = "Vivo"
    println("My phone's brand is $phoneBrand(${phoneBrand?.length})")

    if (phoneBrand is String) // Smart Cast
        println("My phone's brand is $phoneBrand(${phoneBrand.length})")

    val interOperable = InterOperable()
    // Without ?. the below line will throw NPException
    println("Access interOperable's name ${interOperable.name}(${interOperable.name?.length})")

    val num = giveSomething()
    println("giveSomething given ${num?.minus(0)}")
}