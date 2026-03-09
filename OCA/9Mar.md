# Java Exceptions -- Complete Guide

## 1. What is an Exception?

An **Exception** is an unwanted or unexpected event that occurs during
the execution of a program and disrupts the normal flow of the program.

Example: - Dividing a number by zero - Accessing an invalid array
index - Opening a file that does not exist

Java uses an **Exception Handling Mechanism** to deal with such runtime
problems.

------------------------------------------------------------------------

# 2. Exception Hierarchy

    Object
     └── Throwable
          ├── Error
          └── Exception
                ├── RuntimeException (Unchecked)
                └── Other Exceptions (Checked)

-   **Object** → Root class of Java.
-   **Throwable** → Parent of all errors and exceptions.
-   **Error** → Serious issues usually outside the program's control.
-   **Exception** → Conditions that programs can handle.

------------------------------------------------------------------------

# 3. Errors vs Exceptions

  -----------------------------------------------------------------------
  Feature                 Errors                  Exceptions
  ----------------------- ----------------------- -----------------------
  Definition              Serious system problems Conditions program can
                                                  handle

  Handling                Generally cannot be     Can be handled
                          handled                 

  Example                 OutOfMemoryError,       IOException,
                          StackOverflowError      NullPointerException
  -----------------------------------------------------------------------

Errors usually indicate problems with the **JVM or system environment**.

------------------------------------------------------------------------

# 4. Checked vs Unchecked Exceptions

## Checked Exceptions

-   Checked **at compile time**
-   Must be **handled or declared using `throws`**
-   If not handled, the program **will not compile**

Example: - IOException - SQLException - FileNotFoundException

Example Code:

``` java
import java.io.*;

class Test {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("test.txt");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
```

------------------------------------------------------------------------

## Unchecked Exceptions

-   Occur at **runtime**
-   Compiler **does not force handling**
-   Subclasses of **RuntimeException**

Examples: - NullPointerException - ArithmeticException -
ArrayIndexOutOfBoundsException

Example:

``` java
int a = 10;
int b = 0;
System.out.println(a / b); // ArithmeticException
```

------------------------------------------------------------------------

# 5. RuntimeException Rule

Any exception that **extends RuntimeException** is an **Unchecked
Exception**.

Example hierarchy:

    RuntimeException
     ├── ArithmeticException
     ├── NullPointerException
     ├── IllegalArgumentException
     └── ArrayIndexOutOfBoundsException

------------------------------------------------------------------------

# 6. try-catch Block

Used to handle exceptions.

Syntax:

``` java
try {
    // risky code
}
catch(ExceptionType e) {
    // handling code
}
```

Example:

``` java
try {
    int a = 10/0;
} catch(ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

------------------------------------------------------------------------

# 7. Multiple Catch Blocks

A single try block can have **multiple catch blocks**.

``` java
try {
    int arr[] = new int[5];
    arr[10] = 50;
}
catch(ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index error");
}
catch(Exception e) {
    System.out.println("General exception");
}
```

Rule: - Catch blocks should go from **most specific → most general**.

------------------------------------------------------------------------

# 8. finally Block

The **finally block always executes** after try/catch regardless of
exception occurrence.

Purpose: - Cleanup code - Closing resources

Example:

``` java
try {
    int a = 10/2;
}
catch(Exception e) {
    System.out.println("Exception occurred");
}
finally {
    System.out.println("Finally always executes");
}
```

Use cases: - Closing files - Closing database connections - Releasing
network sockets

The finally block may not execute only in rare cases: - `System.exit()`
call - JVM crash - Power failure

------------------------------------------------------------------------

# 9. try Variations

Valid combinations:

    try-catch
    try-catch-finally
    try-finally
    try with multiple catch blocks

Invalid:

    finally alone
    catch without try

------------------------------------------------------------------------

# 10. throw Keyword

Used to **explicitly throw an exception**.

Example:

``` java
throw new ArithmeticException("Invalid division");
```

Example program:

``` java
class Test {
    static void checkAge(int age) {
        if(age < 18) {
            throw new ArithmeticException("Not eligible");
        }
    }
}
```

------------------------------------------------------------------------

# 11. throws Keyword

Used in **method declaration**.

It tells the compiler that the method **might throw an exception**.

Example:

``` java
void readFile() throws IOException {
    FileReader file = new FileReader("test.txt");
}
```

Key points: - Used mainly for **checked exceptions** - Shifts
responsibility to the caller

------------------------------------------------------------------------

# 12. throw vs throws

  Feature       throw                        throws
  ------------- ---------------------------- -----------------------------
  Used in       Method body                  Method signature
  Purpose       Explicitly throw exception   Declare possible exceptions
  Usage count   One exception at a time      Multiple exceptions allowed

Example:

``` java
void method() throws IOException, SQLException {
    throw new IOException();
}
```

------------------------------------------------------------------------

# 13. Exception Propagation

If an exception is not handled in a method, it **propagates to the
caller**.

Example:

    method3()
     ↑
    method2()
     ↑
    method1()
     ↑
    main()

If none handle it, JVM terminates the program.

------------------------------------------------------------------------

# 14. Custom Exceptions

Developers can create their own exceptions.

Example:

``` java
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

Usage:

``` java
throw new MyException("Custom error");
```

------------------------------------------------------------------------

# 15. Best Practices

1.  Catch **specific exceptions first**
2.  Avoid catching **Exception blindly**
3.  Always **close resources**
4.  Use **finally or try-with-resources**
5.  Do not use exceptions for normal control flow

------------------------------------------------------------------------

# 16. Try-With-Resources (Java 7+)

Automatically closes resources.

Example:

``` java
try(FileReader fr = new FileReader("file.txt")) {
    int data = fr.read();
}
catch(IOException e) {
    e.printStackTrace();
}
```

No need for finally block.

------------------------------------------------------------------------

# Summary

-   Root class: **Object**
-   Parent of exceptions: **Throwable**
-   Two main types:
    -   **Checked (compile-time)**
    -   **Unchecked (runtime)**

Exception handling tools in Java:

    try
    catch
    finally
    throw
    throws

These mechanisms ensure **program stability, error recovery, and
resource management**.
