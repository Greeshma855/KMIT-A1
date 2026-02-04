# Reversing a 32-bit Binary Number (Bit Reversal)

## What does bit reversal mean?

Reversing a binary number means **reversing all 32 bits**, not just the visible bits.

Example:
```
Input  (32-bit):  00000000 00000000 00000000 00001010
Output (reversed):01010000 00000000 00000000 00000000
```

Leading zeros are also reversed.

---

## Core Idea

- Read bits from **right to left** (LSB → MSB)
- Build the result from **left to right**
- Do this exactly **32 times**

---

## Bit Operations Used

- `n & 1` → gets the last bit
- `>>` → shifts input right
- `<<` → shifts result left

---

## Algorithm (Simple Steps)

1. Initialize `result = 0`
2. Repeat 32 times:
   - Extract last bit using `n & 1`
   - Shift result left by 1
   - Add extracted bit to result
   - Shift input number right by 1
3. Return result

---

## Pseudocode

```
result = 0
repeat 32 times:
    bit = n & 1
    result = (result << 1) | bit
    n = n >> 1
return result
```

---

## Java Implementation

```java
class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n = n >> 1;
        }
        return result;
    }
}
```

---

## Why This Works

- Right shift moves through input bits
- Left shift builds reversed output
- Fixed 32 iterations ensure full reversal

---

## Time & Space Complexity

- Time: O(32) → constant
- Space: O(1)

---

## Key Takeaway

> **Read bits from the right, write them to the left.**
