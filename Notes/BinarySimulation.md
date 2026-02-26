# Binary Simulation – Complete Notes (Java / DSA)

---

## 1. What is Binary Simulation?

**Binary Simulation** is a technique where we **simulate binary operations directly on a binary representation (string / array)** instead of converting it into a decimal number.

Instead of:

* Binary → Decimal → Operation → Binary

We do:

* **Binary → Operation (manually) → Binary**

This avoids overflow, large integer handling, and unnecessary conversions.

---

## 2. Why Binary Simulation is Needed

### Problems it solves

* Very large binary numbers
* Integer overflow
* Performance issues with `BigInteger`
* Precision loss

### Typical constraints where this is used

* Binary string length up to **10⁵**
* Repeated arithmetic operations

---

## 3. Core Binary Operations Used in Simulation

### 1️⃣ Divide by 2 (Even number)

Binary rule:

* If the **last bit is `0`**, the number is even
* Dividing by 2 = **right shift**

```text
1010 → 101
1100 → 110
```

Implementation:

```java
s.deleteCharAt(s.length() - 1);
```

---

### 2️⃣ Add 1 (Odd number)

Binary addition rules:

* Flip trailing `1`s to `0`
* First `0` becomes `1`
* If no `0` exists → prepend `1`

```text
10111 + 1 = 11000
111 + 1   = 1000
```

Implementation logic:

```java
while (i >= 0 && s.charAt(i) == '1') {
    s.setCharAt(i, '0');
    i--;
}
```

Carry handling:

```java
if (i < 0) s.insert(0, '1');
else s.setCharAt(i, '1');
```

---

## 4. Common Binary Simulation Pattern

```java
while (binary.length() > 1) {
    if (lastBit == '0') {
        // divide by 2
    } else {
        // add 1
    }
    steps++;
}
```

This loop mirrors how a CPU handles binary arithmetic.

---

## 5. Example Walkthrough

Input:

```text
s = "1101"
```

Steps:

```text
1101 (odd)  → add 1 → 1110
1110 (even) → /2    → 111
111  (odd)  → add 1 → 1000
1000 (even) → /2    → 100
100  (even) → /2    → 10
10   (even) → /2    → 1
```

Total steps = **6**

---

## 6. Time & Space Complexity

### Time Complexity

* Each bit flips **at most twice**
* Overall complexity: **O(n)**

### Space Complexity

* StringBuilder stores binary string
* **O(n)**

---

## 7. Why This is a Greedy Algorithm

At every step:

* The operation is **forced** by the last bit
* No alternative choice exists

This makes it a **greedy simulation**.

---

## 8. When to Use Binary Simulation

Use it when:

* Input is binary or bit-based
* Numbers are very large
* Repeated arithmetic operations are required
* Conversion to decimal is inefficient or unsafe

---

## 9. Related Problem Types

* Binary increment / decrement
* String-based arithmetic
* Bit manipulation without integers
* Large number division problems
* LeetCode 1404 (classic)

---

## 10. Interview-Ready Explanation (30 seconds)

> Binary simulation avoids converting a binary string to a number. We simulate binary arithmetic directly on the string by observing the last bit. If the number is even, we perform a right shift. If it’s odd, we simulate binary addition with carry propagation. This keeps the solution linear and avoids overflow.

---

## 11. Common Mistakes

❌ Converting binary to decimal
❌ Using `BigInteger` unnecessarily
❌ Ignoring carry propagation
❌ Forgetting edge case `"1"`

---

## 12. One-Line Summary

> **Binary simulation mimics how binary arithmetic works internally, using strings instead of numbers.**

---
