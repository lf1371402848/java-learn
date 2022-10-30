import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/27 21:48
 * @Version: 1.0
 */
public class CreateThread {
    public static void main(String[] args) {
        //1.继承Thread类
        Thread thread = new CreateThread01();
        thread.start();

        //1.1匿名内部类方式
        new CreateThread01() {
            @Override
            public void run() {
                System.out.println("匿名内部类线程创建方式01");
            }
        }.start();

        //2.实现Runnable接口
        CreateThread02 runnableThread = new CreateThread02();
        Thread thread2 = new Thread(runnableThread);
        thread2.start();

        //2.1匿名内部类方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类线程创建方式02");
            }
        }).start();

        new Thread(() -> System.out.println("匿名内部类线程-lambda-创建方式02")).start();

        //3.实现Callable接口
        Callable<Integer> callable = new CreateThread03();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
    }
}

class CreateThread01 extends Thread {

    @Override
    public void run() {
        System.out.println("线程创建方式01");
        ;
    }
}

class CreateThread02 implements Runnable {

    @Override
    public void run() {
        System.out.println("线程创建方式02");
        ;
    }
}

class CreateThread03 implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("线程创建方式03");
        ;
        return null;
    }
}
