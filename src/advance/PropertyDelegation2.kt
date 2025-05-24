package advance

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

// ***************************** STANDARD LIBRARY DELEGATE *****************************
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

// ***************************** CUSTOM PROPERTY DELEGATION *****************************
class PersonName {
    // WITHOUT DELEGATION
    /*
    var firstName: String? = null
        public set(value) {
            val formattedValue = value?.trim() ?: ""
            if (formattedValue.length > 2)
                field = formattedValue[0].uppercase() + formattedValue.substring(1).lowercase()
        }

    var lastName: String? = null
        public set(value) {
            val formattedValue = value?.trim() ?: ""
            if (formattedValue.length > 2)
                field = formattedValue[0].uppercase() + formattedValue.substring(1).lowercase()
        }
     */

    // WITH DELEGATION
    var firstName: String? by NameDelegation()
    var lastName: String? by NameDelegation()

    override fun toString(): String {
        return "$firstName $lastName"
    }
}

class NameDelegation {
    var formattedName: String? = null

    operator fun setValue(objRef: Any?, property: KProperty<*>, value: String?) {
        val formattedValue = value?.trim() ?: ""
        if (formattedValue.length > 2)
            formattedName = formattedValue[0].uppercase() + formattedValue.substring(1).lowercase()
    }

    operator fun getValue(objRef: Any?, property: KProperty<*>): String? {
        return formattedName
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

    /*
    val name = PersonName()
    name.firstName = "sabari"
    name.lastName = "murugan"
    println(name)
    */
}
