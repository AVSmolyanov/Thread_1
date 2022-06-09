package com.company;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


 // Задача 1
//
//        ThreadGroup group = new ThreadGroup("Group1");
//
//        MyThread tst = new MyThread();
//        final Thread thread1 = new Thread(group, tst);
//        final Thread thread2 = new Thread(group, tst);
//        final Thread thread3 = new Thread(group, tst);
//        final Thread thread4 = new Thread(group, tst);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//
//        try {
//            Thread.sleep(15_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        group.interrupt();

//  Задача 2


        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Callable<Integer> list[] = new MyCallable[4];

        for (int i = 0; i < list.length; i++) {
            list[i] = new MyCallable();
        }

        pool.invokeAll(Arrays.stream(list).toList());
        Integer res = pool.invokeAny(Arrays.stream(list).toList());
        pool.shutdown();
        System.out.println("Результат самой быстрой задачи: " + res);
    }
}
