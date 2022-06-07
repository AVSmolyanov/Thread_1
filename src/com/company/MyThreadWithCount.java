package com.company;

import java.util.concurrent.Callable;

public class MyThreadWithCount implements Callable {

    @Override
    public String call() throws Exception {
        int i = 0;
        int m = (int) Thread.currentThread().getId();
        for (i = 0; i < m; i++) {
            System.out.println("Всем привет! Это " + Thread.currentThread().getName());
        }
        return Thread.currentThread().getName() + " = " + Integer.toString(i) + " сообщений";
    }
}

