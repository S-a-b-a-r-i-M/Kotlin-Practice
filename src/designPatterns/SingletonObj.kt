package designPatterns

// *********************** OBJECT WAY *******************
object Logger {
    init {
        println("Logger initialized")
    }

    fun log(message: String) {
        println("LOG: $message")
    }
}

// *********************** CLASS WAY *******************
class SingletonCls private constructor() {
    // Without volatile and double check
//    companion object {
//        private var instance: SingletonCls? = null
//        fun getInstance() = instance ?: synchronized(this) {
//            SingletonCls().also { instance = it } // Without Double Check
//        }
//    }

    // With volatile and double check
    companion object {
        @Volatile
        private var instance: SingletonCls? = null
        fun getInstance() = instance ?: synchronized(this) {
             instance ?: SingletonCls().also { instance = it }
        }
    }

    init {
        println("New Object Created for SingletonCls")
    }
}

fun main() {
    repeat(10){
        Thread {
            val obj = SingletonCls.getInstance()
            println("obj: ${obj.hashCode()}")
        }.start()
    }

    /*
//    val serviceALogger = Logger
    Logger.log("Program completed")
    Logger.log("Program completed")
    Logger.log("Program completed")
    */
}