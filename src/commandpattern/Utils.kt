/**
 * Consider that these were provided by vendors of smart home appliances.
 */

package com.designpatterns.commandpattern


class Light(val location: String) {
    fun on() {
        println("$location light turned on!")
    }

    fun off() {
        println("$location light turned off!")
    }
}



class CeilingFan {

    var speed: Int? = null
    fun high() {
        speed = 10
        println("Fan on. Speed: $speed")
    }

    fun medium() {
        speed = 6
        println("Fan on. Speed: $speed")
    }

    fun low() {
        speed = 3
        println("Fan on. Speed: $speed")
    }

    fun off() {
        speed = 0
        println("Fan off.")
    }
}

class Stereo {

    var volume: Int = 0
        set(value) {
            field = value
            println("Volume $value")
        }
    fun on() {
        println("Stereo on!")
    }

    fun off() {
        println("Stereo off!")
    }

    fun insertCD() {
        println("CD inserted...")
    }

    fun resumePlayback() {
        println("Resuming playback with volume ${this.volume}")
    }

}