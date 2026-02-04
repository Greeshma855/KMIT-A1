# Java Variables Overview

## 1. Instance Variables

### What are they?
Variables that belong to an object (instance) of a class.

```java
class Test {
    int x;        // instance variable
    String s;     // instance variable
}
```

### Key Points
- Declared inside a class
- Declared outside methods/constructors
- Each object gets its own copy
- Stored in the heap
- Automatically initialized by JVM

---

## 2. Static Variables (Class Variables)

### What are they?
Variables that belong to the class itself, not to any specific object.

```java
class Test {
    static int count;  // static variable
}
```

### Key Points
- Declared using `static`
- Only one copy shared by all objects
- Stored in Method Area / Metaspace
- Initialized once when class is loaded
- Can be accessed using class name

### Default Values
Same as instance variables.

### Example
```java
class Test {
    static int count;

    public static void main(String[] args) {
        System.out.println(Test.count); // prints 0
    }
}
```

---

## 3. Local Variables (for comparison)

```java
class Test {
    public static void main(String[] args) {
        int x;  // local variable
        System.out.println(x); // compile-time error
    }
}
```

### Key Points
- Declared inside methods / blocks
- Stored in stack
- No default values
- Must be initialized before use

---

## Comparison Table

| Feature        | Instance | Static | Local |
|---------------|----------|--------|-------|
| Belongs to    | Object   | Class  | Method |
| Memory        | Heap     | Method Area | Stack |
| Default value | Yes      | Yes    | No |
| Accessed via  | Object   | Class name | Direct |
| Copies        | Per object | One shared | Per block |
