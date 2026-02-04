
# Two Pointers Technique

## What is Two Pointers?
Two Pointers is a technique where **two indices move independently** to solve problems efficiently.

Unlike Sliding Window, elements **do not need to be contiguous**.

---

## When to Use Two Pointers
Use Two Pointers when the problem involves:
- Sorted arrays
- Pairs or triplets
- Palindromes
- Comparing elements from both ends

---

## Common Pointer Setups

### 1. Both Ends (Most Common)
```text
left = 0
right = n - 1
```

Used when:
- Array is sorted
- You need min/max behavior

---

### 2. Same Direction
```text
slow = 0
fast = 0
```

Used for:
- Removing duplicates
- In-place modifications

---

## Core Pattern (Sorted Array)

```java
while (left < right) {
    if (condition met) {
        return answer;
    } else if (too large) {
        right--;
    } else {
        left++;
    }
}
```

---

## Key Rules
- Works best on **sorted data**
- Movement logic depends on:
  - Increasing or decreasing the target value
- No nested loops → linear time

---

## Time & Space Complexity
- Time: **O(n)**
- Space: **O(1)**

---

## Sliding Window vs Two Pointers

| Feature | Sliding Window | Two Pointers |
|------|---------------|-------------|
| Contiguous | Yes | Not required |
| Sorted required | No | Often yes |
| Constraint-based | Yes | No |
| Window size | Variable / Fixed | No window |

---

## Final Takeaway
> Use Two Pointers when order matters and you can eliminate choices intelligently.

If the array is **sorted**, always ask:
👉 *Can two pointers solve this in O(n)?*
