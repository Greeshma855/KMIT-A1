# Power of Two Check Using Bit Manipulation

## Goal
Check if a number `n` is a **power of two**.

---

## Key Property
A power of two has **exactly one set bit** in its binary representation.

Examples:
```
1  -> 0001
2  -> 0010
4  -> 0100
8  -> 1000
```

---

## Core Trick

```java
n > 0 && (n & (n - 1)) == 0
```

---

## Why This Works

- `n - 1` flips the **rightmost set bit** to `0`
- If `n` has only one set bit, AND-ing removes it completely
- Result becomes `0`

---

## Important Note

`n > 0` is required because:
```
0 & (0 - 1) = 0   // false positive without the check
```

---

## Examples

| n | Binary | n & (n-1) | Power of Two |
|---|--------|-----------|--------------|
| 1 | 0001 | 0 | Yes |
| 2 | 0010 | 0 | Yes |
| 3 | 0011 | 2 | No |
| 4 | 0100 | 0 | Yes |
| 6 | 0110 | 4 | No |

---

## One-Line Intuition

> A number is a power of two if removing its only set bit leaves nothing.

---

## Related Problems
- LeetCode 231 – Power of Two
- LeetCode 342 – Power of Four
