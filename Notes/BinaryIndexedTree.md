
# Binary Indexed Tree (Fenwick Tree)

A **Binary Indexed Tree (BIT)**, also known as a **Fenwick Tree**, is a data structure that efficiently supports:

- Prefix sum queries
- Point updates

Both operations run in **O(log n)** time.

---

## Why Binary Indexed Tree?

Given an array where:
- Elements change over time (updates)
- You frequently need prefix sums or range sums

A BIT is faster and simpler than recomputing sums each time.

---

## Core Idea

- BIT is **1-indexed**
- Each index stores the sum of a **block of elements**
- Block size is decided by the **last set bit** of the index

> BIT is not a pointer-based tree.  
> It is a **logical tree embedded inside an array**.

---

## Last Set Bit (LSB)

The **last (lowest) set bit** of a number `i` is found using:

```
i & (-i)
```

This works because of two’s complement representation.

### Examples

| i | Binary | i & -i |
|---|--------|--------|
| 5 | 101 | 1 |
| 6 | 110 | 2 |
| 8 | 1000 | 8 |
| 12 | 1100 | 4 |

---

## What does BIT[i] store?

```
BIT[i] stores the sum of elements from:
(i - (i & -i) + 1) to i
```

This formula is the **most important rule** in Fenwick Trees.

---

## Example Array

```
A = [5, 2, 9, -3, 5, 20, 10, -7, 2, 3, -4, 0, -2, 15, 5]
n = 15
```

---

## Constructed BIT Array

| Index | BIT Value |
|------|-----------|
| 1 | 5 |
| 2 | 7 |
| 3 | 9 |
| 4 | 13 |
| 5 | 5 |
| 6 | 25 |
| 7 | 10 |
| 8 | 41 |
| 9 | 2 |
| 10 | 5 |
| 11 | -4 |
| 12 | 1 |
| 13 | -2 |
| 14 | 13 |
| 15 | 5 |

---

## Why is BIT[6] = 25?

```
i = 6
i & -i = 2
```
So BIT[6] stores 2 elements ending at index 6:

```
A[5] + A[6] = 5 + 20 = 25
```

BIT does **not** store prefix sums directly.

---

## Prefix Sum Query

To compute sum from index `1` to `i`:

```
sum = 0
while (i > 0):
    sum += BIT[i]
    i -= i & (-i)
```

### Example: sum(1…6)

```
i = 6 → add BIT[6] = 25
i = 4 → add BIT[4] = 13
i = 0 → stop
Total = 38
```

---

## Range Sum Query

Range queries are done using prefix sums:

```
RangeSum(l, r) = prefix(r) - prefix(l - 1)
```

BIT does **not** directly support arbitrary range queries without this trick.

---

## Point Update

To update index `i` by `delta`:

```
while (i <= n):
    BIT[i] += delta
    i += i & (-i)
```

All BIT nodes whose range includes index `i` are updated.

---

## BIT Construction Methods

### Method 1: Update-based Build (O(n log n))

```
for i = 1 to n:
    update(i, A[i])
```

### Method 2: Optimized Build (O(n))

```
for i = 1 to n:
    BIT[i] += A[i]
    parent = i + (i & -i)
    if parent <= n:
        BIT[parent] += BIT[i]
```

---

## Sample Code (Java)

```java
class FenwickTree {
    int[] bit;
    int n;

    FenwickTree(int n) {
        this.n = n;
        bit = new int[n + 1];
    }

    void update(int i, int delta) {
        while (i <= n) {
            bit[i] += delta;
            i += i & -i;
        }
    }

    int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }

    int rangeQuery(int l, int r) {
        return query(r) - query(l - 1);
    }
}
```

---

## Supported Operations

| Operation | BIT |
|---------|-----|
| Sum | ✅ |
| XOR | ✅ |
| Point update | ✅ |
| Range sum | ⚠️ (prefix trick) |
| Min / Max | ❌ |
| GCD | ❌ |

BIT requires **invertible operations**.

---

## Indexing Note

- Fenwick Tree is naturally **1-indexed**
- For 0-indexed arrays, shift indices or adapt formulas

---

## Time & Space Complexity

- Build: `O(n log n)` (or `O(n)` optimized)
- Query: `O(log n)`
- Update: `O(log n)`
- Space: `O(n)`

---

## BIT vs Segment Tree

- BIT: simpler, faster, less memory, limited operations
- Segment Tree: more flexible, supports min/max, range updates

---

## Common Mistakes

- Using `i & (i - 1)` instead of `i & (-i)`
- Forgetting BIT is 1-indexed
- Assuming BIT[i] stores prefix sum

---

## One-Line Exam Definition

> A Binary Indexed Tree is a data structure that uses binary decomposition to support prefix sum queries and point updates in O(log n) time.

---

## Final Mental Model

- Think in **binary blocks**
- Each index covers a **power-of-two range**
- Queries jump **left**
- Updates jump **right**
