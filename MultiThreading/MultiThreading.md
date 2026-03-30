
# Java Multithreading Notes

## What is a Thread?
A **thread** is a lightweight unit of execution within a process.  
A process can contain multiple threads that run concurrently and share the same memory space.

- Each thread has its **own execution path (call stack)**.
- Threads share **heap memory** with other threads in the same process.

In Java, every program starts with a **main thread**.

Execution begins from:
```java
public static void main(String[] args)
```

The program ends when all **non-daemon threads finish execution**.

---

## Why Do We Need Multithreading?

Example operations:
```text
getDataFromDB();
getDataFromSocket();
getDataFromFile();
```

If executed sequentially:

1. DB fetch completes
2. Socket fetch starts
3. File fetch starts

This wastes time because these tasks are **independent**.

With multithreading:

- Each task can run **in parallel**
- System resources are utilized better
- Overall response time improves

---

## Example: Web Server Handling Clients

Without multithreading:

```
Client 1 request -> processed
Client 2 waits
Client 3 waits
```

With multithreading:

```
Thread 1 -> Client 1
Thread 2 -> Client 2
Thread 3 -> Client 3
```

Each client request runs in **its own thread**.

---

# Ways to Create Threads in Java

## 1. Extending the Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
```

Usage:

```java
MyThread t = new MyThread();
t.start();
```

---

## 2. Implementing Runnable Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running");
    }
}
```

Usage:

```java
Thread t = new Thread(new MyRunnable());
t.start();
```

---

## Why Runnable is Preferred

1. Java does **not support multiple inheritance**.  
   If we extend `Thread`, we cannot extend another class.

2. Runnable separates **task definition** from **thread execution**.

3. Runnable allows better **code reuse and flexibility**.

4. Runnable is a **Functional Interface**, meaning it has only one abstract method (`run()`).
   This allows usage with **Lambda expressions**.

Example:

```java
Thread t = new Thread(() -> {
    System.out.println("Lambda Thread");
});
t.start();
```

---

# Difference Between start() and run()

## start()

- Creates a **new thread**
- JVM schedules the thread
- Internally calls `run()`

Example:

```java
t.start();
```

Execution happens in **separate thread**.

---

## run()

- Normal method call
- Does **not create a new thread**

Example:

```java
t.run();
```

Execution happens in **main thread**.

---

# Why Override run()?

`Thread` implements the `Runnable` interface.

Runnable interface:

```java
public interface Runnable {
    void run();
}
```

The default implementation does **nothing**.

Therefore, we override `run()` to define **what the thread should execute**.

If a class implements Runnable but does not implement `run()`, we get a **compile-time error** unless the class is declared `abstract`.

---

# Thread Lifecycle

A thread goes through several states:

1. **New** – Thread object created
2. **Runnable** – Ready to run
3. **Running** – Currently executing
4. **Blocked / Waiting** – Waiting for resource
5. **Terminated** – Execution finished

---

# Important Thread Methods

## sleep()

Pauses thread execution.

```java
Thread.sleep(1000);
```

Thread sleeps for **1 second**.

---

## join()

Used when one thread must wait for another thread to finish.

Example:

```java
t1.start();
t1.join();
```

Main thread waits until `t1` completes.

---

## yield()

Hints the scheduler to pause current thread and allow others to execute.

---

## getName() / setName()

Used to manage thread names.

```java
t.setName("WorkerThread");
```

---

## activeCount()

Returns number of active threads in current thread group.

---

# Daemon Threads

Daemon threads run in the **background** and support other threads.

Example:

- Garbage Collector
- Background services

Example:

```java
t.setDaemon(true);
```

Daemon threads terminate automatically when **all user threads finish**.

---

# Thread Priority

Each thread has a priority from **1 to 10**.

Constants:

```
Thread.MIN_PRIORITY = 1
Thread.NORM_PRIORITY = 5
Thread.MAX_PRIORITY = 10
```

Higher priority means the thread has a **higher chance of CPU scheduling**.

Example:

```java
t.setPriority(Thread.MAX_PRIORITY);
```

---

# Synchronization

Problem:

If multiple threads access a shared resource simultaneously, it can cause **data inconsistency**.

Example:

4 threads accessing same resource.

Solution: **Synchronization**

```java
synchronized void updateData() {
    // critical section
}
```

This ensures **only one thread executes this block at a time**.

---

# Types of Synchronization

## 1. Method Level Synchronization

```java
synchronized void method() {}
```

## 2. Block Level Synchronization

```java
synchronized(this) {
   // critical code
}
```

Block synchronization gives **better performance**.

---

# Real World Multithreading Example

Example: **Organizing a College Event**

Tasks happening simultaneously:

- Registration team
- Stage management
- Technical setup
- Food arrangement
- Participant coordination

Each task runs independently but contributes to the **same event**.

This is similar to **threads executing concurrently within one process**.

---

# Thread Safety

A class is thread-safe if:

- Multiple threads can access it
- Without causing inconsistent results

Techniques:

- Synchronization
- Immutable objects
- Atomic variables

---

# Executor Framework (Modern Way)

Instead of manually creating threads:

Use **ExecutorService**.

Example:

```java
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submit(() -> System.out.println("Task running"));
executor.shutdown();
```

Advantages:

- Better thread management
- Thread pooling
- Resource optimization

---

# Summary

Threads allow:

- Concurrent execution
- Better resource utilization
- Faster applications
- Efficient server handling

Multithreading is essential for:

- Web servers
- Database operations
- Network communication
- Background processing

