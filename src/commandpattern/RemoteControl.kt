package com.designpatterns.commandpattern

/**
 * The remote control has a modular design and has 3 columns.
 * The first column consists of slots where we can plug in controllers for the appliances.
 * We can swap and remove controllers as well.
 * The next column consists of on buttons for each of the controllers.
 * The third column has off buttons.
 * There is a single undo button on the remote that undoes the last action.
 */
class RemoteControl(
    val slots: Int = 7,
    val onCommands: MutableList<Command> = MutableList(slots) { NoCommand() },
    val offCommands: MutableList<Command> = MutableList(slots) { NoCommand() },
    var undoCommand: Command = NoCommand(),
) {
    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun pushOn(slot: Int) {
        onCommands[slot].execute()
        undoCommand = onCommands[slot]
    }

    fun pushOff(slot: Int) {
        offCommands[slot].execute()
        undoCommand = offCommands[slot]
    }

    fun pushUndo() {
        undoCommand.undo()
    }

    override fun toString(): String {
        val res = StringBuilder()
        res.append("--- Remote Control ---\n")
        for (i in 0 until slots) {
            res.append("[$i] ${onCommands[i]::class.simpleName}  ${offCommands[i]::class.simpleName}\n")
        }
        return res.toString()
    }
}