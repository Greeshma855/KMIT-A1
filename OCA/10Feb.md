
# Java Core Concepts – Constructors, Varargs, `static`, `final`, and Immutability

This document organizes and completes important Java concepts related to **constructors, varargs, static behavior, final keyword, initialization blocks, immutability, and method/variable access rules**.  
These notes are suitable for **exam preparation, interviews, and revision**.

---

## 1. Reference, Pointer, and Object Handling

- Java does **not** have pointers like C/C++
- Java uses **references**
- A reference stores the **address of an object**, not the object itself
- No pointer arithmetic is allowed in Java (safer memory model)

---

## 2. Varargs (Variable Arguments)

### Definition
Varargs allow a method to accept a **variable number of arguments**.

Syntax:
```java
methodName(type... variableName)
```

### Rules for Varargs

1. **Only one varargs parameter is allowed**
2. **Varargs must be the rightmost parameter**

### Valid
```java
test(int t, int... x)
```

### Invalid
```java
test(int... x, int t)      // ❌ varargs not last
test(int... x, String s)  // ❌ varargs not last
test(int... x, int... y)  // ❌ multiple varargs
```

### Can varargs accept zero arguments?
✅ Yes

- Varargs support **0 to N arguments**
- Internally treated as an array

---

## 3. Constructors in Java

### What is a Constructor?
- Used to **initialize objects**
- Same name as the class
- Automatically invoked when an object is created

### Constructor Rules

- ❌ Cannot be `static`
- ❌ Cannot be `final`
- ❌ Cannot be `abstract`
- ✅ Must have a body
- ❌ Cannot have a return type (not even `void`)

### Why constructors don’t have return types?
Because:
- They implicitly return an **instance of the class**
- Adding a return type would make it a method

---

## 4. Constructor Chaining (`this()` and `super()`)

### Example

```java
class Test {
    int x, y;

    Test() {
        this(10);          // valid
        // test(10);       // ❌ not valid
        new Test(10);      // creates object but no reference
    }

    Test(int x) {
        this(x, 20);
    }

    Test(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

### Rules

- `this()` calls another constructor of the **same class**
- `super()` calls the **parent class constructor**
- `this()` or `super()` must be the **first statement**
- You cannot call a constructor like a normal method

---

## 5. `final` Keyword

### `final` Variable
- Value cannot be changed once assigned

### `final` Method
- Cannot be overridden

### `final` Class
- Cannot be inherited (no child classes)

### Examples
- Wrapper classes (`Integer`, `Double`)
- `String`
- `System`
- `Date` (effectively immutable)

### Why use `final` with parameters?
- Prevents accidental modification
- Improves code safety and readability

---

## 6. Immutability in Java

### What is an Immutable Class?
- Object state **cannot be changed after creation**

### How to make a class immutable

1. Make fields `private`
2. Do not provide setters
3. Provide only getters
4. Initialize fields via constructor

### Example

```java
class Immutable {
    private int length;
    private int width;

    Immutable(int l, int w) {
        this.length = l;
        this.width = w;
    }

    int getLength() {
        return length;
    }

    int getWidth() {
        return width;
    }
}
```

- Getter methods **never return void**
- Object state cannot be modified externally

---

## 7. Static vs Instance Initialization

### Static Initialization Block
- Executes **once** when class is loaded

### Instance Initialization Block
- Executes **every time an object is created**

---

## 8. Order of Object Creation (Inheritance)

### Creation Order

1. Static blocks (parent → child)
2. Parent instance initialization
3. Parent constructor
4. Child instance initialization
5. Child constructor

---

## 9. Static Variables

- Only **one copy per class**
- Shared across all objects

Example:
```java
static int a = 50;
```

- Even if multiple objects are created, `a` exists only once
- Changes by one object are visible to all

---

## 10. Static Method Calls Using Object Reference

```java
Test obj = new Test();
obj = null;
obj.getCount();  // Works if getCount() is static
```

Why?
- Static methods belong to the **class**, not the object
- Compiler converts:
```java
obj.getCount() → Test.getCount()
```

---

## 11. Static vs Non-Static Access Rules

### Static Context
- ❌ Cannot access non-static variables directly
- ✅ Can access only static members

### Reason
- Static members belong to the class
- Non-static members belong to objects
- Static context has no idea **which object** to refer to

---

## 12. Real-Life Analogy for `static`

- **Attendance count** → static (same for everyone)
- **Name, Roll No** → non-static (unique per student)

---

## 13. Static Calling vs Instance Calling

- Static members → accessed using class name
- Instance members → accessed using object reference

Preferred style:
```java
ClassName.staticMethod();
```

---

## 14. `super` Keyword

- Used to call **parent class constructor**
- Must be the **first statement**
- If not written, Java inserts `super()` automatically

---

## Final Summary

- Varargs must be rightmost and only one allowed
- Constructors initialize objects and return instances implicitly
- `final` ensures immutability and safety
- Static members are class-level, shared by all objects
- Java uses references, not pointers
- Object creation follows a strict initialization order

---