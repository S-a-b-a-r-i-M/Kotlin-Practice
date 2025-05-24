package designPatterns

// The Observable (Publisher) interface
interface Observable {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun update(message: String)
}

// The Observer interface
interface Observer {
    fun update(message: String)
}

// Concrete Observable implementation
class YoutubeChannel (private var channelName: String) : Observable {
    private val subscribers = mutableListOf<Observer>()

    fun uploadVideo(video: String){
        // Logic to upload
        update("New Video uploaded by $channelName")
    }

    override fun addObserver(observer: Observer) {
        subscribers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        subscribers.remove(observer)
    }

    override fun update(message: String) {
        subscribers.forEach { it.update(message) }
    }
}

// Concrete Observer implementations
class User2 (val name: String) : Observer {
    // Handle other logics
    override fun update(message: String) {
        println("New update: $message")
    }

    fun doSomething(){ // This fun won't visible in your Observable(youtube), abstraction and loose coupling

    }
}


// Usage
fun main() {
    val youtubeChannel = YoutubeChannel("My Code")
    youtubeChannel.addObserver(User2("sabari"))
    youtubeChannel.addObserver(User2("murugan"))

    youtubeChannel.uploadVideo("React Crash Course")
}