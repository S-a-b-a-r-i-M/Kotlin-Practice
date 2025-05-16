package intermediate.collections

fun main() {
    println("=== IMMUTABLE SET OPERATIONS ===\n")
//    demonstrateImmutableSetOperations()

    println("\n=== MUTABLE SET OPERATIONS ===\n")
    demonstrateMutableSetOperations()
}

fun demonstrateImmutableSetOperations() {
    println("\n-------------------------- Creating Sets --------------------------")
    val emptySet = setOf<String>()
    val singleElementSet = setOf("apple")
    val fruitSet = setOf("apple", "banana", "cherry", "apple") // Note: duplicates are removed
    val numberSet = setOf(5, 2, 8, 1, 9, 3)

    println("Original set: $fruitSet")
    println("Note that duplicates are automatically removed: setOf(\"apple\", \"banana\", \"cherry\", \"apple\") = $fruitSet")

    println("\n-------------------------- Basic Properties --------------------------")
    println("Size: ${fruitSet.size}")
    println("Is empty: ${fruitSet.isEmpty()}")
    println("Contains 'banana': ${fruitSet.contains("banana")}")

    println("\n-------------------------- Access Operations --------------------------")
    println("First element: ${fruitSet.first()}")
    println("Last element: ${fruitSet.last()}")
    println("First element or null (empty set): ${emptySet.firstOrNull()}")
    println("Element at index 1 (note: sets aren't indexed but can be accessed this way): ${fruitSet.elementAt(1)}")
    println("Random element: ${fruitSet.random()}")

    println("\n-------------------------- Element Testing --------------------------")
    println("Set contains 'banana': ${fruitSet.contains("banana")}")
    println("Set contains 'banana' by in: ${"banana" in fruitSet}")
    println("Set contains all elements ['apple', 'cherry']: ${fruitSet.containsAll(listOf("apple", "cherry"))}")

    println("\n-------------------------- Search Operations --------------------------")
    println("Find element starting with 'c': ${fruitSet.find { it.startsWith("c") }}")
    println("First element starting with 'b' or null: ${fruitSet.firstOrNull { it.startsWith("b") }}")
    println("Count of elements with length > 5: ${fruitSet.count { it.length > 5 }}")

    println("\n-------------------------- Filtering --------------------------")
    println("Filtered starting with 'b': ${fruitSet.filter { it.startsWith("b") }}")
    println("Filtered NOT starting with 'b': ${fruitSet.filterNot { it.startsWith("b") }}")

    println("\n-------------------------- Transformation Operations --------------------------")
    println("Mapped to lengths: ${fruitSet.map { it.length }}")
    println("Mapped to uppercase: ${fruitSet.map { it.uppercase() }}")
    println("Sorted naturally: ${fruitSet.sorted()}")
    println("Sorted by length: ${fruitSet.sortedBy { it.length }}")
    println("Reversed: ${fruitSet.reversed()}")
    println("Joined to string: ${fruitSet.joinToString(", ")}")

    println("\n-------------------------- Aggregate Operations --------------------------")
    println("Any element contains 'e': ${fruitSet.any { it.contains("e") }}")
    println("All elements length > 3: ${fruitSet.all { it.length > 3 }}")
    println("None of elements is empty: ${fruitSet.none { it.isEmpty() }}")
    println("Max element: ${numberSet.maxOrNull()}")
    println("Min element: ${numberSet.minOrNull()}")
    println("Sum of numbers: ${numberSet.sum()}")
    println("Average of numbers: ${numberSet.average()}")

    println("\n-------------------------- Set Operations --------------------------")
    val vegetableSet = setOf("carrot", "potato", "cherry")
    println("Set A: $fruitSet")
    println("Set B: $vegetableSet")
    println("Union: ${fruitSet union vegetableSet}")  // Or use: fruitSet + vegetableSet
    println("Intersection: ${fruitSet intersect vegetableSet}")
    println("Difference (A - B): ${fruitSet - vegetableSet}")
    println("Difference (B - A): ${vegetableSet - fruitSet}")
    println("Is subset: ${setOf("apple", "banana").subtract(fruitSet).isEmpty()}")

    println("\n-------------------------- Grouping and Association --------------------------")
    println("Grouped by first letter: ${fruitSet.groupBy { it.first() }}")
    println("Associated by first letter: ${fruitSet.associateBy { it.first() }}")
    println("Associated with length: ${fruitSet.associate { it to it.length }}")

    println("\n-------------------------- Collection Conversion --------------------------")
    println("To List: ${fruitSet.toList()}")
    println("To MutableSet: ${fruitSet.toMutableSet()}")
    println("To Sorted Set: ${fruitSet.toSortedSet()}")
    println("To HashSet: ${fruitSet.toHashSet()}")

    println("\n-------------------------- Utility Operations --------------------------")
    println("With index: ${fruitSet.withIndex().toList()}")
    println("Partitioned by length > 5: ${fruitSet.partition { it.length > 5 }}")
    println("Chunked by 2: ${fruitSet.chunked(2)}")
}

