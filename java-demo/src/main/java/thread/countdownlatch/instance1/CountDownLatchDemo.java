package thread.countdownlatch.instance1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/28 15:58
 * @Version 1.0
 **/
public class CountDownLatchDemo {
    private static final int N = 10;

    public static void main(String[] args) {
        CountDownLatch signal = new CountDownLatch(N);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < N; i++) {
            service.execute(new Worker(signal, "wang" + i));
        }
        service.execute(new Boss(signal, "tong"));
        // 在减成0以后，如果再进行任务数的提交，就没有1等多的效果了，这个也很好了解,没有cyclicbarrier中的reset和自动reset
        service.shutdown();
    }
}
