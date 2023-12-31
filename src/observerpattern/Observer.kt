package com.designpatterns.observerpattern

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}