# Abstract Classes & Interfaces (Java)

---

## 1. Abstract Classes

### What is an abstract class?

* A class declared using the `abstract` keyword.
* It **may contain**:

  * Abstract methods (methods without a body)
  * Concrete (normal) methods
  * Instance variables
  * Constructors

```java
abstract class A {
    abstract void show();
    void display() {
        System.out.println("Normal method");
    }
}
```

---

### Can an abstract class have no abstract methods?

✅ **Yes**.

```java
abstract class Base {
    void log() {
        System.out.println("Logging");
    }
}
```

* Such classes are used to:

  * Prevent object creation
  * Act as a **base class**
  * Provide shared functionality

Subclasses:

* **May or may not override** methods
* Are **not forced** to implement anything unless abstract methods exist

---

### Why can’t we create an instance of an abstract class?

Because:

* Abstract classes may contain **incomplete behavior** (abstract methods)
* JVM cannot guarantee object correctness
* They are meant to be **templates / blueprints**

```java
A obj = new A(); // ❌ Compile-time error
```

But:

```java
A obj = new B(); // ✅ Polymorphism
```

---

### Abstract class & Polymorphism

> To achieve polymorphism, the **base class must declare the method** that subclasses override.

```java
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double area() {
        return 3.14 * 5 * 5;
    }
}
```

---

### Rules for Abstract Methods

* Must be declared **only inside abstract classes**
* Cannot have a body
* Must be implemented by the first concrete subclass

```java
abstract void run();
```

> Vice versa is **not applicable**:
> An abstract class does **not** need abstract methods

---

## 2. Interfaces

### What is an interface?

* A **pure contract** that defines *what* a class must do
* Focuses on **capability**, not implementation

```java
interface Flyable {
    void fly();
}
```

---

### Interface Methods (Java 8+)

| Method Type | Body | Override? | Access |
| ----------- | ---- | --------- | ------ |
| abstract    | ❌    | Mandatory | public |
| default     | ✅    | Optional  | public |
| static      | ✅    | ❌         | public |

---

### Abstract methods in interface

* Implicitly `public abstract`
* No body allowed

```java
interface A {
    void show(); // public abstract
}
```

---

### Default methods

* Introduced to support **backward compatibility**
* Can be overridden

```java
interface Logger {
    default void log() {
        System.out.println("Logging...");
    }
}
```

Use **default** when:

* You want to add behavior without breaking existing implementations

---

### Static methods in interface

* Belong **only to the interface**
* Cannot be overridden

```java
interface Utils {
    static void help() {
        System.out.println("Helping");
    }
}

Utils.help();
```

Use **static** when:

* Method is utility-related
* Not dependent on object state

---

### Interface Variables

* Implicitly: `public static final`

```java
interface Config {
    int MAX = 100;
}
```

* Must be initialized
* Cannot be changed

---

### Access rules

* Interface methods → **public only**
* Implementing class methods → **must be public**

```java
class A implements Flyable {
    public void fly() {} // ✔️
}
```

---

### Multiple Inheritance (Interface)

Java **does not support multiple inheritance with classes**, but **does with interfaces**.

```java
interface A { void m1(); }
interface B { void m2(); }

class C implements A, B {
    public void m1() {}
    public void m2() {}
}
```

---

### Interface extending interface

```java
interface A {
    void m1();
}

interface B extends A {
    void m2();
}
```

* Interfaces **extend**, not implement

---

### Default method conflict (Diamond Problem)

```java
interface A {
    default void show() {}
}

interface B {
    default void show() {}
}

class C implements A, B {
    public void show() {
        A.super.show(); // or B.super.show()
    }
}
```

> Class **must override** to resolve ambiguity

---

### Class + Interface method conflict

```java
class A {
    void show() {}
}

interface B {
    default void show() {}
}

class C extends A implements B {}
```

✔️ **Class method wins over interface default method**

---

### Can an interface be `final`?

❌ No.

Reason:

* `final` → cannot be extended
* Interface is **meant to be implemented**

---

### API Design & Interfaces (Real-world analogy)

> APIs expose **contracts**, not implementations

Example:

* Booking apps
* Movie seat layouts
* Train schedules

All apps rely on:

```java
interface BookingAPI {
    List<Seat> getSeats();
    List<Show> getShows();
}
```

Implementation can vary, contract remains same → **uniform interface**

---

## 3. Abstract Class vs Interface vs Normal Class

| Feature              | Normal Class | Abstract Class | Interface           |
| -------------------- | ------------ | -------------- | ------------------- |
| Object creation      | ✅            | ❌              | ❌                   |
| Method body          | ✅            | Mixed          | Default/Static only |
| Multiple inheritance | ❌            | ❌              | ✅                   |
| Variables            | Any          | Any            | public static final |
| Constructors         | ✅            | ✅              | ❌                   |

---

### When to use what?

**Normal class**:

* Fully implemented behavior
* Concrete objects

**Abstract class**:

* Partial implementation
* Strong *is-a* relationship
* Code reuse

**Interface**:

* Capability / contract
* Multiple inheritance
* API design
* Loose coupling

---

### Important Gotchas

* Interface method cannot be both `abstract` and `default`
* Abstract methods have **no body**
* Default methods **must have body**
* Once a public interface is released, changes break users

---

### One-line Summary

> Abstract classes model **what something is**, interfaces model **what something can do**.

---
