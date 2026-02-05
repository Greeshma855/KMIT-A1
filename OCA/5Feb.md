

## 1. `Arrays.binarySearch()` Behavior

### Example
```java
int[] numbers = {2, 4, 6, 8};

System.out.println(Arrays.binarySearch(numbers, 2)); // 0
System.out.println(Arrays.binarySearch(numbers, 9)); // -5
```

### Scenarios and Results

| Scenario | Result |
|-------|--------|
| Target element found in **sorted array** | Index of the element |
| Target element **not found** in sorted array | `-(insertionPoint) - 1` |
| Array is **not sorted** | Result is **unpredictable** |

### Explanation of `-5`
- Insertion point of `9` is index `4`
- Formula: `-(4) - 1 = -5`

📌 **Insertion point** = index where the element should be inserted to keep the array sorted.

---

## 2. Static Calls vs Non-Static Calls

### Example
```java
System.out.println();
```

### Breakdown
- `System` → class
- `out` → **static object** inside `System`
- `println()` → method of `PrintStream`

### Rules
- **Static methods/variables** → accessed using class name
- **Non-static methods** → accessed using objects

---

## 3. String Sorting (Lexicographical Order)

### Example
```java
{"17", "22", "45", "37", "111"}
```

### After Sorting
```java
{"111", "17", "22", "37", "45"}
```

### Why?
- Sorting is **lexicographical**, not numerical
- Characters are compared **left to right**
- ASCII/Unicode values are used

📌 `"111"` comes before `"17"` because `'1' == '1'`, then `'1' < '7'`.

---

## 4. String Creation: Heap vs String Pool

### String Pool
```java
String s1 = "java";
String s2 = "java";
```
- Both references point to **same object** in string pool

### Heap (using `new`)
```java
String s3 = new String("java");
```
- New object created in heap
- Does **not** reuse pool object unless `intern()` is used

---

## 5. Why `StringBuffer` and `StringBuilder`?

Because **String is immutable**.

| Class | Thread-safe | Performance |
|-----|------------|-------------|
| `StringBuffer` | ✅ Yes | Slower |
| `StringBuilder` | ❌ No | Faster |

Use:
- `StringBuffer` → multi-threaded environments
- `StringBuilder` → single-threaded code

---

## 6. `ArrayList` Behavior and Operations

### Example
```java
ArrayList al = new ArrayList();
al.add("KMIT");
al.add(Boolean.TRUE);

al.add(1, 21);
al.set(1, 22);
```

### Final List
```java
["KMIT", 22, true]
```
- `add(index, value)` shifts elements
- `set(index, value)` replaces element
- Size remains `3`

---

## 7. `equals()` in Lists

```java
List<String> list1 = Arrays.asList("kmit", "ngit");
List<String> list2 = Arrays.asList("kmit", "ngit");
List<String> list3 = Arrays.asList("ngit", "kmit");
```

```java
list1.equals(list2); // true
list1.equals(list3); // false
```

### Why?
- Order matters
- Element-by-element comparison

---

## 8. Backed Collections (`Arrays.asList`)

### Example
```java
String[] array = {"kmit", "ngit"};
List<String> list = Arrays.asList(array);

list.set(1, "genesis");
array[0] = "india";
```

### Output
```java
["india", "genesis"]
```

### Key Points
- List is **backed by the array**
- Changes reflect both ways
- ❌ Cannot change size (`add/remove` not allowed)

---

## 🔑 Key Takeaways

- `binarySearch` requires **sorted array**
- String sorting is lexicographical
- String pool improves memory efficiency
- `ArrayList.equals()` checks order
- `Arrays.asList()` creates fixed-size backed lists

---
