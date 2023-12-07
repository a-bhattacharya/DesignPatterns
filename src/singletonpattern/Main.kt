/**
 * Note: Many programmers tend to refrain from the singleton pattern and think it's a bad idea.
 *
 * Here's why.
 *  This pattern provides a global access point to that instance. This is an obvious code smell.
 *
 *  Singletons vs. Single Responsibility Principle
 *
 *      Singleton generally comes from the fact that it breaks the SRP. A singleton has two responsibilities:
 *
 *        -  Manage the creation of the instance of the class
 *        -  Do something that is the original responsibility of the class
 *
 *  Singletons vs. Open/Close
 *
 *      Singletons break the Open/Closed Principle because the singleton class is in control over the creation of its
 *      instance, while consumers will typically have a hard dependency on its concrete instance.
 *      This disallows the implementation to be changed without having to make sweeping changes throughout the
 *      application.
 *
 */

package com.designpatterns.singletonpattern
import singletonpattern.SingletonJava


fun main() {
    val singletonJava = SingletonJava.getInstance()
    println(singletonJava.state)

    val singleton = Singleton.getInstance()
    println(singleton.state)
    singleton.state = "changed"
    println(singleton.state)
    val singleton2 = Singleton.getInstance()
    println(singleton2.state)

    println(SingletonKotlinWay.state)

}