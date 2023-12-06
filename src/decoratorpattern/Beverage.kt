package com.designpatterns.decoratorpattern

/*
    Beverage could be an interface but let's assume this class already existed and we do not want to alter
    existing code.
 */
abstract class Beverage {
    abstract val description: String

/*
    Kotlin provides getters for val and getters and setters for var.
 */

//    fun getDescription(): String { // Illustrating already provided getters in Kotlin
//        return description
//    }

    abstract fun cost(): Double
}

class Espresso : Beverage() {
    override val description: String = "Espresso"

    override fun cost(): Double {
        return 1.99
    }
}

class HouseBlend : Beverage() {
    override val description: String = "House Blend Coffee"

    override fun cost(): Double {
        return .89
    }
}