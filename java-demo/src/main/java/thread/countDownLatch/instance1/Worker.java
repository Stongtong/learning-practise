package thread.countDownLatch.instance1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/28 15:58
 * @Version 1.0
 **/
public class Worker implements Runnable {

    private final CountDownLatch doneSignal;

    private final String name;


    Worker(CountDownLatch doneSignal, String name) {
        this.doneSignal = doneSignal;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker " + name + " start work");
            doWork(name);
            System.out.println("Worker " + name + " work finish !!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            doneSignal.countDown();
        }
    }


    void doWork(String name) throws InterruptedException {
        System.out.println("Worker " + name + " is working . . .");
        Thread.sleep(new Random().nextInt(10) * 1000);
    }
}
