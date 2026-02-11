
# Prefix Balance (Prefix Difference) Technique

These notes explain the **Prefix Balance / Prefix Difference Technique**, a very important pattern used to solve problems involving **balanced subarrays**, **equal counts**, and **difference cancellation** efficiently.

---

## 1. What is the Prefix Balance Technique?

The **Prefix Balance Technique** tracks a **running difference (balance)** while traversing an array or string.

### Core Idea
> If the same balance value appears at two different indices,  
> then the subarray between those indices is **balanced**.

This is a generalization of the **prefix sum = 0** concept.

---

## 2. When to Use This Technique

Use prefix balance when the problem involves:
- Equal number of two types of elements
- Balanced subarrays
- Difference cancellation
- Longest subarray satisfying a balance condition

### Common keywords in problems:
- *balanced*
- *equal number of*
- *difference becomes zero*
- *longest subarray with equal…*

---

## 3. Balance Definition

A **balance** is defined as:

```
balance = count_of_type_A − count_of_type_B
```

Examples:
- Even vs Odd numbers
- 0s vs 1s
- Opening vs closing brackets
- Vowels vs consonants
- Distinct evens vs distinct odds

---

## 4. Fundamental Rule (MOST IMPORTANT)

> If `balance[i] == balance[j]`  
> then the subarray `(i + 1) → j` is balanced.

Why?
- Everything added before index `i` cancels out
- Net difference in the middle is zero

---

## 5. Initialization Trick

Always initialize:

```
balance = 0
map[0] = -1
```

### Why?
- It handles subarrays that start at index `0`
- Represents the state before the array begins

---

## 6. How the Algorithm Works (Step-by-Step)

1. Start with `balance = 0`
2. Traverse array from left to right
3. Update balance based on current element
4. If balance is seen before:
   - Calculate subarray length
   - Update answer
5. If balance is not seen:
   - Store index of first occurrence
6. Continue until end

---

## 7. Visual Intuition (Mental Model)

Think of balance as movement on a number line:
- `+1` → step right
- `−1` → step left
- Same position again → balanced in between

---

## 8. Why This Is Efficient

### Brute Force
- Try all subarrays
- Time complexity: **O(n²)** ❌

### Prefix Balance
- Single pass
- HashMap lookup
- Time complexity: **O(n)** ✅

---

## 9. Time & Space Complexity

| Aspect | Complexity |
|-----|-----------|
| Time | O(n) |
| Space | O(n) |

---

## 10. Common Variants of This Technique

| Problem Type | Balance Definition |
|------------|------------------|
| Equal 0s and 1s | `#0 − #1` |
| Balanced parentheses | `(` = +1, `)` = −1 |
| Longest zero-sum subarray | Prefix sum |
| Even vs odd | `#even − #odd` |
| Distinct even vs odd | `#distinct_even − #distinct_odd` |

---

## 11. Typical Mistakes to Avoid

❌ Forgetting `map.put(0, -1)`  
❌ Updating map every time (should store **first occurrence only**)  
❌ Using sliding window (does NOT work for balance problems)  
❌ Recomputing counts for each subarray  

---

## 12. How to Identify This Technique in Exams / Interviews

Ask yourself:
- Is the condition about **equal counts**?
- Can I convert the condition into a **difference = 0**?
- Do I need the **longest** or **number of subarrays**?

If yes → **Prefix Balance Technique**

---

## 13. One-Line Explanation

> The prefix balance technique tracks a running difference between two quantities and uses repeated balances to identify balanced subarrays efficiently.

---

## 14. Related Famous Problems

- Longest subarray with sum = 0
- Equal number of 0s and 1s
- Balanced parentheses
- Distinct even vs odd subarrays

---

## 15. Final Takeaway

> Prefix Balance converts a global balance condition into a local prefix comparison problem, allowing O(n) solutions to problems that otherwise require O(n²).

---
