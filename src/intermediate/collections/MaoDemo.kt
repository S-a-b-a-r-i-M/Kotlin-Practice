package intermediate.collections

fun main() {
    println("=== IMMUTABLE MAP OPERATIONS ===\n")
    demonstrateImmutableMapOperations()

    println("\n=== MUTABLE MAP OPERATIONS ===\n")
    demonstrateMutableMapOperations()
}

fun demonstrateImmutableMapOperations() {
    println("\n-------------------------- Creating Maps --------------------------")
    val emptyMap = mapOf<String, Int>()
    val singleEntryMap = mapOf("apple" to 1)
    val fruitMap = mapOf(
        "apple" to 10,
        "banana" to 15,
        "cherry" to 20
    )

    // Alternative creation methods
    val fruitMapUsingPairs = mapOf(
        Pair("apple", 10),
        Pair("banana", 15),
        Pair("cherry", 20)
    )

    println("Original map: $fruitMap")
    println("Map using Pairs: $fruitMapUsingPairs")

    println("\n-------------------------- Basic Properties --------------------------")
    println("Size: ${fruitMap.size}")
    println("Is empty: ${fruitMap.isEmpty()}")
    println("Keys: ${fruitMap.keys}")
    println("Values: ${fruitMap.values}")
    println("Entries: ${fruitMap.entries}")

    println("\n-------------------------- Accessing Elements --------------------------")
    println("Value for key 'apple': ${fruitMap["apple"]}")  // Using indexing operator
    println("Value for key 'apple': ${fruitMap.get("apple")}")  // Using get() function
    println("Value for key 'grape' (doesn't exist): ${fruitMap["grape"]}")  // Returns null
    println("Value for key 'grape' or default: ${fruitMap.getOrDefault("grape", 0)}")
    println("Value for key 'grape' or compute: ${fruitMap.getOrElse("grape") { 0 }}")

    println("\n-------------------------- Checking Contents --------------------------")
    println("Contains key 'banana': ${fruitMap.containsKey("banana")}")
    println("Contains value 20: ${fruitMap.containsValue(20)}")
    println("'apple' in map: ${"apple" in fruitMap}")  // Using 'in' operator
    println("'apple' in map: ${"apple" in fruitMap.keys}")  // Using 'in' operator

    println("\n-------------------------- Map Filtering --------------------------")
    println("Filtered by keys starting with 'b': ${fruitMap.filterKeys { it.startsWith("b") }}")
    println("Filtered by values > 10: ${fruitMap.filterValues { it > 10 }}")
    println("Filtered by entries where key length equals value/2: ${fruitMap.filter { it.key.length == it.value / 2 }}")

    println("\n-------------------------- Map Transformation --------------------------")
    println("Mapped keys to uppercase: ${fruitMap.mapKeys { it.key.uppercase() }}")
    println("Mapped values doubled: ${fruitMap.mapValues { it.value * 2 }}")
    println("Keys mapped to their length: ${fruitMap.keys.map { it.length }}")
    println("Flattened map entries to pairs: ${fruitMap.flatMap { listOf(it.key, it.value.toString()) }}")

    println("\n-------------------------- Map Merging --------------------------")
    val vegetableMap = mapOf("carrot" to 8, "banana" to 25)
    println("Map A: $fruitMap")
    println("Map B: $vegetableMap")

    // Using + operator - B values overwrite A values for duplicate keys
    println("Map A + Map B: ${fruitMap + vegetableMap}")

    println("\n-------------------------- Conversion --------------------------")
    println("To list of pairs: ${fruitMap.toList()}")
    println("To mutable map: ${fruitMap.toMutableMap()}")
    println("Keys to list: ${fruitMap.keys.toList()}")
    println("Values to list: ${fruitMap.values.toList()}")

    println("\n-------------------------- Aggregate Operations --------------------------")
    println("Max entry by value: ${fruitMap.maxByOrNull { it.value }}")
    println("Min entry by value: ${fruitMap.minByOrNull { it.value }}")
    println("Sum of values: ${fruitMap.values.sum()}")
    println("Average of values: ${fruitMap.values.average()}")
    println("All values > 5: ${fruitMap.all { it.value > 5 }}")
    println("Any value > 15: ${fruitMap.any { it.value > 15 }}")

    println("\n-------------------------- Grouping and Association --------------------------")
    val words = listOf("apple", "banana", "apricot", "cherry", "blueberry")
    println("Words list: $words")
    println("Grouped by first letter: ${words.groupBy { it.first() }}")
    println("Associated by first letter (keeping last): ${words.associateBy { it.first() }}")
    println("Associated with length: ${words.associate { it to it.length }}")

    println("\n-------------------------- Destructuring --------------------------")
    for ((key, value) in fruitMap) {
        println("Key: $key, Value: $value")
    }

    val (firstKey, firstValue) = fruitMap.entries.first()
    println("First entry destructured - Key: $firstKey, Value: $firstValue")
}

