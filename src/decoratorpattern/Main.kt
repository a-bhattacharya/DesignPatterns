/**
 * The decorator pattern provides an introductory illustration the open-closed principle of SOLID
 */

package com.designpatterns.decoratorpattern

fun main() {
    val beverages = mutableListOf<Beverage>()
    beverages.add(Espresso())
    beverages.add(HouseBlend())
    beverages.add(Mocha(HouseBlend()))
    beverages.add(Whip(Espresso()))
    beverages.add(Whip(Mocha(Espresso())))

    computeTotalCost(beverages)
}

fun computeTotalCost(bevs: List<Beverage>) {
    var totalCost: Double = 0.0
    bevs.forEach {
        beverage ->
        run {
            println(String.format("%-30s$%s", beverage.description, "${beverage.cost()}"))
            totalCost+=beverage.cost()
        }
    }
    println(String.format("%-30s%s", "Total cost:", "$$totalCost"))
}