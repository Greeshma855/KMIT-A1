# Common Prefix (Bitwise Range Reduction) Approach

## Overview
The **Common Prefix Approach** is a bit manipulation technique used when performing
bitwise operations over a **continuous range of integers**.

The idea is to eliminate all **unstable bits** (bits that change within the range)
and keep only the **most significant bits that remain identical** across the range.

---

## Core Principle
For any bitwise operation over a range `[L, R]`:

- If a bit **changes even once** within the range, it becomes **fixed**:
  - `0` for **AND**
  - `1` for **OR**
- Only bits that **never change** survive

These surviving bits form the **common binary prefix** of `L` and `R`.

---

## Intuition
- Lower bits flip frequently as numbers increase
- Higher (MSB-side) bits remain stable longer
- Once two numbers differ, all less significant bits will flip somewhere in the range

Therefore:
> **Only the common MSB prefix of `L` and `R` can be trusted**

---

## General Technique

1. Repeatedly right-shift both numbers
2. Stop when both values become equal
3. Left-shift the result back by the same number of shifts

This removes unstable bits and preserves the prefix.

---

## Generic Pseudocode

```text
shift = 0
while L != R:
    L = L >> 1
    R = R >> 1
    shift++

return L << shift
```

## Why Right Shift Works

- Right shift removes the **least significant bit (LSB)**
- If `L != R`, the LSB is guaranteed to differ **somewhere in the range**
- Removing LSBs repeatedly eliminates **unstable bits**
- This continues until only **stable MSB bits (common prefix)** remain

---

## When to Use This Approach

Use this approach **only when all conditions apply**:

- Problem involves a **range** `[L, R]`
- Operation is **bitwise**
- Result depends on **bit stability**
- Constraints make brute force infeasible

### Typical Keywords
- “all numbers between L and R”
- “range bitwise operation”
- very large bounds (`10^9`, `10^18`)

---

## Operations Where It Applies

| Operation | Behavior |
|---------|----------|
| AND | Common prefix + `0`s |
| OR  | Common prefix + `1`s |
| XOR | Partial (requires parity logic) |

---

## Operations Where It Does NOT Apply

- Arithmetic operations (sum, product, average)
- Single-number bit manipulation tricks
- Non-continuous or unordered sets

---

## Common Variations

- MSB prefix matching
- Bitwise prefix trimming
- Shift-until-equal technique  

> No single official name exists for this approach.

---

## Time and Space Complexity

- **Time:** `O(log N)`
- **Space:** `O(1)`

---

## Interview Insight

This approach demonstrates:
- Understanding of **bit stability**
- Awareness of **range-based behavior**
- Ability to optimize beyond brute force

---

## Interview One-Liner

> “For bitwise operations over a range, only the common binary prefix of the endpoints remains stable.”

---

## Mental Model

> **Remove unstable bits until values converge.**
