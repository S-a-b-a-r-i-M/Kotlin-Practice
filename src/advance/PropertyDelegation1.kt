package advance

import kotlin.properties.Delegates

class DelegationProperties {
    val lazyTopic: String by lazy {
        println("First Access as a member variable")
        "Delegation Property - Class"
    }

    var observableSubscriber: String by Delegates.observable("") {
            property, oldValue, newValue ->
        println("$property changed from $oldValue to $newValue")
    }

    val currentSubscriberSurName: String
        public get() = observableSubscriber.split(" ").last()
}

fun delegatedProperties(){
    val lazyTopic: String by lazy {
        println("I can work inside a function.")
        "Delegation Property - Function"
    }

    println(lazyTopic)

    var observableSubscriber: String by Delegates.observable("") {
        property, oldValue, newValue ->
            println("$property changed from $oldValue to $newValue")
    }
}

val lazyTopic: String by lazy {
    println("I can work by standalone")
    "Delegation Property - Top Level"
}

var eventDriven: String by Delegates.observable("") {
    property, oldValue, newValue ->
        println("I can work by standalone after changing the value")
        println("Trigger an event")
}

fun main() {
    println("******************* LAZY *******************")

    val delegationProperties = DelegationProperties()
    println(delegationProperties.lazyTopic)

    println()

    delegatedProperties()

    println()

    lazyTopic

    println("\n*************** OBSERVABLE *****************")

    delegationProperties.observableSubscriber = "Sabari"

    println()
}