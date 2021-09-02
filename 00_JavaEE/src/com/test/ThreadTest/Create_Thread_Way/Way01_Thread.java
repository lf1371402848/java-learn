package com.test.ThreadTest.Create_Thread_Way;

public class Way01_Thread extends Thread{
    public static void main(String[] args) {
        Way01_Thread thread = new Way01_Thread();
        thread.start();

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