fun demonstrateMutableMapOperations() {
    println("\n-------------------------- Creating Mutable Maps --------------------------")
    val emptyMutableMap = mutableMapOf<String, Int>()
    val fruitMutableMap = mutableMapOf(
        "apple" to 10,
        "banana" to 15,
        "cherry" to 20
    )

    println("Original mutable map: $fruitMutableMap")

    println("\n-------------------------- Adding/Updating Elements --------------------------")
    fruitMutableMap["dragonfruit"] = 25  // Using indexing operator
    println("After adding 'dragonfruit': $fruitMutableMap")

    fruitMutableMap.put("elderberry", 30)  // Using put() function
    println("After putting 'elderberry': $fruitMutableMap")

    // Update existing value
    fruitMutableMap["apple"] = 12
    println("After updating 'apple': $fruitMutableMap")

    // Add or update with putAll
    fruitMutableMap.putAll(mapOf("fig" to 35, "banana" to 18))
    println("After putAll: $fruitMutableMap")

    println("\n-------------------------- Computed Updates --------------------------")
    // Add only if key not present
    fruitMutableMap.putIfAbsent("apple", 50)  // Won't update because key exists
    fruitMutableMap.putIfAbsent("grape", 40)  // Will add new entry
    println("After putIfAbsent: $fruitMutableMap")

    // Compute if present
    fruitMutableMap.computeIfPresent("banana") { _, value -> value + 5 }
    println("After computeIfPresent for 'banana': $fruitMutableMap")

    // Get or put default value
    val appleValue = fruitMutableMap.getOrPut("apple") { 100 }  // Gets existing value
    val kiwiValue = fruitMutableMap.getOrPut("kiwi") { 45 }     // Puts default value
    println("getOrPut 'apple' returned: $appleValue")
    println("getOrPut 'kiwi' returned: $kiwiValue")
    println("After getOrPut: $fruitMutableMap")

    println("\n-------------------------- Removing Elements --------------------------")
    val removedValue = fruitMutableMap.remove("banana")
    println("Removed 'banana', value was: $removedValue")
    println("After remove: $fruitMutableMap")

    // Remove entry only if it has specific value
    val wasRemoved = fruitMutableMap.remove("apple", 10)  // Won't remove if value doesn't match
    println("Tried to remove 'apple' with value 10, success: $wasRemoved")
    println("After conditional remove: $fruitMutableMap")

    // Remove by predicate
    fruitMutableMap.entries.removeIf { it.value > 30 }
    println("After removeIf value > 30: $fruitMutableMap")

    println("\n-------------------------- Clearing --------------------------")
    val tempMap = mutableMapOf("temp1" to 1, "temp2" to 2)
    println("Before clear: $tempMap")
    tempMap.clear()
    println("After clear: $tempMap")

    println("\n-------------------------- Map Specific Types --------------------------")
    println("HashMap (unordered): ${hashMapOf("z" to 1, "a" to 2, "x" to 3)}")
    println("LinkedHashMap (insertion order): ${linkedMapOf("z" to 1, "a" to 2, "x" to 3)}")
    println("SortedMap (key order): ${sortedMapOf("z" to 1, "a" to 2, "x" to 3)}")

    println("\n-------------------------- Iterator Operations --------------------------")
    val iterableMap = mutableMapOf("item1" to 1, "item2" to 2, "item3" to 3)
    println("Original map for iterator: $iterableMap")

    val iterator = iterableMap.entries.iterator()
    while (iterator.hasNext()) {
        val entry = iterator.next()
        if (entry.key == "item2") {
            iterator.remove()
        }
    }
    println("After iterator removal: $iterableMap")

    println("\n-------------------------- Specialized Builder --------------------------")
    val builtMap = buildMap {
        put("first", 1)
        put("second", 2)
        putAll(mapOf("third" to 3, "fourth" to 4))
    }
    println("Built map: $builtMap")
}