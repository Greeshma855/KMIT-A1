# Java Constructors & Initialization

## Constructors in Java

- A class can have **any number of constructors**.
- Constructors are of **two types**:
  - **Default constructor** – provided by JVM.
  - **User-defined constructor**.
- If a class contains **any user-defined constructor**, the JVM will **not provide a default constructor** automatically.
- Constructor rules:
  - Constructor name must be the **same as the class name**.
  - Constructors **do not have a return type**.
  - Constructors can be overloaded using:
    - Number of arguments
    - Type of arguments

---

## Variable Initialization

- **Instance variables** are initialized with **default values**.
- **Local variables** are initialized with **garbage values** (must be explicitly initialized before use).

---

## Null Pointer Exception (NPE)

- Occurs when an object reference is **not pointing to any object**.
- Happens when methods or variables are accessed using a `null` reference.

While analyzing a program:
1. Check if the code **compiles**
2. Check for **runtime exceptions**
3. Determine the **output**

---

## Array Declarations

```java
int[] a, b;   // a and b are both arrays
int a[], b;   // a is an array, b is a variable

import java.util.*;

class three {
    void m() {
        System.out.println("helo");
    }
}

// static block -> instance blocks -> constructor
class init {
    init() {
        System.err.println("init 1");
    }

    init(int x) {
        System.out.println("inin int");
    }

    static {
        System.out.println("static 1");
    }

    {
        System.out.println("1st instance");
    }

    static {
        System.out.println("static 2");
    }
}

public class Constructors {
    public static void main(String[] args) {

        int[] a, b;
        a = new int[2];
        b = new int[3];

        System.out.println(Arrays.toString(a));

        // These 5 objects are not pointing to any instance (null references)
        three[] obj = new three[5];

        // First object is now pointing to a reference
        obj[0] = new three();
        obj[0].m();

        System.out.println(Arrays.toString(obj));

        new init();
        // new init(2);
    }
}


## Saving Space (Bit-Level Optimization)

A date is usually stored using **three integers**:
- Date → 4 bytes
- Month → 4 bytes
- Year → 4 bytes  

Total memory used:
- `3 × 4 bytes = 12 bytes = 96 bits`

---

### Optimized Bit Representation

Instead of storing each value as an integer, we can store them using only the **required number of bits**.

- **Date (1–31)**  
  - Max value: 31  
  - Requires: `2⁵ = 32` → **5 bits**

- **Month (1–12)**  
  - Max value: 12  
  - Requires: `2⁴ = 16` → **4 bits**

- **Year (0–99)**  
  - Max value: 99  
  - Requires: `2⁷ = 128` → **7 bits**

---

### Total Bits Required
Date : 5 bits
Month : 4 bits
Year : 7 bits

---

### Memory Comparison

| Approach | Memory Used |
|--------|-------------|
Traditional (3 integers) | 96 bits |
Bit-level storage | 16 bits |

---

### Conclusion

By storing date components at the **bit level**, we can significantly reduce memory usage.  
This optimization becomes highly effective in **large-scale databases** where millions of records are stored.
