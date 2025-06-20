package intermediate

open class Money

class Coin : Money()

class CurrencyNote : Money()

open class Product

open class Stationary : Product()

class NoteBook : Stationary()

class Pencil : Stationary()

open class Snack : Product()

class FriedItems : Snack()

class Chocolate : Snack()

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun covariance() {
    val coins: List<Coin> = listOf(Coin(), Coin())
    val notes: List<CurrencyNote> = listOf(CurrencyNote(), CurrencyNote())
    val moneys: List<Money> = coins
}

fun contravariance() {

}

fun invariance() {
    val coins: MutableList<Coin> = mutableListOf(Coin(), Coin())
    // val moneys: MutableList<Money> = coins // ERROR

}

// Contract of Interface: VendingMachine will accept any coin and return some kind of snack.
/*
 * The interface defines the contract boundary (what types are accepted/returned), but each implementation provides predictable behavior within that boundary.
 * "Some kind of" = predictable, consistent behavior from each implementation
 * "Any kind of" = unpredictable, chaotic behavior that breaks the contract's usefulness
 */
interface VendingMachine {
    val purchaseProperty: (Coin) -> Snack

    fun purchase(money: Coin): Snack
}

class ChocolateVendingMachine : VendingMachine {
    override fun purchase(money: Coin): Chocolate = Chocolate()

//     override fun purchase(money: Money): Chocolate = Chocolate() // ERROR due to overloading

    override val purchaseProperty: (Money) -> Snack = { Chocolate() } // Contravariance
}

fun main() {
    val shape1: Shape = Shape()
    val shape2: Circle = Circle()
    var shape3: Rect = Rect()

    val shapeBox1: ShapeBox<Shape> = ShapeBox()
    val shapeBox2: ShapeBox<Circle> = ShapeBox()

    val shapeX: Shape = shape3
    val shapeBoxX: ShapeBox<Shape> = shapeBox2
}

class ShapeBox<T: Shape>(
    val shape1: T? = null,
    val shape2: T? = null,
    var shape3: T? = null,
) {
    fun takeShapesOut(): T? {
        return null
    }
}

open class Shape {
    fun drawShape() {

    }
}

open class NoSideShape: Shape() {

}

open class SideShape: Shape() {

}

open class Circle: NoSideShape() {

}

open class Oval: NoSideShape() {

}

open class Square: SideShape() {

}

open class Rect: SideShape() {

}

