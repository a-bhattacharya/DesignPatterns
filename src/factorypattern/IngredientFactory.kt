package com.designpatterns.factorypattern

/**
 * Abstract factory
 */

interface IngredientFactory {
    fun createDough(): String
    fun createSauce(): String
}

class NYIngredientFactory : IngredientFactory {
    override fun createDough() = "Thin Crust"

    override fun createSauce() = "Marinara"

}

class ChicagoIngredientFactory : IngredientFactory {

    override fun createDough() = "Extra Thick Crust Dough"

    override fun createSauce() = "Plum Tomato"
}