# Java Core Concepts – Access Modifiers, Method Overloading & Parameter Passing


## 1. Access Modifiers

### `private`
- Members declared as `private` **cannot be accessed outside the class**.
- Used to achieve **data hiding** and encapsulation.

### `protected`
- Accessible:
  - Within the same package
  - In subclasses (even if in a different package)

### `public`
- Accessible **from anywhere** in the program.

---

## 2. Method Overloading

### What is Method Overloading?
- **Same method name**
- **Different method signatures**
  - Different number of arguments
  - Different types of arguments

### Examples (Built-in)
- `println(int)`, `println(float)`, `println(String)`
- `substring(start)`, `substring(start, end)`

### Why Method Overloading?
- Reduces **software maintenance cost**
- Improves **readability and usability**
- Same logical operation, different data types

### Analogy
- In C:
  - `%d`, `%c`, `%s` for different data types
- In Java:
  - Single `println()` handles all types

---

## 3. Implicit Type Conversion in Overloading

### Primitive Widening
```
byte → short → int → long → float → double
```

### Example Scenario
Overloaded methods:
- `m1(int x)`
- `m1(long x)`
- `m1(float x)`

Method calls:
- `byte`, `short` → calls `m1(int)`
- `int` → calls `m1(int)`
- `long` → calls `m1(long)`
- `double` → calls `m1(float)` (if no double version)

### Rule
> If an exact match is not found, Java selects the **nearest wider type** available.

---

## 4. Primitive vs Wrapper Overloading

### Scenario
Overloaded methods:
- `m1(Integer x)`
- `m1(long x)`

Call:
```java
int x = 2;
m1(x);
```

### What Happens?
1. **Primitive to primitive conversion** is preferred
2. Autoboxing is considered **only if primitive match fails**

### Result
- `m1(long x)` is called
- `m1(Integer x)` is NOT preferred

---

## 5. Varargs (Ellipsis `...`)

### Definition
- Allows **variable number of arguments**
- Syntax:
```java
m1(byte... x)
```

### Example
Methods:
- `m1(int x, int y)`
- `m1(byte... x)`

Calls:
- `m1(x, x)` → calls fixed-argument method
- `m1(x, x, x)` → calls varargs method

### Rule
> **Varargs get the least priority**

---

## 6. Method Resolution Priority Order

Java follows this order while resolving overloaded methods:

```
Exact match by type
   ↓
Wider primitive type
   ↓
Autoboxed type
   ↓
Varargs
```

---

## 7. Parameter Passing in Java

### Is Java Call by Value or Call by Reference?
👉 **Java is always Call by Value**

### For Primitives
- A copy of the value is passed
- Changes **do NOT reflect** back

### For Objects
- Copy of the **reference** is passed
- Both references point to the same object
- Changes **ARE reflected** if the object is mutable

### Examples
- `Integer`, `String` → Immutable → changes not reflected
- `StringBuilder` → Mutable → changes reflected

---

## 8. Shadowing Concept

- When a **local variable** or **method parameter** has the same name as a class variable
- The local one **shadows** the class-level variable

---

## 9. Widening: Primitives vs Wrappers

### Works for Primitives ✅
```
byte → short → int → long → double
```

### Does NOT Work for Wrappers ❌
```
Integer → Long   (Invalid)
```

---

## 10. Static Import

### What is Static Import?
- Allows access to **static members directly**
- Only static members can be imported

### Example
```java
import static java.lang.System.out;

out.println("hello");
```

✔ Works successfully without using `System.out`

---

## Summary

- Method overloading improves flexibility and maintainability
- Java prefers **primitive widening over autoboxing**
- Varargs are used only as a last resort
- Java uses **call by value** (even for objects)
- Widening works only for primitives, not wrappers
- Static import simplifies access to static members

---
