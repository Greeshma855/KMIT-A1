# Kadane's Algorithm – Exam Notes

## What is Kadane's Algorithm?
Kadane's Algorithm is an **optimal algorithm** used to find the **maximum sum of a contiguous subarray** within a one-dimensional array of integers.

It is a **Greedy + Dynamic Programming** technique and runs in **linear time O(n)**.

---

## Problem Statement
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the **largest sum** and return its sum.

---

## Core Idea (Very Important)
At every index, decide:
- Either **extend the previous subarray**
- Or **start a new subarray** from the current element

If the previous sum becomes negative, it is discarded.

---

## Key Formula (Memorize This)
```text
currentSum = max(nums[i], currentSum + nums[i])
maxSum     = max(maxSum, currentSum)
```

---

## Java Implementation (Exam-Safe)
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
```

---

## Dry Run Example
Input:
```
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

| Index | Element | currentSum | maxSum |
|------|--------|------------|--------|
| 0 | -2 | -2 | -2 |
| 1 | 1 | 1 | 1 |
| 2 | -3 | -2 | 1 |
| 3 | 4 | 4 | 4 |
| 4 | -1 | 3 | 4 |
| 5 | 2 | 5 | 5 |
| 6 | 1 | 6 | 6 |
| 7 | -5 | 1 | 6 |
| 8 | 4 | 5 | 6 |

Output:
```
6
```
(Subarray: `[4, -1, 2, 1]`)

---

## Why Sliding Window Does NOT Work Here
Sliding Window requires a monotonic condition (expanding or shrinking must always help).

In Maximum Subarray:
- Negative numbers may still be part of the optimal subarray
- No fixed condition exists to move the left pointer

Hence, **Kadane’s Algorithm is required**.

---

## Edge Case Handling
- Works even when **all numbers are negative**
- Must initialize with `nums[0]`, not `0`

---

## Time and Space Complexity
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

---

## One-Line Exam Definition
> Kadane's Algorithm finds the maximum sum of a contiguous subarray by maintaining a running sum and discarding negative prefixes in linear time.

---

## Common Exam Traps
- Initializing `maxSum = 0` ❌
- Using sliding window ❌
- Forgetting negative-only arrays ❌

---

## When to Use Kadane’s Algorithm
- Keywords: **maximum subarray**, **contiguous**, **positive and negative numbers**

---

### ✅ Tip to Remember
> If the running sum becomes worse than starting fresh, reset it.

---

**End of Notes**

