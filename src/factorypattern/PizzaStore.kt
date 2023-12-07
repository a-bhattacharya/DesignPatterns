package com.designpatterns.factorypattern

abstract class PizzaStore {
    open fun orderPizza(type: String): Pizza {
        val pizza: Pizza = createPizza(type) // dealing with the abstract class Pizza
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    abstract fun createPizza(type: String): Pizza // abstract factory method
}

class NYStylePizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> NYStyleCheesePizza()
            "veggie" -> NYStyleVeggiePizza()
            "clam" -> NYStyleClamPizza() // this is using abstract factory to create the pizza internally.
//            We could pass an ingredient factory into the clam pizza from this class as well
            else -> throw IllegalArgumentException("Invalid pizza type: $type")
        }
    }
}

class ChicagoStylePizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> ChicagoStyleCheesePizza()
            "veggie" -> ChicagoStyleVeggiePizza()
            "clam" -> ChicagoClamPizza() // internally using abstract factory
            else -> throw IllegalArgumentException("Invalid pizza type: $type")
        }
    }

}