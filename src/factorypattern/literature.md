# The Factory Pattern

The factory pattern helps us close our code for modification by reducing dependency on concrete implementations.

In this example, the `orderPizza()` method of pizza store decides which concrete implementation of pizza to give
based on the type.\
It is encapsulating object creation.\
So when the implementation of object creation changes, for example new pizzas
are added or some items are removed,\
we have only one class to make modifications to.

This example skips **Simple Factory Method** since it is more like a programming idiom.\
It *delegates the object creation at two levels*.\
It has some similarities to **Abstract Factory Pattern** which this example has explored.

### Simple Factory

Before delving into the factory pattern, a brief look into the Simple Factory.

Consider only one Factory class. This would suffice for scenarios where there is not much variation in the product
implementations.\
We could also have multiple factories based on some classification of products at a higher level, for example,
regional pizzas.\
So we would have concrete pizza factories, like ChicagoFactory, New York Factory,
implementing a common factory interface.\
Then we have one universal pizza store class that composes one/multiple
factories and these factories would return the pizza object.\
Then the store can continue preparing the pizza,
bake, cut, etc. This is a perfectly sound approach.

### Factory

The factory pattern differs from simple factory in one main realm. Inheritance v. object composition.\
In simple factory, there is a factory object which is responsible for creation of the product (pizza).\
In the factory pattern, the factory class takes on a single responsibility of creation of the product.\
It does this by specifying an abstract create method that is implemented by the factory subclasses.\
The base factory class however has methods that perform actions on the created product, and it does this without\
knowing the concrete implementations of the product.

**The factory method pattern defines an interface for creating an object but defers instantiation to subclasses.**

## The Dependency Inversion Principle

The principle suggests that high-level components should not depend on low-level components.\
Rather, both high and low level components should depend on abstractions.

This at first might sound similar to:
> Program to an interface, not an implementation.

But this principle is a stronger statement because it negates the perception of a top-down concrete\
hierarchy completely.

Pizzas are low-level components that implement the Pizza abstraction/interface.\
The PizzaStore is a high-level component. If we were to not use factory, the high-level component\
would be responsible for instantiating concrete Pizza classes. But using factory method, PizzaStore\
no longer has to care about any concrete Pizza implementations. It can simply work with the Pizza abstraction.

#### Guidelines on using the principle

1. No variables should hold reference to concrete classes.
2. No class should derive from a concrete class.
3. Methods should not override implemented method of base class. (Take this one with a grain of salt)

**Note:** These are just guidelines to strive for, not rules to be followed!

### Abstract Factory

It is like a factory of factories.

- Uses object composition instead of inheritance to create.
- Useful for grouping together a family of products that need to be created together.
- Drawback: Interface needs to change to add new products.
- Main difference with factory lies in the fact that factory is typically concerned with creation of a single product.