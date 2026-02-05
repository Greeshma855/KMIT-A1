
## 1. String Mutability in Java

- **Strings in Java are immutable**
  - Once a `String` object is created, its value **cannot be changed**.
  - Any modification creates a **new String object**.

```java
String s = "hello";
s = s + " world";   // creates a new String object
```

- **But references can be changed**
  - The reference variable can point to a new object.

```java
String a = "java";
a = "python";   // reference changed, original object unchanged
```

---

## 2. Truth Values in C vs Java

### In C
- `0` → false
- **Any non-zero value** → true

```c
if (5) {
    // this will execute
}
```

### In Java
- `true` and `false` are **strict boolean values**
- `0` ≠ false
- `1` ≠ true

```java
if (1) { }        // ❌ compilation error
if (true) { }     // ✅ valid
```

---

## 3. Can We Write `Integer z = 20;`?

✅ **Yes, because of autoboxing**

```java
Integer z = 20;
```

- Primitive `int` is automatically converted to `Integer`
- Wrapper classes can be `null` and used in collections

---

## 4. Short-Circuit Evaluation

### OR (`||`)
- If first condition is **true**, second is not evaluated

### AND (`&&`)
- If first condition is **false**, second is not evaluated

```java
if (false && expensiveMethod()) {
    // not executed
}
```

---

## 5. Difference Between `&` vs `&&`, `|` vs `||`

| Operator | Short-circuit | Usage |
|--------|---------------|-------|
| `&` | ❌ No | Bitwise / force evaluation |
| `&&` | ✅ Yes | Conditions |
| `|` | ❌ No | Bitwise |
| `||` | ✅ Yes | Conditions |

---

## 6. Why Use `switch` Instead of `if-else`?

- Cleaner for fixed values
- More readable
- JVM may optimize it better

Use `if-else` for ranges and complex conditions.

---

## 7. `continue` in `switch`

- ❌ `continue` cannot be used directly in `switch`
- ✅ Allowed if `switch` is inside a loop

```java
for (int i = 0; i < 5; i++) {
    switch(i) {
        case 2:
            continue;
    }
    System.out.println(i);
}
```

---

## Key Takeaways

- Java is strictly typed
- Strings are immutable
- Use `&&` and `||` for conditions
- `switch` improves readability

---
