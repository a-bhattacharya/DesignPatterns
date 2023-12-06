/**
 * Encapsulating what varies. The number of condiments and the method to calculate cost.
 * Using composition.
 */

package com.designpatterns.decoratorpattern

/*
    Every condiment IS-A Beverage so that any beverage wrapped with a condiment is still a beverage
 */
abstract class CondimentDecorator : Beverage() {
    abstract override val description: String // To extend the description
}

class Mocha(val beverage: Beverage) : CondimentDecorator() { // Every condiment HAS-A Beverage to extend behavior

    override val description: String
        get() = "${beverage.description} Mocha"

    override fun cost(): Double { // cost() from Beverage abstract class is being overridden here
        return beverage.cost() + .20
    }
}

class Whip(val beverage: Beverage) : CondimentDecorator() {
    override val description: String
        get() = "${beverage.description} Whip"

    override fun cost(): Double {
        return beverage.cost() + .15
    }

}