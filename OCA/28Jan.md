# Type Casting and Numeric Promotion in Java

## Type Casting

Type casting is the process of converting one data type into another.  
Java supports both **implicit** and **explicit** type casting.

---

## Implicit Casting (Upcasting)

Implicit casting happens automatically when converting a **smaller data type** to a **larger data type**.

```java
int x = 2;
long y = 33;
long z = x * y;
```

- `int` is automatically promoted to `long`
- No data loss occurs
- Java allows this conversion without explicit casting

---

## Explicit Casting (Downcasting)

**Explicit casting is required when converting a larger data type to a smaller one.**

```java
float k = (float) 10.0;
```

- **Downcasting can lead to loss of precision**
- Java requires the programmer to specify it explicitly

---

## Possible Lossy Conversion

```java
int x = 2;
long y = 33;
int z = x * y;    // compile-time error: possible lossy conversion
```

Explanation:

- Expression `x * y` results in a `long`
- Java does not automatically downcast `long` to `int`
- Explicit casting is required if you want this conversion

---

## Automatic Type Promotion

```java
int x = 6;
int y = 11;
float z = x * y;  // 66.0
```

Explanation:

- `x * y` is evaluated as `int`
- Result is automatically promoted to `float`
- Variables are automatically **upcasted**, but never **downcasted**

---

## Short Data Type and Arithmetic Operations

```java
short a = 14;
short b = 13;
short c = a + b;   // compile-time error
```

### Explanation

- Even though `a` and `b` are of type `short`
- Java promotes them to `int` before performing arithmetic
- Result of `a + b` is `int`
- An `int` cannot be stored in a `short` without casting

---

## Correct Approaches

```java
int c = a + b;
```

or

```java
short c = (short) (a + b);
```

---

## Numeric Promotion Rules in Java

- If two operands are of different data types, the **smaller type is promoted**
- `byte`, `short`, and `char` are always promoted to `int`
  during arithmetic or binary operations
- Promotion happens **before** the operation is executed

---

## Example

```java
byte a = 10;
byte b = 20;
int c = a + b;
```

- Both `a` and `b` are promoted to `int`
- The result is also of type `int`

---

## Key Points to Remember

- Java performs **automatic upcasting**
- Java does **not** perform automatic downcasting
- Arithmetic operations promote smaller data types to `int`
- Explicit casting is required for narrowing conversions
- Numeric promotion can cause unexpected compile-time errors if not understood
