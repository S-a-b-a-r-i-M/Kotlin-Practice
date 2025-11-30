package intermediate

class Phone {

    @Deprecated("This method is no-longer supported", ReplaceWith("smartCamera"))
    fun camera() {
        println("Take Picture")
    }

    fun smartCamera() {
        println("Take Picture & Video also...")
    }
}

fun main() {
    val phone = Phone()
    phone.camera() // Deprecation warning
    phone.smartCamera()
}