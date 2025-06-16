package intermediate.oops

// Creating Normal Class
// Note: If the primary constructor does not have any annotations or visibility modifiers,
// the constructor keyword can be omitted
class Student constructor(
    val id: Int,
    val name: String,
    val standard: Int,
    val grade: Char = 'A',
){
//    Note: We can directly create the properties inside constructor by using val or var
//    val id = id
//    val name = name
//    val standard = standard
//    val grade = grade

    // Note: The init block has access to constructor parameters.
    init {
        // Init 1
        println("Student is created")
    }

    init {
        // Init 2
        println("A class can have more than one initializers")
    }

    companion object {
        init {
            println("Companion Object initialized")
        }
    }

    // Secondary Constructor
    // Note: 'val' on secondary constructor parameter is prohibited.(we can't create properties)
    constructor(id: Int, name: String): this(id, name, 10){
        println("Im the secondary constructor")
    }

    // Note: Member functions don’t have the permission to access constructor params — unless those are stored as properties.
    fun display(){
        println("Student id: $id, name: $name, standard: $standard, grade: $grade\n")
    }
}

open class Vehicle(val brand: String = "", val model: String = ""){
    private var color: String = ""

    constructor(brand: String, model: String, color: String) : this(brand,model){
        this.color = color
    }

    init {
        // Why i need init ❓
        // Validation: Throw exceptions if constructor arguments are invalid.
        // Logging/Diagnostics: Print or log initialization details.
        // Complex setup: Initialize other fields or call helper methods that depend on multiple parameters.
        // Shared logic: When you have multiple secondary constructors, init ensures core initialization runs exactly once
    }

    override fun toString(): String {
        return "Brand : $brand | Model : $model | Color : $color"
    }
}

interface Count {
    fun getTotalCount(): Int
}

// Class without primary constructor
class Bike{
    var model = ""
    var brand = ""
    var year = 0

    // COMPANION OBJECT
    companion object: Count { // It can implements interface
        init {
            println("Companion object initialized...")
        }

        var bikeCount = 0

        override fun getTotalCount() = bikeCount
    }

    object ObjectClass: Count {
        init {
            println("Object class initialized...")
        }

        var objBikeCount = 0

        override fun getTotalCount() = objBikeCount
    }

    init {
        bikeCount++;
        ObjectClass.objBikeCount++
        println("Bike initializers")
    }

    constructor(model: String, brand: String, year: Int){
        this.model = model
        this.brand = brand
        this.year = year
        println("Bike secondary constructor")
    }
}

// GETTERS & SETTERS
class Person(val fName: String, val lName: String){
    var fullName = fName + lName
        get() {
            println("Getter is invoked full-name")
            // return fullName // Will Make StackOVerFlow
            return field
        }
        set(value) {
            println("Setter is invoked full-name")
            field = value // Backing fields - https://kotlinlang.org/docs/properties.html#backing-fields
        }
}


fun main() {
    // STUDENT CLASS
    val student = Student(1, "Sabari", 11, 'A')
    student.display() // Calling member function
    println(student.id) // You can see the getter call on 'Decompiled file'

    val student2 = Student(id = 2, name = "Arasu")
    student2.display()

    // VEHICLE CLASS
    val vehicle = Vehicle("Maruti", "ertica", "Blue with Black")
//    println("Bike details --> ${vehicle}")
//
//    // BIKE CLASS
    val pulsar = Bike(model = "pulsar-150", brand = "Bajaj", year = 2024)
//    Bike.Companion.getTotalCount()
//    println("Total Bike Count From Static Method: ${Bike.getTotalCount()}")
    // Example of GET & SET
    /*
    val sabari = Person("Sabari", "Murugan")
    println("Sabari's Full-name ${sabari.fullName}")
    sabari.fullName = "Sabari M"
    println("Sabari's Full-name ${sabari.fullName}")
     */
}