package com.designpatterns.factorypattern

abstract class Pizza(
    var name: String,
    val dough: String,
    val sauce: String,
    val toppings: List<String>,
) {
    fun prepare() {
        println("Preparing $name...")
        println("Tossing dough...")
        println("Adding $sauce sauce...")
        println("Adding toppings...")
        println(toppings.joinToString(", "))
    }

    open fun bake() {
        println("Baking for 25 minutes at 350 F")
    }

    open fun cut() {
        println("Cutting pizza into triangular slices...")
    }

    open fun box() {
        println("Packing pizza in box...")
    }
}

class NYStyleCheesePizza() : Pizza(
    name = "NY Style Sauce and Cheese Pizza",
    dough = "Thin Crust",
    sauce = "Marinara",
    toppings = listOf("Grated Reggiano Cheese")
)

class ChicagoStyleCheesePizza : Pizza(
    name = "Chicago Style Deep Dish Cheese Pizza",
    dough = "Extra Thick Crust Dough",
    sauce = "Plum Tomato",
    toppings = listOf("Shredded Mozzarella Cheese")
) {
    override fun cut() {
        println("Cutting pizza into square slices...")
    }
}

class NYStyleVeggiePizza : Pizza(
    name = "NY Style Veggie Pizza",
    dough = "Thin Crust",
    sauce = "Marinara",
    toppings = listOf("Grated Reggiano Cheese", "Mushrooms", "Onions", "Red Peppers")
)

class ChicagoStyleVeggiePizza : Pizza(
    name = "Chicago Style Deep Dish Veggie Pizza",
    dough = "Thick Cheese-Filled Dough",
    sauce = "Plum Tomato",
    toppings = listOf("Grated Mozzarella", "Grated Parmesan", "Eggplant", "Black Olives")
) {
    override fun cut() {
        println("Cutting pizza into square slices...")
    }
}

/*
    The following two make use of abstract factory. Note how the final product class (pizza) is composing
    an abstract factory inside.
 */
class NYStyleClamPizza(ingFactory: IngredientFactory = NYIngredientFactory()) : Pizza(
    name = "NY Style Clam Pizza",
    dough = ingFactory.createDough(),
    sauce = ingFactory.createSauce(),
    toppings = listOf("Reggiano", "Fresh Clams")
)

class ChicagoClamPizza(ingFactory: IngredientFactory = ChicagoIngredientFactory()) : Pizza(
    name = "Chicago Style Clam Pizza",
    dough = ingFactory.createDough(),
    sauce = ingFactory.createSauce(),
    toppings = listOf("Mozzarella", "Parmesan", "Clams")
) {
    override fun cut() {
        println("Cutting pizza into square slices...")
    }
}