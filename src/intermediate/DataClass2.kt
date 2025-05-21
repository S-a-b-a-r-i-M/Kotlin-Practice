package intermediate

data class DataUser(val userName: String, var age: Int){
    val id = userId++
    var email: String = "" // This won't reflect in toString().

    constructor(userName: String, age: Int, email: String): this(userName, age){
        println("Secondary constructor of ${this.javaClass}")
        this.email = email
    }

    companion object {
        var userId = 1
    }

    override fun toString(): String {
        return "DataUser(id=$id, userName=$userName, age=$age, email=$email)"
    }
}

class NormalUser(val userName: String, var age: Int){
    val id: Int = userId++
    var email: String = "" // This won't reflect in toString().

    constructor(userName: String, age: Int, email: String): this(userName, age){
        println("Secondary constructor of ${this.javaClass}")
        this.email = email
    }

    companion object {
        var userId = 1
    }

    override fun toString(): String {
        return "NormalUser(id=$id, userName=$userName, age=$age, email=$email)"
    }
}

fun main() {
    val userN1 = NormalUser("Muhamad Ali", 70, email = "xyz")
    val userN2 = NormalUser("Muhamad Ali", 70, email = "abc")
    val userN3 = userN2

    println("UserN1 ${userN1.hashCode()}, UserN2 ${userN2.hashCode()}, UserN3 ${userN3.hashCode()}")
    println("userN1 == userN2 = ${userN1 == userN2}") // false
    println("userN2 == userN3 = ${userN2 == userN3}") // true
    println("userN3 == userN1 = ${userN3 == userN1}") // false

    println("-------------------------------------------------------------")

    val userD1 = DataUser("Mic Tyson", 60, email = "xyz")
    // userD1.age = 50
    val userD2 = DataUser("Mic Tyson", 60, email = "abc")
    // userD2.age = 60
    val userD3 = userD2.copy()
    // userD3.age = 50

    println("UserD1 ${userD1.hashCode()}, UserD2 ${userD2.hashCode()}, UserD3 ${userD3.hashCode()}")
    println("userD1 == userD2 = ${userD1 == userD2}") // false
    println("userD2 == userD3 = ${userD2 == userD3}") // false
    println("userD3 == userD1 = ${userD3 == userD1}") // true

    println("-------------------------------------------------------------")

//    val hashMap1 = hashMapOf<NormalUser, DataUser>()
    val hashMap2 = hashMapOf<DataUser, NormalUser>()

//    hashMap1[userN1] = userD1
//    hashMap1[userN2] = userD2

    hashMap2[userD1] = userN1
    hashMap2[userD2] = userN2

//    println(hashMap1[userN1])
//    println(hashMap1[userN3])

    println(hashMap2[userD1])
    println(hashMap2[userD3])

    println("----------------------- Data Class Objects inside SET ---------------------------------")
    val set = mutableSetOf<DataUser>()
    set.add(userD1)
    set.add(userD2)
    set.add(userD3)
    println("set >>> $set")
}