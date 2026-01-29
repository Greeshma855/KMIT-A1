
1️⃣ Instance Variables
📌 What are they?

Variables that belong to an object (instance) of a class.

class Test {
    int x;        // instance variable
    String s;     // instance variable
}

📌 Key points

Declared inside a class

Declared outside methods/constructors

Each object gets its own copy

Stored in the heap

Automatically initialized by JVM

2️⃣ Static Variables (Class Variables)
📌 What are they?

Variables that belong to the class itself, not to any specific object.

class Test {
    static int count;  // static variable
}

📌 Key points

Declared using static

Only ONE copy shared by all objects

Stored in method area / metaspace

Initialized once when class is loaded

Can be accessed using class name

📌 Default values

Same as instance variables.

📌 Example
class Test {
    static int count;

    public static void main(String[] args) {
        System.out.println(Test.count); // prints 0
    }
}

3️⃣ Local Variables (for comparison)
class Test {
    public static void main(String[] args) {
        int x;  // local variable
        System.out.println(x); // ❌ compile-time error
    }
}

📌 Key points

Declared inside methods / blocks

Stored in stack

NO default values

Must be initialized before use

Feature	Instance	Static	Local
Belongs to	Object	Class	Method
Memory	Heap	Method Area	Stack
Default value	✅ Yes	✅ Yes	❌ No
Accessed via	Object	Class name	Direct
Copies	Per object	One shared	Per block