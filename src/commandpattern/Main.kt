package com.designpatterns.commandpattern

fun main() {
    val bedroomLight = Light("Bedroom")
    val kitchenLight = Light("Kitchen")
    val fan = CeilingFan()
    val stereo = Stereo()

    val bedroomLightOnCommand = LightOnCommand(bedroomLight)
    val bedroomLightOffCommand = LightOffCommand(bedroomLight)

    val kitchenLightOnCommand = LightOnCommand(kitchenLight)
    val kitchenLightOffCommand = LightOffCommand(kitchenLight)

    val fanOnCommand = CeilingFanOnCommand(fan)
    val fanOffCommand = CeilingFanOffCommand(fan)

    val stereoOnCommand = StereoOnCommand(stereo)
    val stereoOffCommand = StereoOffCommand(stereo)

    val allLightsOnCommand = MacroCommand(commands = mutableListOf(bedroomLightOnCommand, kitchenLightOnCommand))
    val allLightOffCommand = MacroCommand(mutableListOf(bedroomLightOffCommand, kitchenLightOffCommand))

    val remoteControl = RemoteControl()
    remoteControl.setCommand(0, bedroomLightOnCommand, bedroomLightOffCommand)
    remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand)
    remoteControl.setCommand(2, fanOnCommand, fanOffCommand)
    remoteControl.setCommand(3, stereoOnCommand, stereoOffCommand)
    remoteControl.setCommand(4, allLightsOnCommand, allLightOffCommand)

    println(remoteControl)

    remoteControl.pushOn(0)
    remoteControl.pushOn(1)
    remoteControl.pushOn(3)
    remoteControl.pushOn(2)
    remoteControl.pushOff(1)
    remoteControl.pushOff(3)
    remoteControl.pushUndo()

    remoteControl.pushOn(4)
    remoteControl.pushOff(4)
    remoteControl.pushUndo()
}