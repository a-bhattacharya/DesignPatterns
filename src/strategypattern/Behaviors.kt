/**
 * This is the file where we establish principle 1, i.e. 'encapsulate what varies'
 * These are a family of algorithms (behaviors) which are encapsulated in classes and are interchangeable
 * since they all implement common interface - IFly and IQuack.
 * The algorithms can vary independently from clients that use them, in this case 'SDuck'
 */
package com.designpatterns.strategypattern

interface IFly {
    fun fly()
}

interface IQuack {
    fun quack()
}

class FlyWithWings : IFly {
    override fun fly() {
        println("Flap! Flap!")
    }
}

class NoFly : IFly {
    override fun fly() {
        println("Cannot fly!")
    }
}

class Quack : IQuack {
    override fun quack() {
        println("Quack! Quack!")
    }
}

class Squeak : IQuack {
    override fun quack() {
        println("Squeak! Squeak!")
    }
}

class NoQuack : IQuack {
    override fun quack() {
        println("Cannot quack!")
    }
}