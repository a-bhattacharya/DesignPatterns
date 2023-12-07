/**
 * An example to illustrate combination of Strategy Pattern and Factory Pattern
 */

package com.designpatterns.factorypattern

abstract class PizzaStoreWithDelivery(val deliveryPartner: DeliveryPartner) : PizzaStore() {
    // already has an abstract fun createPizza()
    override fun orderPizza(type: String): Pizza {
        var pizza: Pizza = createPizza(type)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        pizza = deliveryPartner.deliver(pizza)
        return pizza
    }
}

class DominosPizzaStore() : PizzaStoreWithDelivery(deliveryPartner = DominosDeliveryPartner()) {

    val nyIngFactory = NYIngredientFactory()
    val chicagoIngFactory = ChicagoIngredientFactory()
    override fun createPizza(type: String): Pizza {
        val pizza = when (type) {
            "nycheese" -> NYStyleCheesePizza()
            "nyveggie" -> NYStyleVeggiePizza()
            "nyclam" -> NYStyleClamPizza(ingFactory = nyIngFactory)
            "chcheese" -> ChicagoStyleCheesePizza()
            "chveggie" -> ChicagoStyleVeggiePizza()
            "chclam" -> ChicagoClamPizza(ingFactory = chicagoIngFactory)
            else -> throw IllegalArgumentException("Invalid pizza type: $type")
        }
        pizza.name = "Domino's " + pizza.name
        return pizza
    }

}