package basic

fun main() {
    // Creating book objects with properties
    val book1 = Book("1984", "George Orwell", 1949, 8.99, true)
    val book2 = Book("To Kill a Mockingbird", "Harper Lee", 1960, 7.99, true)
    val book3 = Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 6.99, false)

// ARITHMETIC OPERATORS
    // Calculate total price of all books
    val totalPrice = book1.price + book2.price + book3.price
    println("Total price: $$totalPrice") // Output: $23.97

    // Apply 10% discount to a book price
    val discountMultiplier = 0.9
    val discountedPrice = book1.price * discountMultiplier
    println("Discounted price of ${book1.title}: $$discountedPrice") // Output: $8.091

    // Calculate average price
    val averagePrice = totalPrice / 3
    println("Average book price: $$averagePrice") // Output: $7.99

    // Calculate remainder when dividing books by shelf capacity
    val totalBooks = 17
    val shelfCapacity = 5
    val remainderBooks = totalBooks % shelfCapacity
    println("Books left over after filling shelves: $remainderBooks") // Output: 2

// ASSIGNMENT OPERATORS
    var inventory = 10
    println("Initial inventory: $inventory") // Output: 10

    // Add 5 books to inventory
    inventory += 5
    println("After adding 5 books: $inventory") // Output: 15

    // Sell 3 books
    inventory -= 3
    println("After selling 3 books: $inventory") // Output: 12

    // Double the inventory (order more copies)
    inventory *= 2
    println("After doubling inventory: $inventory") // Output: 24

// COMPARISON OPERATORS
    println("Is book1 more expensive than book2? ${book1.price > book2.price}") // Output: true
    println("Is book3 the oldest? ${book3.year < book1.year && book3.year < book2.year}") // Output: true
    println("Are book1 and book2 from the same year? ${book1.year == book2.year}") // Output: false

// LOGICAL OPERATORS
    // Check if a book is both available and published after 1930
    val isModernAndAvailable = book1.available && book1.year > 1930
    println("Is book1 modern and available? $isModernAndAvailable") // Output: true

    // Check if a book is either by Orwell or published before 1930
    val isOrwellOrClassic = book1.author == "George Orwell" || book1.year < 1930
    println("Is book1 by Orwell or a classic? $isOrwellOrClassic") // Output: true

    // Negate availability
    val isOutOfStock = !book1.available
    println("Is book1 out of stock? $isOutOfStock") // Output: false

// RANGE OPERATOR
    // Check if book price is in budget range
    val isInBudgetRange = book2.price in 5.0..10.0
    println("Is book2 in budget range? $isInBudgetRange") // Output: true

    // Check if year is in a specific decade
    val isFrom50s = book2.year in 1950..1959
    println("Is book2 from the 50s? $isFrom50s") // Output: false

// ELVIS OPERATOR
    val customerReview: String? = null
    val displayReview = customerReview ?: "No reviews yet"
    println("Review: $displayReview") // Output: No reviews yet

// IS OPERATOR (Type checking)
    val specialItem: Any = getSpecialEditionBook()
    if (specialItem is SpecialEditionBook) {
        println("Special edition details: ${specialItem.specialFeature}")
    }

// SAFE CALL OPERATOR with LET
    val potentialBook: Book? = if (inventory > 20) book1 else null
    potentialBook?.let {
        println("Available book: ${it.title}")
    } ?: println("No book available at this inventory level")

// INDEXING OPERATOR
    val bookshelf = Bookshelf()
    bookshelf[0] = book1
    bookshelf[1] = book2
    val firstBook = bookshelf[0]
    println("First book on shelf: ${firstBook?.title}")

// UNARY INCREMENT/DECREMENT OPERATORS
    var booksSold = 0
    println("Books sold initially: ${booksSold}")
    booksSold++
    println("After selling one: ${booksSold}")
    ++booksSold
    println("After selling another (prefix): ${booksSold}")

// COLLECTION OPERATORS
    val bookCollection = listOf(book1, book2, book3)
    val modernBooks = bookCollection.filter { it.year > 1930 }
    println("Number of modern books: ${modernBooks.size}")

    // Merging collections with + operator
    val moreBooks = listOf(Book("Brave New World", "Aldous Huxley", 1932, 9.99, false))
    val expandedCollection = bookCollection + moreBooks
    println("Expanded collection size: ${expandedCollection.size}")

// SPREAD OPERATOR (for varargs)
    val prices = doubleArrayOf(book1.price, book2.price, book3.price)
    calculateTotal(*prices)
}

fun getSpecialEditionBook(): Any {
    return SpecialEditionBook("Dune", "Frank Herbert", 1965, 15.99, true, "First Edition")
}

// Supporting classes and functions
open class Book(val title: String, val author: String, val year: Int, val price: Double, val available: Boolean) {
    override fun toString(): String {
        return title
    }
}

class SpecialEditionBook(
    title: String,
    author: String,
    year: Int,
    price: Double,
    available: Boolean,
    val specialFeature: String
) : Book(title, author, year, price, available)

class Bookshelf {
    private val books = arrayOfNulls<Book>(10)

    // Demonstrating the indexing operator
    @JvmName("getBook")
    operator fun get(index: Int): Book? = books[index]
    @JvmName("setBook")
    operator fun set(index: Int, book: Book) {
        books[index] = book
    }
}

// Demonstrating the spread operator

fun calculateTotal(vararg prices: Double) {
    val total = prices.sum()
    println("Total from vararg function: $$total")
}