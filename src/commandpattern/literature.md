> The Command Pattern encapsulates a request as an object, thereby allowing parameterization of other objects with\
different requests, queue and log requests and support undoable operations.

Breakdown:

Command object implement a command interface. This mainly has an `execute()` method but can also have\
an `undo()` method.

Each command object's execute is responsible for doing something specific with the receiver that it composes.\
Example: A LightOn command object can have different lights as receivers but its `execute` method has one job.\
To turn the lights on.

So the request "turn light on" is encapsulated in a command object.

We can parameterize **invoker** objects with command objects.\
For example: The remote control (invoker) has a `setCommand()` method.

The **Meta Command Pattern** supports macros of commands.

**Note:** In general, we strive for 'dumb' command objects, which mostly invoke certain actions on the\
receiver in order.\
But there can also be 'smart' command objects that can implement a lot of the logic\
for carrying out a request. But these increase coupling.

Some popular uses:
1. In queues and scheduling: A queue of command objects.
2. Logging requests.
