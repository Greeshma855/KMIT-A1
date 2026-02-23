
---

## At-Most K Sliding Window Technique

```markdown
# At-Most K Sliding Window Technique (Exactly-K Trick)

This README explains one of the **most important sliding window patterns** used in DSA and coding interviews.

---

## 📌 What is this technique called?

Common names:
- **At-Most K Sliding Window Technique**
- **Exactly-K via At-Most Trick**
- **Difference of Sliding Windows**
- **Dual Sliding Window Pattern**

> Interviewers usually say: **“Use the at-most K trick.”**

---

## 🧠 Core Idea (One Line)

To count subarrays with **exactly K** property:

```

exactly(K) = atMost(K) − atMost(K−1)

```

Sliding window works naturally for **≤ K**, not for **exactly K**.

---

## ❓ Why is this needed?

A single sliding window:
- ✅ Can handle **at most K**
- ❌ Cannot directly count **exactly K**

Reason:
- When a window is valid with exactly K, there are **multiple valid start points**
- One window can track only **one left pointer**

So we convert:
- Exact condition → boundary conditions
- Then subtract

---

## 🪜 How Sliding Window Helps

Sliding window maintains:
- A **valid window**
- Ensures monotonic behavior (adding elements only increases the count)

This allows counting **all valid subarrays ending at a given index**.

Key counting logic:
```

count += end - start + 1

```

This counts all valid subarrays ending at `end`.

---

## 🧮 Mathematical Intuition

Let:
- A₁ = subarrays with exactly 1 distinct
- A₂ = subarrays with exactly 2 distinct
- A₃ = subarrays with exactly 3 distinct

Then:
```

atMost(3) = A₁ + A₂ + A₃
atMost(2) = A₁ + A₂

```

So:
```

exactly(3) = atMost(3) − atMost(2)

````

---

## 🧩 Standard Template

### atMost(K)

```java
int atMost(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int start = 0, count = 0;

    for (int end = 0; end < nums.length; end++) {
        map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

        while (map.size() > k) {
            map.put(nums[start], map.get(nums[start]) - 1);
            if (map.get(nums[start]) == 0) {
                map.remove(nums[start]);
            }
            start++;
        }

        count += end - start + 1;
    }
    return count;
}
````

### exactly(K)

```java
exactlyK = atMost(K) - atMost(K - 1);
```

---

## 🪄 Single-Function Variant (Two Windows)

Instead of helper functions, maintain **two windows**:

* One with ≤ K distinct
* One with ≤ K−1 distinct

Answer added per step:

```
leftK1 - leftK
```

---

## 🔍 When to Use This Pattern

Use this technique when:

* The problem asks for **number of subarrays**
* The condition is **monotonic**
* The question says **exactly K**

Keywords:

* exactly K
* count subarrays
* distinct / odd / vowels / sum

---

## 🚫 When NOT to Use It

* Non-monotonic conditions
* Maximum/minimum length problems
* Sliding window breaks due to negative numbers

---

## 🧠 Memory Hook

> Sliding window likes boundaries, not exact targets
> So we count boundaries and subtract

---

## 🔁 Common Problems Using This Technique

* Subarrays with K Different Integers
* Count Nice Subarrays
* Binary Subarrays With Sum K
* Subarrays with Exactly K Odd Numbers
* Substrings with Exactly K Distinct Characters

---

## 🎯 Final Takeaway

* Sliding window → handles **at most**
* Math → isolates **exactly**
* Time complexity → **O(n)**
* Interview relevance → **Very High**

---
