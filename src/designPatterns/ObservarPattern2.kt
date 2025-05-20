package designPatterns

import kotlin.properties.Delegates

class WeatherStation {
    private val observers = mutableListOf<Observer>()
    var temperature by Delegates.observable(0.0f) { _, oldValue, newValue ->
        println("Temperature changed from $oldValue to $newValue")
        observers.forEach { it.update("Temperature $newValue") }
    }

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }
}

class User3 : Observer {
    override fun update(message: String) {
        println(message)
    }
}

fun main() {
    val weatherStation = WeatherStation()
    weatherStation.addObserver(User3())
    weatherStation.addObserver(User3())
    weatherStation.addObserver(User3())

    weatherStation.temperature = 10.2f
}