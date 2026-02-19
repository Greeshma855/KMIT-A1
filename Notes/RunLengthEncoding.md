# Run-Length Encoding (RLE)

A **complete revision guide** for Run-Length Encoding from both **DSA (problem-solving)** and **general computer science** perspectives.

---

## 1. What is Run-Length Encoding?

**Run-Length Encoding (RLE)** is a simple compression and grouping technique where **consecutive identical elements** are replaced by a **count + value**.

### Basic Idea
Instead of storing every element:
```
AAAABBBCCDAA
```
Store:
```
(4, A), (3, B), (2, C), (1, D), (2, A)
```

This is useful whenever **consecutive repetition matters more than individual elements**.

---

## 2. RLE in Computer Science (General Perspective)

### Where RLE is Used
- Lossless data compression
- Image compression (bitmap images, fax machines)
- String compression
- Pattern recognition
- Data transmission optimization

### Why RLE Works
RLE is effective when:
- Data has **long repeated sequences**
- Frequency of change is low

RLE is **inefficient** when data changes frequently.

---

## 3. RLE in Data Structures & Algorithms (DSA)

In DSA, RLE is **rarely used for compression**.
Instead, it is used as a **problem-solving pattern**.

### Core Idea in DSA
> Convert a sequence into **groups of consecutive identical values**, then solve the problem using group properties.

---

## 4. How RLE Looks in DSA Problems

### Example String
```
"001110011"
```

### RLE Grouping
```
Characters: 0  1  0  1
Counts:     2  3  2  2
```

Represented as:
```
groups = [2, 3, 2, 2]
```

You often **do not store characters**, only counts.

---

## 5. Typical RLE Coding Pattern (DSA)

### Step 1: Build Groups
- Traverse the array/string
- If current element == previous → increment count
- Else → start a new group

### Step 2: Process Groups
- Compare adjacent groups
- Apply formulas on group size
- Use greedy logic

---

## 6. Common Operations on RLE Groups

| Operation | Use Case |
|---------|--------|
| min(a, b) | Balanced substrings |
| max(group) | Longest consecutive run |
| sum(groups) | Total count |
| group[i] + group[i+1] | Merge logic |
| len * (len+1) / 2 | Substring counting |

---

## 7. Classic DSA Problems Using RLE

### 1. Count Binary Substrings
- Group consecutive 0s and 1s
- Result = sum of min(adjacent groups)

### 2. String Compression
- Replace characters with character + count

### 3. Count Homogeneous Substrings
- For each group of length `k`
- Add `k * (k + 1) / 2`

### 4. Longest Consecutive Characters
- Find max group size

---

## 8. Why RLE is a Powerful DSA Pattern

Without RLE:
- Nested loops
- Complex window logic
- Higher time complexity

With RLE:
- Single pass grouping
- Clean greedy solutions
- Often **O(n)** time

---

## 9. RLE vs Sliding Window

| RLE | Sliding Window |
|---|---|
| Focus on groups | Focus on ranges |
| Compress first | Expand and shrink |
| Best for consecutive patterns | Best for constraints |

Choose RLE when:
- Problem talks about **continuous identical elements**

---

## 10. Space Optimization Insight

You often **do not need full RLE array**.

You can keep:
- `prevGroupCount`
- `currentGroupCount`

This reduces space from **O(n) → O(1)**.

---

## 11. How to Recognize RLE Problems (EXAM TRIGGER)

Your brain should think RLE when you see:
- Consecutive characters
- Grouped substrings
- Continuous segments
- Blocks of same values
- Adjacent comparison logic

---

## 12. One-Line Memory Hook

> **If the problem cares about consecutive repetition, group first, then think.**

---

## 13. Final Summary

- RLE = grouping consecutive identical elements
- In DSA, used for **logic simplification**, not compression
- Common in string and array problems
- Often paired with greedy logic

---

### End of Notes
You can revise this file before exams or interviews to quickly recall the RLE pattern.

