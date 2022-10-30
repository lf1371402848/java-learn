import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/27 23:41
 * @Version: 1.0
 */
public class LockTest extends Thread{
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        System.out.println("测试lock锁");
        lock.unlock();
    }

    public static void main(String[] args) {
        new LockTest().start();
    }
}
