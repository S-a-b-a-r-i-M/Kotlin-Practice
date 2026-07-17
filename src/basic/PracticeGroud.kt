package basic

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

class VolleyBall(val x1: String, val x2: String, var x3: String)

sealed class SClazz(x1: String) {
    object Badminton : SClazz("")
}


fun understandingCasting() {
    val a = null as String?
    val obj = null as PracticeGroundJ?
    val obj2 = obj as PracticeGroundJ // NPE
    println()
}

fun createInstanceByClazz() {
    listOf(VolleyBall::class.java, SClazz.Badminton::class.java).forEach {
        val constructor = it.declaredConstructors[0]
        var obj: Any? = null
        if (constructor.modifiers == 2) {
            obj = it.kotlin.objectInstance
        } else if (constructor.parameterTypes.all { it == String::class.java }) {
            val paramsCount = constructor.parameterTypes.size
            val args = Array(paramsCount) { _ -> "" }
            val parameterTypes = Array(paramsCount) { String::class.java }
            obj = it.getDeclaredConstructor(*parameterTypes).newInstance(*args)
        }
        println(obj)
    }
}

object NumberFormatter {

    fun format(value: String): String {
        val locale = Locale.forLanguageTag("en_US")
        val symbols = DecimalFormatSymbols(locale).apply {
            groupingSeparator = ' '
            decimalSeparator = '.'
        }

        val decimalFormat = (NumberFormat.getNumberInstance(locale) as DecimalFormat).apply {
            decimalFormatSymbols = symbols
            maximumFractionDigits = 2
            isGroupingUsed = true
        }

        val number = value.toDoubleOrNull()?.let { decimalFormat.format(it) }
        return number ?: value
    }
}

fun main() {
//    println(System.getProperty("user.dir"))
//    understandingCasting()
    /*
    inlineFun {
        println("1")
        println("2")
        println("3")
        println("4")
        println("5")
        println("6")
        println("7")
        // Some Complex Code
    }
     */
    println(NumberFormatter.format("202"))
    println(NumberFormatter.format("10000000.01232"))
}


inline fun inlineFun(lambda: () -> Unit) {

}