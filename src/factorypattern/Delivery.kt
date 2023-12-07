package com.designpatterns.factorypattern

abstract class DeliveryPartner() {
    abstract fun deliver(pizza: Pizza): Pizza
}

class DominosDeliveryPartner() : DeliveryPartner() {
    override fun deliver(pizza: Pizza): Pizza {
        println("Delivering ${pizza.name} with Domino's 30 minute guarantee!")
        return pizza
    }

}