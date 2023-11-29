package com.threads;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadWithoutRunnableOrThread {
    public static void main(String[] args) {
        // Create a Callable task
        Callable<String> callableTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getId() + " Value " + i);
            }
            return "Task completed";
        };

        // Create a FutureTask with the Callable task
        FutureTask<String> futureTask = new FutureTask<>(callableTask);

        // Create a new thread and pass the FutureTask to it
        Thread thread = new Thread(futureTask);

        // Start the thread
        thread.start();

        try {
            // Wait for the thread to finish and get the result
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
