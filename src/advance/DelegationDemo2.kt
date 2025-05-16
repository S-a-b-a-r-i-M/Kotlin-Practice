package advance

import java.util.LinkedList

// Context
/*
Let’s say we want a list’s item to be recoverable after deletion. To achieve this, we need to implement
MutableList, override the remove function, and create our own recover function. But to do this, we need to
override other methods that the MutableInterface tells us. So we essentially need to create our own
implementation of MutableList. That’s not a cool thing to do as all the code is already written for us.

To avoid creating our own list, we can extend ArrayList instead. But this approach is not good for abstraction.
We don’t want this list to be an ArrayList. We don’t need ArrayList's specific methods like trimToSize, ensureCapacity, grow, etc.
We just want to have an additional function.

So there is a better way to achieve this. And this is delegation.
We want to have only MutableList's functions overridden by ArrayList and our own implementation of remove.
 */

// Reasoning for above context
/*
When they say "this approach is not good for abstraction," they're referring to a fundamental principle in
object-oriented design: a class should expose only what's necessary for its intended purpose and hide implementation details.
By extending ArrayList, they would be creating what's called "is-a" relationship.
Their RecoverableList would be an ArrayList, which brings several problems.

Why "Delegation" Is Better:
Delegation creates a "has-a" relationship instead. Your RecoverableList has a list implementation,
but it only exposes the methods defined in the MutableList interface, plus your custom methods.
This keeps the abstraction clean - users know they're working with a list that can recover items,
without any implementation details leaking through.
This is a perfect example of the principle "Program to an interface, not an implementation" which helps
create more maintainable and flexible code.
 */

class RecoverableList<T> (
    private val delegateList: MutableList<T> = ArrayList<T>()
): MutableList<T> by delegateList {
    val deletedElements = LinkedList<T>() // Using as a queue

    private fun addElementToTrash(element: T) {
        if (deletedElements.size >= 10)
            deletedElements.pop()

        deletedElements.add(element)
    }

    override fun remove(element: T): Boolean {
        if (delegateList.remove(element)){
            addElementToTrash(element)
            return true
        }

        return false
    }

    fun recoverRecentElement(): T? = if(deletedElements.isEmpty()) null else deletedElements.removeLast()

    fun recoverAll(): List<T> = TODO("Neram vara villai")
}

fun main() {
    val recoverableList = RecoverableList<Int>()
    recoverableList.add(10)
    recoverableList.add(20)
    recoverableList.add(30)

    recoverableList.remove(20)
    println("After removed 20 from list: ${recoverableList.joinToString()}")

    val deletedElement = recoverableList.recoverRecentElement()
    if (deletedElement != null){
        recoverableList.add(deletedElement)
        println("After recovery: ${recoverableList.joinToString()}")
    }
}