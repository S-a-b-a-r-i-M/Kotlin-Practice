package intermediate

class DatabaseHelper {
    companion object {
        init {
            println("Companion object initialized")
        }
    }

    init {
        println("Instance initialized")
    }
}

// Timeline:
fun main() {
    println("1. App started")

    // This triggers ClassLoading + Linking + Initialization:
    val clazz = DatabaseHelper::class.java
    println("2. Got class reference")
    // Output so far:
    // 1. App started
    // Companion object initialized  ← Static init happened!
    // 2. Got class reference

    // This creates an instance:
    val instance = clazz.getDeclaredConstructor().newInstance()
    println("3. Created instance")
    val instance2 = clazz.getDeclaredConstructor().newInstance()
    println("4. Created instance again")
    // Output:
    // Instance initialized  ← Instance init happened
    // 3. Created instance

    // Getting class reference again:
    val clazz2 = DatabaseHelper::class.java
    println("4. Got class reference again")
    // Output:
    // 4. Got class reference again  ← NO companion init! Already loaded

    println(clazz === clazz2)  // true - same object
}