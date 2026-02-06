# Java Notes – Constructors, Date-Time API & Wrapper Classes

## 1. Classes Without Public Constructors

* A class **can exist without any public constructors**.
* Such classes **cannot be instantiated using `new` from outside**.
* Object creation is usually done using **static factory methods**.

### Why use this design?

* To **control object creation**
* To **return cached objects** instead of creating new ones
* To hide implementation details

### Example

```java
class MyClass {
    private MyClass() {}

    public static MyClass getInstance() {
        return new MyClass();
    }
}
```

➡️ Wherever the object is created, the **factory method must be static** because no object exists yet.

---

## 2. Why is `main` Method Static?

```java
public static void main(String[] args)
```

### Reason:

* JVM **does not create an object** of the class before calling `main`
* JVM calls `main` **using the class name**

```java
ClassName.main(args);
```

➡️ Hence, `main` **must be static**.

---

## 3. Java Date & Time API (`java.time.*`)

* Introduced in **Java 8**
* Immutable, thread-safe, and well-designed

### Common Classes

#### `LocalDate`

* Represents **date only** (no time)

```java
LocalDate d1 = LocalDate.now();
LocalDate d2 = LocalDate.of(2006, Month.JANUARY, 5);
LocalDate d3 = LocalDate.of(2006, 1, 5);
```

---

#### `LocalTime`

* Represents **time only** (no date)

```java
LocalTime t1 = LocalTime.now();
LocalTime t2 = LocalTime.of(6, 40, 30, 2300);
// hours, minutes, seconds, nanoseconds
```

---

#### `LocalDateTime`

* Represents **both date and time**
* **Immutable**

```java
LocalDateTime ldt = LocalDateTime.now();
ldt.plusDays(1); // creates a new object
```

➡️ Any modification creates a **new object**, old reference remains unchanged.

---

### Important Points

* `LocalDate` ❌ does not contain time
* `LocalTime` ❌ does not contain date

---

## 4. Constructors Not Clickable in Documentation

* If a constructor is **not visible/clickable** in Java documentation:

  * The constructor is **private or protected**
  * Object creation must be done using **static factory methods**

### Example

```java
LocalDate.now();
```

➡️ `LocalDate` has **private constructors**.

---

## 5. `Period` Class

* Used to represent a **date-based amount of time**
* Commonly used for **reminders and recurring events**

### Example

```java
Period p = Period.ofDays(30);
```

### Real-life analogy

* Credit card payment reminders
* Subscription renewals

---

## 6. `DateTimeFormatter`

Used for **formatting date and time**

### Predefined Formats

* `SHORT`
* `MEDIUM`
* `LONG`
* `FULL`

```java
DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
```

---

## 7. Wrapper Classes

### Common Wrapper Classes

| Primitive | Wrapper Class |
| --------- | ------------- |
| int       | Integer       |
| char      | Character     |
| double    | Double        |
| boolean   | Boolean       |

---

## 8. `==` vs `.equals()`

### `==` Operator

* Compares **memory references**

### `.equals()` Method

* Compares **actual values** (if overridden)

```java
Integer a = 100;
Integer b = 100;
System.out.println(a == b);      // true (cached)
System.out.println(a.equals(b)); // true
```

---

## 9. Autoboxing & Unboxing

### Autoboxing

* Primitive → Wrapper

```java
int x = 10;
Integer y = x; // autoboxing
```

### Unboxing

* Wrapper → Primitive

```java
Integer a = 20;
int b = a; // unboxing
```

---

## 10. Difference Between `int` and `Integer`

| Feature            | int       | Integer         |
| ------------------ | --------- | --------------- |
| Type               | Primitive | Wrapper class   |
| Memory             | Stack     | Heap            |
| Null allowed       | ❌ No      | ✅ Yes           |
| Methods available  | ❌ No      | ✅ Yes           |
| Use in collections | ❌ No      | ✅ Yes           |
| Performance        | Faster    | Slightly slower |

---

## 11. Key Exam Takeaways ⭐

* `main` is static because JVM calls it without object creation
* Date-Time API classes are **immutable**
* Wrapper classes are required for **collections and generics**
* Use `.equals()` for value comparison
* Static factory methods are used when constructors are private

---
