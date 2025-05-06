package basic

fun inputAndOutput(){
    print("Enter yours name : ")
    val name = readln() // More kotlin way

//    val name2 = readLine() // A bit of java way. it can return null
//    println("Given name2: $name2")

    val initial: Char = readln()[0]
    println("Given name: $name.$initial")

    val age = readln().toInt()
    println("Given age: $age")

    println("Is given person alive ?")
    val isAlive = readln().toBoolean()
    println("is Alive : $age")

    val salary: Float? = readln().toFloatOrNull() // readln().toDouble()
    println("Given Salary : $salary")
}

fun outputs(){
    print("I will")
    print(" print on the same line !!!")

    print('\n')
    println("I will")
    print("print on the next line !!!")
}

fun main(){
    outputs()
    inputAndOutput()
}