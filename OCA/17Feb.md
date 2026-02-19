
# Inheritance, Polymorphism, and Casting (OOP Complete Notes)

These notes explain **Inheritance**, **Polymorphism**, **Method Overriding**, and **Type Casting** with clear intuition, rules, and examples.
This document is suitable for **exams, interviews, and revision**.

---

## 1. Inheritance

**Inheritance** is the mechanism by which one class **extends** another class.

- Child class inherits **data members** and **methods**
- Promotes **code reuse**
- Represents an **IS-A relationship**

### Example

```
Employee
   |
 Manager
```

```java
class Employee {
    void work() {
        System.out.println("Employee working");
    }
}

class Manager extends Employee {
}
```

> Manager IS-A Employee

---

## 2. HAS-A vs IS-A Relationship

### HAS-A (Composition)
- One class **contains** another class
- Focuses on **using** functionality

Example:
```
Car HAS-A Engine
```

### IS-A (Inheritance)
- One class **extends** another class
- Focuses on **type relationship**

Example:
```
Manager IS-A Employee
```

---

## 3. Inheritance vs Restriction

- **Inheritance** → extension of a class
- **Restriction** → overriding methods to change behavior

---

## 4. Hierarchical Inheritance

```
            Employee
             /    \
            /      \
        Manager   Developer
```

```java
Employee e = new Manager();
```

Meaning:
> e refers to an Employee who is actually a Manager

---

## 5. Polymorphism

**Polymorphism** means:
> One reference, many forms

It allows the same method call to behave differently based on the object.

---

## 6. Types of Polymorphism

### Compile-Time Polymorphism
- Method overloading
- Resolved at compile time

```java
int add(int a, int b)
int add(int a, int b, int c)
```

---

### Runtime Polymorphism
- Method overriding
- Resolved at runtime

```java
Employee e = new Manager();
e.work();
```

---

## 7. Relation Between Inheritance and Polymorphism

Polymorphism **depends on inheritance**.

- Inheritance creates relationship
- Overriding changes behavior
- Polymorphism selects implementation

---

## 8. Types of Inheritance

### Single
```
A
|
B
```

### Multilevel
```
A
|
B
|
C
```

### Hierarchical
```
    A
   / \
  B   C
```

### Multiple
```
A   B
 \ /
  C
```

### Hybrid / Repeated
Combination of inheritance types.

---

## 9. Multiple Inheritance in Languages

### Python
Python uses **Method Resolution Order (MRO)**.

```python
class A:
    def show(self):
        print("A")

class B:
    def show(self):
        print("B")

class C(A, B):
    pass

C().show()   # A is called
```

Rule:
> First parent is checked first

---

### C++
C++ allows multiple inheritance.
Child decides which parent method to call.

---

### Java
Java does not allow multiple inheritance using classes.
Uses **interfaces** instead.

---

## 10. Method Call Resolution Example

```java
Parent obj = new Child1();
obj = new Child2();
obj.m1();
```

Conditions:
- Parent has no m1()
- Child1 has no m1()
- Child2 has m1()

Result:
❌ Compile-time error

Reason:
Compiler checks reference type.

---

## 11. Casting

### Upcasting
```java
Parent p = new Child();
```
- Implicit
- Safe

---

### Downcasting
```java
Child c = (Child) p;
```
- Explicit
- May cause runtime exception

---

## 12. Casting Rules

- Subclass → Superclass: no cast required
- Superclass → Subclass: explicit cast required
- Unrelated types cannot be cast
- Wrong runtime type → ClassCastException

---

## 13. Virtual Methods

Virtual methods:
- Resolved at runtime
- Enable polymorphism

In Java:
> All non-static, non-final methods are virtual by default

---

## 14. Left vs Right Side Rule

Valid:
```
Employee e = new Manager();
```

Invalid:
```
Manager m = new Employee();
```

Reason:
Every Manager is an Employee, but not vice versa.

---

## 15. Key Takeaways

- Left side → reference type
- Right side → object type
- Compiler checks reference
- JVM decides method call
