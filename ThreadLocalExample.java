package com.threads;
public class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();

    public static void main(String[] args) {
        // Set a value for the current thread
        threadLocalValue.set(42);

        // Access the value for the current thread
        int value = threadLocalValue.get();
        System.out.println("Thread-local value: " + value);

        // Each thread has its own copy of the thread-local variable
        Thread anotherThread = new Thread(() -> {
            threadLocalValue.set(99);
            int anotherThreadValue = threadLocalValue.get();
            System.out.println("Thread-local value in another thread: " + anotherThreadValue);
        });
        anotherThread.start();
    }
}
