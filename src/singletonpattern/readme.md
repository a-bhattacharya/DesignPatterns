Note: Many programmers tend to refrain from the singleton pattern and think it's a bad idea.

Here's why.
This pattern provides a **global access point** to that instance. This is an obvious **code smell**.

**Singletons vs. Single Responsibility Principle**

Singleton generally comes from the fact that it breaks the SRP. A singleton has two responsibilities:
1. Manage the creation of the instance of the class
2. Do something that is the original responsibility of the class

Singleton should also manage the access to the instance, more precisely when several threads request access\
to one instance; singleton should take responsibility for dispatching data to each request in threads by using locks\
to prevent **race conditions** or handling read and write to deliver valid data instead of an invalidated data.

**Singletons vs. Open/Close**

Singletons break the Open/Closed Principle because the singleton class is in control over the creation of its instance,\
while consumers will typically have a hard dependency on its concrete instance.\
This disallows the implementation to be changed without having to make sweeping changes throughout the application.\

**Singletons vs. Dependency Inversion Principles**

The biggest problem is here, violating DIP. Because consumers will always depend directly on the concrete class to get\
the instance, while the DIP prescribes the use of abstractions, this causes the Singleton implementation to be dragged\
along and disallows adding cross-cutting concerns by wrapping the implementation in a decorator or distributing\
the client without that singleton implementation.

> Question: Can a singleton implement an interface to solve this problem?\
> Answer: No, instance property would still be defined on the static class, which causes the DIP to be violated again.

**How does Singleton Affect Testing?**

This increased coupling due to the Singleton design pattern makes creating Mocks and Stubs during unit tests tricky.

In unit testing, each unit test should be independent of one another.\
Another reason the Singleton design pattern makes life difficult in unit testing is that they remain alive in the\
application. Hence they persist in the state as long as the application remains in the memory.

Credits: [Use Singleton Pattern Or Not?](https://medium.com/divar-mobile-engineering/use-singleton-pattern-or-not-282b197a2e9f)