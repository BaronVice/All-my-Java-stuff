package MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolOfThreads {
    public static void main(String[] args) throws InterruptedException {
        // Пул из двух потоков
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++)
            // Задаем потокам работу
            executorService.submit(new Worker(i));

        // Начинаем исполнение заданий
        executorService.shutdown();
        // Ждем завершения выполнения
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Damn it is slow");
    }
}

class Worker implements Runnable {

    private final int id;

    public Worker(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Task " + id + " was completed");
    }
}
