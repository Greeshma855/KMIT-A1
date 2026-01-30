# Prefix Method (Prefix-Based Range Query Technique)

## Overview

The **Prefix Method** is a preprocessing technique used to efficiently answer
**range queries** on arrays.

Instead of recomputing results for every query, we:
1. Precompute cumulative results in a **prefix array**
2. Use that array to answer each query in **O(1) time**

This technique is widely used in competitive programming and interviews.

---

## Core Idea

For an array `arr`, create a prefix array such that:
```
prefix[i] = operation(arr[0], arr[1], ..., arr[i])
```

Once built, results for any subarray `[L, R]` can be derived using the prefix values,
instead of iterating over the array again.

---

## General Pattern

### Step 1: Build Prefix Array

```text
prefix[0] = arr[0]
prefix[i] = prefix[i - 1] OP arr[i]
```
Where OP is an operation like +, ^, etc.

### Step 2: Answer Range Query [L, R]
```
If L == 0:
    result = prefix[R]
Else:
    result = prefix[R] OP inverse(prefix[L - 1])
```
The idea is to remove the contribution of elements before index L.
