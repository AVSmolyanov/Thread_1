package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


// Задача 1

        ThreadGroup group = new ThreadGroup("Group1");

        MyThread tst = new MyThread();
        final Thread thread1 = new Thread(group, tst);
        final Thread thread2 = new Thread(group, tst);
        final Thread thread3 = new Thread(group, tst);
        final Thread thread4 = new Thread(group, tst);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(15_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        group.interrupt();

// Задача 2


        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//                Executors.newCachedThreadPool();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        for (int i = 1; i <= 4; i++) {
            callables.add(new MyThreadWithCount());
        }

//        pool.invokeAll(callables);
        String res = pool.invokeAny(callables);
        pool.shutdown();
        System.out.println("Результат самой быстрой задачи: " + res);


    }
}
