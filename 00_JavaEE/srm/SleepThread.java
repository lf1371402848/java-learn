/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/27 22:48
 * @Version: 1.0
 */
public class SleepThread extends Thread{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new SleepThread();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("测试sleep");
    }
}
