package thread.cyclicBarrier.instance1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/28 16:24
 * @Version 1.0
 **/
public class CyclicBarrierDemo {
    private static final int N = 10;

    public static void main(String[] args) {
        CyclicBarrier signal = new CyclicBarrier(N);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < N; i++) {
            service.execute(new Student(signal, "xiaoli" + i));
        }
        System.out.println("-----------again-------------");
        signal.reset();
        for (int i = 0; i < N; i++) {
            service.execute(new Student(signal, "liming" + i));
        }
        service.shutdown();
    }
}
