package basic

// Note: there is no ternary operator (condition ? then : else) because ordinary if works fine in this role.

fun practiceIfElse(){
    println("Enter a and b values")
    val a: Int = readln().toInt()
    val b: Int = readln().toInt()

    println("If....Else ---------------------> ")
    if (a > b)
        println("Max is $a")
    else
        println("Max is $b")

    // println("Max is ${if(a > b) a else b}")

    println()
    // As Expression
    println("As Expression -------------------> ")
    var max = if (a > b) a else b
    println("Max of 2 $max")
    max = if (a > b && a > 10) a else if (b > 10) b else 10
    println("Max of 3 $max")
    // Branches of an if expression can be blocks.The last expression is the return value of a block
    max = if (a > b) {
        if (a <= 100){
            println("a is lesser than or equal to 100")
            a / 2
        }
        else{
            println("a is greater than 100")
            a
        }
    } else {
        println("b is bigger")
        b
    }
    println("Max of 2 using expression block $max")
}

fun practiceWhen(){
    // Statement
    println("Enter the number")
    val num = readln().toInt()
    when (num) {
        5, 10 -> println("number is divisible by only 5") // More than one case
        15 -> println("number is divisible by 5 and 3")
        else -> println ("something else")
    }

    // As an Expression with branch expression and subject
    println("\nAs Expression ----------------> ")
    val numberInText = when(num) {
        (10 / 2) -> "number is 5" // Under the roof: 10 / 2 == num(subject)
        9 / 3 -> "number is 3"
        else -> "something else"
    }
    println("branch expression and subject rangeText is : $numberInText")
    // Without subject
    val rangeText = when {
        num > 5 && num < 10  -> "number less than 10 and greater than 5"
        num < 20 -> "number grater than 10 and less than 20"
        else -> {
            println("I can write block of statement inside a branch")
            "something else"
        }
    }
    println("branch expression and without subject rangeText is : $rangeText")
}

fun main() {
    practiceIfElse()

//    practiceWhen()
}

