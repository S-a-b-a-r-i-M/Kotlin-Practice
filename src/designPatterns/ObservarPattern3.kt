package designPatterns

import kotlin.properties.Delegates.observable

typealias Score = Pair<Int, Int>

//abstract class Publisher {
//    protected val subscribers = mutableListOf<GameObserver>()
//
//    fun attachObserver(observer: GameObserver) = subscribers.add(observer)
//
//    fun detachObserver(observer: GameObserver) = subscribers.remove(observer)
//
//    protected fun onUpdate() {
//        subscribers.forEach { it.update() }
//    }
//}

class Game(private val subscribers: List<GameObserver>) {
//    var score: Score = 0 to 0 // Score(0, 0)
//        set(value) {
//            field = value
//            onUpdate()
//            println()
//        }
    var score: Score by observable(0 to 0) { _, _, new ->
        subscribers.forEach { it.update(new) }
    }

    fun onFirstTeamScores() {
        score = score.copy(first = score.first + 1)
    }

    fun onSecondTeamScores() {
        score = score.copy(second = score.second + 1)
    }
}

// ------------------------------------------------------------------------------

interface GameObserver {
    fun update(score: Score)
}

class ScoreAnnouncer : GameObserver {
    override fun update(score: Score) {
        println("The score of the first team is : ${score.first}")
        println("The score of the second team is : ${score.second}")
    }
}

class LeadingTeamAnnouncer : GameObserver {
    override fun update(score: Score) {
        val (first, second) = score
        when {
            first > second -> println("First1️⃣ team is in the lead")
            first < second -> println("Second2️⃣ team is in the lead")
            else -> println("The game is tie!!!")
        }
    }
}


fun main() {
    val game = Game(listOf(ScoreAnnouncer(), LeadingTeamAnnouncer()))

    game.onSecondTeamScores()
    game.onSecondTeamScores()
    game.onFirstTeamScores()
}
