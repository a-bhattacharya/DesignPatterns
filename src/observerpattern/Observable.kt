package com.designpatterns.observerpattern

interface Observable {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}
