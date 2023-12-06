/**
 *  1. Loose coupling. The Observable WeatherData class is not aware of the implementations of the Observers.
 *     It maintains a list of observers and each time data is updated it iterates through the list of observers
 *     and calls the update method on each. Similarly, the observers also do not access the state of observable
 *     directly.
 *     New observers can be added dynamically.
 *     Changes to observable or observers will not affect the other.
 *
 *     In contrast, consider the following tightly coupled implementation:
 *
 *     fun measurementsChanged() {
 *         observer1.update()
 *         observer2.update
 *         ...
 *     }
 *
 *     Note: The observers can have different implementations, which is why this is of more significance.
 *
 *  2. Programming to an interface. The observers can have different implementations. They can implement Display
 *     interfaces like in this package or could also implement a completely different interface. But they must implement
 *     the Observer interface.
 *
 *  Also note, in this example the observable pushes state update to all its observers. There could be different
 *  implementations of this. For example, it could push a global state map to each observer and then the observers could
 *  fetch the state they need.
 *  For a scenario where state changes are frequent because the inherent data always fluctuates but not significantly,
 *  we could use a boolean to track a threshold of change and only then push updates.
 *
 *  There is also an approach where observers pull state from the observable. This allows the observers to be selective
 *  about the state update while being loosely coupled. In this case, each property of the observable would be exposed
 *  through a public getter. Or there could be a getter for a map of the entire state. The observers could then
 *  call this getter. In this case, the notifyObservers() method could send a boolean to convey that state has changed.
 */

package com.designpatterns.observerpattern
class WeatherData() : Observable {

    private val observers = mutableListOf<Observer>()
    private var temperature: Float = 0F
    private var humidity: Float = 0F
    private var pressure: Float = 0F
    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        observers.forEach { observer: Observer -> observer.update(temperature,humidity,pressure)  }
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

    fun measurementsChanged() {
        notifyObservers()
    }
}