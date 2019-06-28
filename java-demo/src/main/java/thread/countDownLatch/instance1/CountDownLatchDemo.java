package thread.countDownLatch.instance1;

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
        service.shutdown();
    }
}
