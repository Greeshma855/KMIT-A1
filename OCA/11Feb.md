
# Java Functional Programming, Lambdas, Functional Interfaces & Predicates 

---

## 1. Programming Paradigms

### Structural Programming
- Example: **C**
- Program is structured using functions and control flow
- No concept of objects

### Object-Oriented Programming (OOP)
- Example: **Java**
- Everything revolves around **classes and objects**
- Java is **not fully object-oriented** because:
  - Primitive types (`int`, `double`, etc.) are **not objects**

### Functional Programming
- Focuses on **functions as first-class citizens**
- Avoids unnecessary class creation
- Uses **lambda expressions**

---

## 2. Can We Write `main()` Without a Class?

❌ **No (in standard Java)**  
- Java programs must have **at least one class**
- (JShell is an exception, not standard execution)

---

## 3. Functional Interfaces

### What is a Functional Interface?
- An interface with **exactly one abstract method**
- Automatically treated as a **functional interface**

### Annotation
```java
@FunctionalInterface
```
- Optional but recommended
- Causes compile-time error if more than one abstract method exists

---

## 4. Difference Between Class and Interface

| Feature | Class | Interface |
|------|------|-----------|
| Multiple inheritance | ❌ No | ✅ Yes |
| Constructors | ✅ Yes | ❌ No |
| Method implementation | ✅ Yes | Default/Static only |
| Variables | Instance variables | `public static final` only |

---

## 5. Lambda Expressions

### What is a Lambda Expression?
- An **anonymous function**
- Has:
  - Parameters
  - Arrow `->`
  - Body
- No method name
- No access modifiers

### Syntax
```
(parameters) -> { body }
```

### Examples

| Lambda | Meaning |
|------|--------|
| `() -> true` | No parameters |
| `a -> a.startsWith("test")` | One parameter |
| `(String a) -> a.startsWith("test")` | One parameter with type |
| `(a, b) -> a.startsWith(b)` | Two parameters |
| `(String a, String b) -> a.startsWith(b)` | Types required when specified |

### Rules
- If parameter type is mentioned → **all must be typed**
- More than one parameter → **parentheses required**
- Single statement → braces optional
- Multiple statements → braces + `return` required

---

## 6. Example: Functional Interface with Lambda

### Example 1 – String Concatenation

```java
@FunctionalInterface
interface Concatenation {
    String concat(String a, String b);
}

class Concat {
    public static void main(String[] args) {
        Concatenation t = (a, b) -> a + b;
        System.out.println(t.concat("Hello", "World"));
    }
}
```

### Output
```
HelloWorld
```

---

## 7. Example 2 – Greetings

```java
@FunctionalInterface
interface Greetings {
    void greet(String b);
}

class Concat {
    public static void main(String[] args) {
        Greetings p1 = name -> System.out.println("Hello " + name);
        p1.greet("Harry Potter!!");
    }
}
```

### Output
```
Hello Harry Potter!!
```

---

## 8. Lambdas with Threads

- `Runnable` is a **functional interface**
- Hence threads can be created using lambdas

Example:
```java
Runnable r = () -> System.out.println("Thread running");
new Thread(r).start();
```

---

## 9. Predicates

### What is a Predicate?
- Found in `java.util.function.Predicate`
- Represents a **boolean-valued function**
- Method:
```java
boolean test(T t);
```

### Why use Predicate?
- Replaces loops with reusable conditions
- Very useful for **filtering data**

---

## 10. Predicate Example

```java
List<Integer> list = Arrays.asList(1,12,33,2,4,7,8,34);
Predicate<Integer> p = i -> i < 20;
```

---

## 11. Complete Predicate Program Example

```java
import java.util.*;
import java.util.function.Predicate;

class Concat {
    public static void main(String[] args) {

        List<Integer> l = Arrays.asList(1,2,3,4,5,6,10,15,20,25,30);

        Predicate<Integer> EvenFiveMultiples = x -> (x % 5 == 0 && x % 2 == 1);
        Predicate<Integer> NoOdds = x -> (x % 2 == 1);

        System.out.println("The even numbers that are multiples of 5 are:");
        eval(l, EvenFiveMultiples);

        System.out.println("The odd numbers are:");
        eval(l, NoOdds);

        // Odd numbers without using Predicate
        List<Integer> firstten = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            firstten.add(i);
        }
        firstten.removeIf(x -> x % 2 == 0);
        System.out.println(firstten);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }
    }
}
```

### Output
```
The even numbers that are multiples of 5 are:
5
15
25
The odd numbers are:
1
3
5
15
25
[1, 3, 5, 7, 9]
```

---

## 12. Key Takeaways

- Functional programming reduces boilerplate code
- Lambda expressions remove the need for anonymous classes
- Functional interfaces enable lambda usage
- Predicates encapsulate conditions cleanly
- Java supports functional style **without abandoning OOP**

---
