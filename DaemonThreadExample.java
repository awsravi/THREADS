package com.threads;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new MyDaemonTask());
        daemonThread.setDaemon(true); // Set the thread as daemon
        daemonThread.start();

        // Main thread
        System.out.println("Main thread exiting");
    }

    static class MyDaemonTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Daemon thread is running");
                    Thread.sleep(1000); // Simulate some work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
