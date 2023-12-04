/**
 * The 'strategy pattern' is majorly about two core principles of OO design.
 *  1. Encapsulate what varies.
 *  2. Favor composition over inheritance. (HAS-A better than IS-A)
 *
 * Along with this we can also see adherence to a third very important principle.
 *  3, Program to an interface instead of an implementation.
 */
package com.designpatterns.strategypattern

fun main() {
    val mallardDuck = MallardDuck()
    val redheadDuck = RedheadDuck()
    val rubberDuck = RubberDuck()
    val decoyDuck = DecoyDuck()

    val ducks = listOf(mallardDuck, redheadDuck, rubberDuck, decoyDuck)

    for (duck in ducks) {
        doDuckStuff(duck)
    }
}

fun doDuckStuff(duck: SDuck) { // duck: SDuck -> principle 3
    duck.display()
    duck.swim()
    duck.performFly()
    duck.performQuack()
    println()
}