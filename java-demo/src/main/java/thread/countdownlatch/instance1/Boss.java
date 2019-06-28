package thread.countdownlatch.instance1;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/28 15:58
 * @Version 1.0
 **/
public class Boss implements Runnable {
    private final CountDownLatch signal;
    private final String name;

    public Boss(CountDownLatch signal, String name) {
        this.signal = signal;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Boss" + this.name + " will waiting and check after all finish");
            signal.await();
            check();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void check() {
        System.out.println("Everyone has finished task and boss " + name + " start checking .");
    }
}
