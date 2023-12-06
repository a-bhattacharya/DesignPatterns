/**
 * Things to note about the observer implementations:
 * 1. They always implement Observer interface along with any other relevant interface.
 * 2. They contain a reference to the observable for registering and de-registering themselves. This can also be used
 *    for the state pull implementation.
 */

package com.designpatterns.observerpattern

import kotlin.math.max
import kotlin.math.min

interface DisplayElement {
    fun display()
}

class CurrentConditionsDisplay(val weatherData: WeatherData) : Observer, DisplayElement {
    init {
        weatherData.registerObserver(this)
    }
    private var temperature: Float = 0F
    private var humidity: Float = 0F
    private var pressure: Float = 0F
    override fun display() {
        println("Current conditions: $temperature degrees and humidity $humidity ")
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temp
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    fun deregister() {
        weatherData.removeObserver(this)
    }

}

class StatsDisplay(val weatherData: WeatherData) : Observer, DisplayElement {

    init {
        weatherData.registerObserver(this)
    }
    private var temperature: Float = 0F
    private var humidity: Float = 0F
    private var pressure: Float = 0F

    private var maxTemp = temperature
    private var minTemp = temperature
    private var sumTemp = 0F
    private var numReadings = 0
    private var avgTemp = 0F
    override fun display() {
        println("Avg/max/min temperature: $avgTemp/$maxTemp/$minTemp")
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temp
        this.humidity = humidity
        this.pressure = pressure
        tempCalculations()
        display()
    }

    fun tempCalculations() {
        numReadings++
        sumTemp+=this.temperature
        maxTemp = max(this.temperature, maxTemp)
        minTemp = min(this.temperature, minTemp)
        avgTemp = sumTemp / numReadings
    }

    fun deregister() {
        println("$this deregistered from $weatherData")
        weatherData.removeObserver(this)
    }

}