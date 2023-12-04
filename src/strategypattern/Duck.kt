/**
 * Illustrates principle 2, i.e. 'favor composition over inheritance'.
 * The SDuck class HAS flying behaviors and quacking behaviors as opposed to encapsulating these behaviors within
 * itself and then each subclass having to override it accordingly.
 */

package com.designpatterns.strategypattern

enum class DuckTypes {
    MallardDuck, RedheadDuck, RubberDuck, DecoyDuck
}

open class SDuck(
    val duckType: DuckTypes,
    private var flyBehavior: IFly = FlyWithWings(),
    private var quackBehavior: IQuack = Quack(),
) { // Superclass Duck

    open fun display() {
        println("Displaying ${duckType}...")
    }

    open fun swim() {
        println("Swimming...")
    }

    open fun performQuack() {
        quackBehavior.quack()
    }

    open fun performFly() {
        flyBehavior.fly()
    }

    fun setFlyBehavior(flyBehavior: IFly) {
        this.flyBehavior = flyBehavior
    }

    fun setQuackBehavior(quackBehavior: IQuack) {
        this.quackBehavior = quackBehavior
    }
}

class MallardDuck : SDuck(DuckTypes.MallardDuck) {
    override fun display() {
        println("This is a ${duckType}!")
    }
}

class RedheadDuck : SDuck(DuckTypes.RedheadDuck)

class RubberDuck : SDuck(DuckTypes.RubberDuck, flyBehavior = NoFly(), quackBehavior = Squeak()) {
    override fun display() {
        println("I am yellow!")
    }
}

class DecoyDuck : SDuck(DuckTypes.DecoyDuck, flyBehavior = NoFly(), quackBehavior = NoQuack()) {
    override fun swim() {
        println("Error! Will drown!")
    }
}