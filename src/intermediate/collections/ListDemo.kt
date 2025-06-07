package intermediate.collections


fun immutableList(){
    val fruitList = listOf("apple", "banana", "cherry", "banana", "dragonfruit")
    val numberList = listOf<Int>(3, 7, 11, 0)
    println("original fruitList: $fruitList, numberList: $numberList")


    // Basic properties
    println("\n-------------------------- Basic properties --------------------------")
    println("Size: ${fruitList.size}")
    println("Is empty: ${fruitList.isEmpty()}")
    println("Contains 'banana': ${fruitList.contains("banana")}")
    println("Element at index 2: ${fruitList[2]}")  // Or fruitList.get(2)

    // Access operations
    println("\n-------------------------- Access operations --------------------------")
    println("First element: ${fruitList.first()}")
    println("Last element: ${fruitList.last()}")
    println("Element at index 1: ${fruitList.elementAt(1)}") // there's no practical difference between get(index) (or shorthand numbers[index]) and elementAt(index)
    println("Random element: ${fruitList.random()}")
    // println("not valid element ${fruitList[11]}") // ERROR: java.lang.ArrayIndexOutOfBoundsException
    println("accessing not valid element " +
            "getOrNull : ${fruitList.getOrNull(11)}, " +
            "getOrDefault: ${fruitList.getOrElse(11) {0}}")

    // Search operations
    println("\n-------------------------- Search operations --------------------------")
    println("Index of 'banana': ${fruitList.indexOf("banana")}")
    println("Last index of 'banana': ${fruitList.lastIndexOf("banana")}")
    println("Find element starting with 'c': ${fruitList.find { it.startsWith("c") }}")
    println("Position of first element starting with 'b': ${fruitList.indexOfFirst { it.startsWith("b") }}")

    // Slicing and windowing
    println("\n-------------------------- Slicing and windowing --------------------------")
    println("Sublist (1..3): ${fruitList.subList(1, 3)}")
    println("Take first 2: ${fruitList.take(2)}")
    println("Drop first 2: ${fruitList.drop(2)}")
    println("Take last 2: ${fruitList.takeLast(2)}")
    println("Sliced by indices: ${fruitList.slice(listOf(0, 2, 4))}")
    println("Chunked by 2: ${fruitList.chunked(2)}")
    println("Windowed by 2: ${fruitList.windowed(2)}")

    // Transformation operations
    println("\n-------------------------- Transformation operations --------------------------")
    println("Mapped to lengths: ${fruitList.map { it.length }}")
    println("Filtered starting with 'b': ${fruitList.filter { it.startsWith("b") }}")
    println("Sorted naturally: ${fruitList.sorted()}")
    println("Sorted by length: ${fruitList.sortedBy { it.length }}")
    println("Sorted by length descending: ${fruitList.sortedByDescending { it.length }}")
    println("Distinct elements: ${fruitList.distinct()}")
    println("Reversed: ${fruitList.reversed()}")
    println("Joined to string: ${fruitList.joinToString(", ")}")

    // Aggregate operations
    println("\n-------------------------- Aggregate operations --------------------------")
    println("Count of elements starting with 'b': ${fruitList.count { it.startsWith("b") }}")
    println("Any element contains 'e': ${fruitList.any { it.contains("e") }}")
    println("All elements length > 3: ${fruitList.all { it.length > 3 }}")
    println("None of elements is empty: ${fruitList.none { it.isEmpty() }}")
    println("Max element: ${numberList.maxOrNull()}")
    println("Min element: ${numberList.minOrNull()}")
    println("Sum of numbers: ${numberList.sum()}")
    println("Average of numbers: ${numberList.average()}")

    // Grouping and association
    println("\n-------------------------- Grouping and association --------------------------")
    println("Grouped by first letter: ${fruitList.groupBy { it.first() }}")
    println("Associated by first letter: ${fruitList.associateBy { it.first() }}")
    println("Associated with length: ${fruitList.associate { it to it.length }}")

    // Zip and flatten
    println("\n-------------------------- Zip and flatten --------------------------")
    val colors = listOf("red", "yellow")
    println("Zipped with vegetables: ${fruitList.zip(colors)}")
    val nestedList = listOf(listOf(1, 2), listOf(3, 4))
    println("Flattened nested list: ${nestedList.flatten()}")

    // Destructuring
    println("\n-------------------------- Destructuring --------------------------")
    val (first, second, third) = fruitList
    println("Destructured: first=$first, second=$second, third=$third")

    // Utility operations
    println("\n-------------------------- Utility operations --------------------------")
    println("With index: ${fruitList.withIndex().toList()}")
    println("Partitioned by length > 5: ${fruitList.partition { it.length > 5 }}")
}

