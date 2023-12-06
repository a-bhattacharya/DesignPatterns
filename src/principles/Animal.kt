/** Program to an interface not an implementation */

package com.designpatterns.principles

abstract class Animal {
    abstract fun makeSound()
}

class Dog(val name: String) : Animal() {
    override fun makeSound() {
        println("$name barks!")
    }
}

class Cat(val name: String) : Animal() {
    override fun makeSound() {
        println("$name meows!")
    }
}

fun main() {
    val d1: Dog = Dog("Tom")
    d1.makeSound()
    /* This is not programming to an interface (programming to a supertype) as the actual runtime
    * object is not that of an interface/class
    */

    val c1: Animal = Cat("Clifford")
    c1.makeSound()
    /* Here the object is that of the supertype, hence this adheres to "programming to an interface" */

    val a = getAnimal(Animals.Cat, "Jack")
    a.makeSound()
    /* This is a better use-case and the benefit of programming to an interface is more evident here.
    * The return-type of the function getAnimal() is Animal which is the supertype. If a supertype
    * was not used, it would have to be denoted as a union of the classes Dog and Cat. Also,
    * irrespective of the type of animal returned, it definitely has the method makeSound().
    */
}

enum class Animals {
    Dog, Cat
}

fun getAnimal(animal: Animals, name: String): Animal {
    return when (animal) {
        Animals.Dog -> Dog(name)
        Animals.Cat -> Cat(name)
    }
}