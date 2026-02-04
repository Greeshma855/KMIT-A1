
# Sliding Window Technique

## What is Sliding Window?
Sliding Window is a technique used to process **contiguous subarrays / substrings** efficiently by maintaining a window using two pointers.

Instead of recalculating results for every subarray, we **slide** the window forward and update results incrementally.

---

## When to Use Sliding Window
Use Sliding Window when the problem mentions:
- Subarray / substring
- Contiguous elements
- At most / at least / exactly `k`
- Minimum / maximum length
- Sum, count, or frequency within a range

---

## Types of Sliding Window

### 1. Fixed Size Window
- Window size is constant
- Example: sum of every subarray of size `k`

**Pattern**
- Build first window
- Slide by removing left element and adding right element

---

### 2. Variable Size Window (Most Important)
- Window size changes based on constraints

**Pattern**
1. Expand window (`end++`)
2. Update state (sum / frequency)
3. While constraint is violated:
   - Shrink window (`start++`)
4. Update answer when window is valid

---

## Core Template (Variable Size)

```java
int start = 0;
for (int end = 0; end < n; end++) {
    // add nums[end] to state

    while (constraint violated) {
        // remove nums[start] from state
        start++;
    }

    // update answer
}
```

---


## Key Rules
- Always shrink using a **while**, not `if`
- Update answer **after** window becomes valid
- Works best when:
  - Elements are positive
  - Constraint behaves monotonically

---

## Time & Space Complexity
- Time: **O(n)**
- Space: **O(1)** or **O(k)** depending on data structure

---

## Final Takeaway
> Sliding Window is about maintaining **validity**, not consuming resources.

If the problem says **subarray + constraint**, think Sliding Window.
