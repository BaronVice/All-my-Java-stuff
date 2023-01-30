package MultiThreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** CountDownLatch - засов обратного отсчета */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        // Количество итераций, после которых засов откроется
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // Вместо отдельного создание потоков лучше создать ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++)
            executorService.submit(new Processor(i, countDownLatch));

        executorService.shutdown();

        for (int i = 0; i < 3; i++){
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}

class Processor implements Runnable{
    private final int id;
    private final CountDownLatch countDownLatch;

    public Processor(int id, CountDownLatch countDownLatch){
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Hi, my name is %d and now my execution is going on%n", this.id);
    }
}