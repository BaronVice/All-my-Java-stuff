package MultiThreads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerPattern {
    private static final BlockingQueue<Double> queue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(30);
            // put в отличие от offer может подождать элемент
            queue.put(random.nextDouble(0.1, 10) / 3.14);
        }
    }

    private static void consume() throws InterruptedException {
        Random random = new Random();

        while (true){
            Thread.sleep(100);
            if (random.nextInt(6) == 5){
                // take в отличие от poll ждет элемента если в очереди нет элементов
                System.out.println(queue.take());
                System.out.println("Queue size is " + queue.size());
            }

        }

    }
}
