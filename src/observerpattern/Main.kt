/**
 * The Observer Pattern defines a one-to-many dependency between objects so that when one object (subject/observable)
 * changes state, all of its dependencies are notified and updated automatically.
 *
 * This pattern makes use of loose coupling. (@see WeatherData)
 * Encapsulate what varies. State of the Observable and number of observers vary. We can vary the observers that depend
 * on the state of the observable without having to change the observable.
 * Composition. Observable HAS observers. Observers HAVE observable.
 *
 */

package com.designpatterns.observerpattern

import kotlin.random.Random
import kotlinx.coroutines.delay

suspend fun main() {
    val weatherData = WeatherData()
    val currentConditionsDisplay = CurrentConditionsDisplay(weatherData)
    val statsDisplay = StatsDisplay(weatherData)

    var counter = 0
    while (true) {
        counter++

        if(counter == 10) break
        if (counter == 6) statsDisplay.deregister()

        val (temp, hum, pressure) = getRandomData()
        weatherData.setMeasurements(temp, hum, pressure)
        println()
        delay(3000)
    }
}

fun getRandomData(): Triple<Float, Float, Float> {
    val temperature = Random.nextFloat() * 100 - 50 // Random temperature between -50 and 50
    val humidity = Random.nextFloat() * 100 // Random humidity between 0 and 100
    val pressure = Random.nextFloat() * 0.2F + 0.9F // Random pressure between 0.9 and 1.1

    return Triple(temperature, humidity, pressure)
}