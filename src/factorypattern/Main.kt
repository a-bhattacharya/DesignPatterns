/**
 * The factory pattern helps us close our code for modification by reducing dependency on concrete implementations.
 * In this example, the orderPizza() method of pizza store decides which concrete implementation of pizza to give
 * based on the type.
 * It is encapsulating object creation. So when the implementation of object creation changes, for example new pizzas
 * are added or some items are removed, we have only one place to make modifications to.
 */

package com.designpatterns.factorypattern

fun main() {
    val nyStore: PizzaStore = NYStylePizzaStore()
    val chicagoStore: PizzaStore = ChicagoStylePizzaStore()

    val nyCheesePizza: Pizza = nyStore.orderPizza("cheese")
    println("One NY Cheese Pizza ordered!\n")

    val chicagoVeggiePizza : Pizza = chicagoStore.orderPizza("veggie")
    println("One Chicago Veggie pizza ordered!\n")

    val nyClamPizza : Pizza = nyStore.orderPizza("clam") // abstract factory
    println("One NY Clam Pizza ordered!\n")

    val dominosStore : PizzaStore = DominosPizzaStore() // combination of patterns
    val nyDomCheesePizza = dominosStore.orderPizza("nyveggie")
}