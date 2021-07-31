package com.test.ThreadTest.Create_Thread_Way;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Way03_Callable implements Callable<Integer> {
    public static void main(String[] args) {
        Callable<Integer> way03 =new Way03_Callable();
        FutureTask<Integer> futureTask = new FutureTask<>(way03);
        new Thread(futureTask).start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return null;
    }
}
