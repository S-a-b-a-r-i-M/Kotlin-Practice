package advance

import kotlin.properties.Delegates

class Component (val code: String) {
    val isPageViewable : Boolean by lazy {
        renderPage()
        println("loading...")
        Thread.sleep(1000)
        true
    }

    var password: String by Delegates.observable("") {
        property, oldValue, newValue ->
            println("State changed")
            renderPage()
    }

    fun renderPage(){
        println("rendering page....")
    }
}

fun main() {
    val component = Component("Login in page code")

    if (component.isPageViewable)
        println("Navigated to page")
    else
        println("Page is not available")

    println("Enter your password: ")
    val password = readln()
    println("User interaction ---> ")
    component.password = password

    var userName: String by Delegates.notNull<String>()
    println(" UserName is $userName")
}