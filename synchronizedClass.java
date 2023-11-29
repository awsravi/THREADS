package com.threads;
public class synchronizedClass {
    private int sharedCounter = 0;

    // Synchronized block to protect the shared resource
    public void incrementCounter() {
        synchronized (this) {
            sharedCounter++;
            System.out.println(Thread.currentThread().getName() + ": Counter = " + sharedCounter);
        }
    }

    public static void main(String[] args) {
        synchronizedClass sharedResource = new synchronizedClass();

        // Create multiple threads that access the shared resource
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.incrementCounter();
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