fun demonstrateMutableSetOperations() {
    println("\n-------------------------- Creating Mutable Sets --------------------------")
    val emptyMutableSet = mutableSetOf<String>()
    val fruitMutableSet = mutableSetOf("apple", "banana", "cherry")
    val numberMutableSet = mutableSetOf(5, 2, 8, 1)

    println("Original mutable set: $fruitMutableSet")

    println("\n-------------------------- Adding Elements --------------------------")
    val addResult = fruitMutableSet.add("dragonfruit")
    println("After add 'dragonfruit' (success=$addResult): $fruitMutableSet")

    val duplicateAddResult = fruitMutableSet.add("apple")
    println("After add 'apple' again (success=$duplicateAddResult): $fruitMutableSet")

    fruitMutableSet.addAll(listOf("elderberry", "fig"))
    println("After addAll: $fruitMutableSet")

    println("\n-------------------------- Removing Elements --------------------------")
    val removeResult = fruitMutableSet.remove("banana")
    println("After remove 'banana' (success=$removeResult): $fruitMutableSet")

    val notPresentRemoveResult = fruitMutableSet.remove("not_present")
    println("After remove 'not_present' (success=$notPresentRemoveResult): $fruitMutableSet")

    fruitMutableSet.removeIf { it.length > 6 }
    println("After removeIf length > 6: $fruitMutableSet")

    println("\n-------------------------- Set Bulk Operations --------------------------")
    val otherSet = setOf("apple", "kiwi", "lemon")
    println("This set: $fruitMutableSet")
    println("Other set: $otherSet")

    fruitMutableSet.retainAll(otherSet)
    println("After retainAll (intersection): $fruitMutableSet")

    fruitMutableSet.addAll(listOf("cherry", "elderberry"))
    println("After re-adding some elements: $fruitMutableSet")

    fruitMutableSet.removeAll(otherSet)
    println("After removeAll (difference): $fruitMutableSet")

    println("\n-------------------------- Clearing --------------------------")
    val tempSet = mutableSetOf("temp1", "temp2", "temp3")
    println("Before clear: $tempSet")
    tempSet.clear()
    println("After clear: $tempSet")

    println("\n-------------------------- Iterator Operations --------------------------")
    val iterableSet = mutableSetOf("item1", "item2", "item3")
    println("Original set for iterator: $iterableSet")

    val iterator = iterableSet.iterator()
    while (iterator.hasNext()) {
        val item = iterator.next()
        if (item == "item2") {
            iterator.remove()
        }
    }
    println("After iterator removal: $iterableSet")

    println("\n-------------------------- Set Types --------------------------")
    println("HashSet (unordered): ${hashSetOf("z", "a", "x", "b")}")
    println("LinkedHashSet (insertion-ordered): ${linkedSetOf("z", "a", "x", "b")}")
    println("SortedSet (naturally ordered): ${sortedSetOf("z", "a", "x", "b")}")

    println("\n-------------------------- Specialized Builder --------------------------")
    val builtSet = buildSet {
        add("first")
        add("second")
        addAll(listOf("third", "fourth"))
        add("second")  // Will be ignored as duplicate
    }
    println("Built set: $builtSet")
}