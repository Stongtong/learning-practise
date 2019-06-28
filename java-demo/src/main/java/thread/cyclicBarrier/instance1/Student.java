package thread.cyclicBarrier.instance1;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/28 16:19
 * @Version 1.0
 **/
public class Student implements Runnable {

    private final CyclicBarrier signal;
    private final String name;

    public Student(CyclicBarrier signal, String name) {
        this.signal = signal;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            afterSchool();
            signal.await();
            System.out.println("Everyone is here and go home;");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void afterSchool() throws InterruptedException {
        Thread.sleep(new Random().nextInt(10 * 1000));
        System.out.println(name + " is after school and waiting others " + signal.getNumberWaiting() + ".");
    }
}
