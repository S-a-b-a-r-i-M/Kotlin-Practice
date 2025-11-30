package basic

object Constants {
    const val BASE_URL = "https://newsapi.org/"
    const val SEARCH_NEWS_TIME_DELAY = 500L
    const val PAGE_SIZE = 20
}

fun main() {
    println(Constants.BASE_URL)
}