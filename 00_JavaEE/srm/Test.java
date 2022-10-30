import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/10/4 22:49
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //创建数量固定的线程池,线程池数量为3
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
