package com.company;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        int m = (int) (Math.random() * 6)+1;
        for (i = 0; i < m; i++) {
            System.out.println("Всем привет! Это " + Thread.currentThread().getName());
        }
        return (Integer) i;
    }
}
