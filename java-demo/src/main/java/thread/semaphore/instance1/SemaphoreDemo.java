package thread.semaphore.instance1;

import java.util.concurrent.Semaphore;

/**
 * @Description semaphore直译过来是信号量，其实质是许可管理器，用来管理可用的资源，
 * 并且整个过程是阻塞的
 * @Author tong
 * @Date 2019/6/28 17:00
 * @Version 1.0
 **/
public class SemaphoreDemo {
    private static Semaphore semaphore = new Semaphore(2, true);

    public static void main(String[] args) throws InterruptedException {
        Thread[] students101 = new Thread[5];
        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                new Thread(new Student(semaphore, "打饭学生" + i, 1)).start();
            } else if (i >= 10 && i < 15) {
                new Thread(new Student(semaphore, "泡面学生" + i, 2)).start();
            } else {
                students101[i - 15] = new Thread(new Student(semaphore, "聚餐学生" + i, 3));
                students101[i - 15].start();
            }
        }
        //
        Thread.sleep(5000);
        for (int i = 0; i < 5; i++) {
            students101[i].interrupt();
        }

    }


}
