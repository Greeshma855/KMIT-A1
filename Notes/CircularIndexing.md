# Modular Indexing with Safe (Positive) Modulo

```java
nums[((i + nums[i]) % n + n) % n]
```

This technique is used to **safely access elements in a circular array**, even when indices become negative.

---

## 📌 What Is This Technique Called?

- **Circular Array Indexing**
- **Safe / Positive Modulo**
- **Modulo Normalization**
- **Wrap-around Indexing**

---

## 🤔 Why Do We Need This?

In many problems, we want to:
- Move forward or backward in an array
- Wrap around when we go past the ends
- Avoid invalid (negative) indices

However, in languages like **Java, C, and C++**, the modulo operator (`%`) can return **negative values**.

Example:
```java
-1 % 5 = -1   // ❌ not what we want for indexing
```

This is where **safe modulo** comes in.

---

## 🔍 Breaking Down the Expression

```java
nums[((i + nums[i]) % n + n) % n]
```

Step by step:

1. **`i + nums[i]`**  
   Move from index `i` by `nums[i]` steps (forward or backward).

2. **`(i + nums[i]) % n`**  
   Wrap around the array size `n`, but this may be negative.

3. **`+ n`**  
   Shifts negative values into a positive range.

4. **Final `% n`**  
   Ensures the index is strictly within `[0, n-1]`.

---

## ✅ General Safe Modulo Formula

```text
safeIndex = ((x % n) + n) % n
```

This guarantees:
```
0 ≤ safeIndex < n
```

---

## 📘 Example Walkthrough

### Example Array
```java
nums = [10, -3, 30, 40, 50]
n = 5
i = 1
nums[i] = -3
```

### Step-by-step
```java
i + nums[i] = 1 + (-3) = -2
(-2 % 5) = -2
(-2 + 5) = 3
3 % 5 = 3
```

✅ Final index = `3`  
```java
nums[3] = 40
```

---

## 🧠 Why This Is Important in Interviews

This technique appears in problems involving:
- Circular arrays
- Array rotation
- Cycle detection
- Jump games
- Ring buffers

Many interviewers expect you to **know why `% n` alone is not enough** in Java/C++.

---

## 🧪 Cleaner Helper Function (Optional)

```java
int safeIndex(int x, int n) {
    return ((x % n) + n) % n;
}
```

Usage:
```java
nums[safeIndex(i + nums[i], n)];
```

---

## 🆚 Java vs Python Note

Python already handles modulo safely:

```python
-2 % 5 == 3
```

So in Python, you can usually do:
```python
nums[(i + nums[i]) % n]
```

But **never rely on this behavior in Java/C++**.

---

## ✨ Key Takeaway

> Always normalize indices when using modulo with possible negative values.

This single trick can save you from:
- Runtime errors
- Wrong answers
- Subtle edge-case bugs

---

