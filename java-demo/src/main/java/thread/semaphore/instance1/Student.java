package thread.semaphore.instance1;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description 本例中模拟食堂打饭的例子，食堂有两个窗口，50个人打饭，
 * 有部分人会一直等，有部分人等的嫌弃时间太长会直接放弃，有部分人收到聚餐
 * 消息也会直接放弃。
 * @Author tong
 * @Date 2019/6/28 17:14
 * @Version 1.0
 **/
public class Student implements Runnable {
    private final Semaphore semaphore;
    private final String name;
    private final int type;

    public Student(Semaphore semaphore, String name, int type) {
        this.semaphore = semaphore;
        this.name = name;
        this.type = type;
    }

    @Override
    public void run() {
        switch (type) {
            case 1:
                try {
                    goodBoy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    badBoy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    luckBoy();
                } catch (InterruptedException e) {
                    System.out.println("lucky boy " + name + "去吃大餐。");
                }
                break;
            default:
                return;
        }

    }

    private void goodBoy() throws InterruptedException {
        semaphore.acquireUninterruptibly();
        Thread.sleep(new Random().nextInt(10) * 1000);
        System.out.println("good boy " + name + "打到了饭。");
        semaphore.release();
    }

    private void badBoy() throws InterruptedException {
        if (semaphore.tryAcquire(5, TimeUnit.SECONDS)) {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("bad boy " + name + "打到了饭。");
            semaphore.release();
        } else {
            System.out.println("bad boy " + name + "回寝室吃XX");
        }
    }

    private void luckBoy() throws InterruptedException {
        semaphore.acquire();
        Thread.sleep(new Random().nextInt(10) * 1000);
        System.out.println("lucky boy " + name + "打到了饭。");
        semaphore.release();
    }
}
