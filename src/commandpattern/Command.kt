package com.designpatterns.commandpattern

interface Command {
    fun execute()
    fun undo()
}

class LightOnCommand(val light: Light) : Command {
    override fun execute() {
        light.on()
    }

    override fun undo() {
        light.off()
    }
}

class LightOffCommand(val light: Light) : Command {
    override fun execute() {
        light.off()
    }

    override fun undo() {
        light.on()
    }
}

class CeilingFanOnCommand(val fan: CeilingFan) : Command {
    override fun execute() {
        fan.high()
    }

    override fun undo() {
        fan.off()
    }
}

class CeilingFanOffCommand(val fan: CeilingFan) : Command {
    override fun execute() {
        fan.off()
    }

    override fun undo() {
        fan.high()
    }
}

class StereoOnCommand(val stereo: Stereo) : Command {
    override fun execute() {
        stereo.on()
        stereo.insertCD()
        stereo.volume = 8
    }

    override fun undo() {
        stereo.off()
    }
}

class StereoOffCommand(val stereo: Stereo) : Command {
    override fun execute() {
        stereo.off()
    }

    override fun undo() {
        stereo.resumePlayback()
    }
}

class NoCommand : Command { // Creates null object. Can be default value for command so that we don't have to null check
    override fun execute() {}

    override fun undo() {}
}

class MacroCommand(val commands: MutableList<Command>) : Command {
    override fun execute() {
        commands.forEach { command: Command -> command.execute() }
    }

    override fun undo() {
        println("This app cannot undo macro commands yet!")
    }
}