fun mutableList(){
// Creating mutable lists
    val emptyMutableList = mutableListOf<String>()
    val fruitMutableList = mutableListOf("apple", "banana", "cherry", "jack fruit")
    val numberMutableList = mutableListOf(5, 2, 8, 1)

    println("Original mutable list: $fruitMutableList")

    // Adding elements
    fruitMutableList.add("dragonfruit")
    println("After add: $fruitMutableList")

    fruitMutableList.add(1, "blueberry")
    println("After add at index 1: $fruitMutableList")

    fruitMutableList.addAll(listOf("mango", "goa"))
    println("After addAll: $fruitMutableList")

    // Removing elements
    fruitMutableList.remove("banana")
    println("After remove 'banana': $fruitMutableList")

    fruitMutableList.removeAt(0)
    println("After removeAt index 0: $fruitMutableList")

    fruitMutableList.removeIf { it.length > 6 } // ***
    println("After removeIf length > 6: $fruitMutableList")

    // Updating elements
    fruitMutableList[0] = "orange"
    println("After update at index 0: $fruitMutableList")

    fruitMutableList.set(1, "grape")  // Alternative to indexing
    println("After set at index 1: $fruitMutableList")

    // Clearing and filling
    val tempList = mutableListOf("temp1", "temp2", "temp3")
    tempList.clear()
    println("After clear: $tempList")

    tempList.addAll(listOf("new1", "new2"))
    println("After refilling: $tempList")

    // Bulk modifications
    fruitMutableList.retainAll { it.length < 6 } // ***
    println("After retainAll length < 6: $fruitMutableList")

    // Sorting in place
    numberMutableList.sort()
    println("After sort: $numberMutableList")

    numberMutableList.sortDescending()
    println("After sortDescending: $numberMutableList")

    fruitMutableList.sortBy { it.length }
    println("After sortBy length: $fruitMutableList")

    // Shuffle
    fruitMutableList.shuffle()
    println("After shuffle: $fruitMutableList")

    // Fill
    val fixedSizeList = MutableList(3) { "Item $it" }
    println("Fixed size list: $fixedSizeList")

    fixedSizeList.fill("replaced")
    println("After fill: $fixedSizeList")

    // fixedSizeList[6] = "" // ERROR: java.lang.IndexOutOfBoundsException

    // ListIterator specific operations
    val iterator = fruitMutableList.listIterator()
    if (iterator.hasNext()) {
        iterator.next()
        iterator.add("inserted")
    }
    println("After iterator add: $fruitMutableList")

    // SubList manipulation (changes reflect in original)
    val subList = fruitMutableList.subList(0, 2)
    subList.clear()
    println("After subList clear: $fruitMutableList")

    // Specialized builder
    val builtList = buildList { // ***
        add("first")
        add("second")
        addAll(listOf("third", "fourth"))
    }
    println("Built list: $builtList")
}

fun randomWorks() {
    // Filter
    val fruitMutableList = mutableListOf("apple", "banana", "cherry", "jack fruit")
    println(fruitMutableList.filter { it.contains("mango") })
}

fun main() {
    println("Empty list class: ${listOf<Int>()::class}")
    println("Single element list class: ${listOf<Int>(123)::class}")
    println("Multi element list class: ${listOf<Int>(123, 456, 789)::class}")

//    immutableList()

//    mutableList()

    randomWorks()
}