package MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolOfThreads {
    public static AtomicInteger a = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        // Пул из двух потоков
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10000000; i++)
            // Задаем потокам работу
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    a.incrementAndGet();
                }
            });

        // Начинаем исполнение заданий
        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println(a);
    }
}

class Worker implements Runnable {

    private final int id;

    public Worker(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " was completed");
    }
}
