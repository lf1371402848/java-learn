package com.test.ThreadTest.Create_Thread_Way;

public class Way02_Runnable implements Runnable {
    public static void main(String[] args) {
        Way02_Runnable way02 = new Way02_Runnable();
        new Thread(way02).start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
