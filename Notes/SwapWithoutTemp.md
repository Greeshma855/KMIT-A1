# Swapping Two Numbers Without Using a Temporary Variable

**three commonly used methods** to swap two numbers without using a temporary variable.  
Example values used:

```
a = 5
b = 2
```

---

## 1. Using Addition and Subtraction

### Code
```java
a = a + b;
b = a - b;
a = a - b;
```

### Explanation
- First line stores the sum of `a` and `b` in `a`
- Second line extracts original `a`
- Third line extracts original `b`

### Drawback
- May cause **integer overflow** if numbers are very large

---

## 2. Using Multiplication and Division

### Code
```java
a = a * b;
b = a / b;
a = a / b;
```

### Explanation
- Product of `a` and `b` is stored in `a`
- Division restores original values

### Drawbacks
- Fails if either `a` or `b` is `0`
- Risk of overflow
- Less preferred in interviews

---

## 3. Using XOR (Best Method)

### Code
```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```

### Explanation
- XOR cancels out duplicate bits
- Safely swaps values without overflow

### Advantages
- No overflow
- Works even if values are `0`
- Most **preferred in interviews**

---

## Interview Tip

If asked:
> *“How do you swap two numbers without using a temporary variable?”*

Answer:
> **XOR method** is the safest and most efficient as it avoids overflow and extra memory usage.
