package MultiThreads.task;

import lombok.AllArgsConstructor;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Producer implements Runnable{
    private static final Random random = new Random();
    private final Lock lock;
    private final Condition needToProduce;
    private final Condition needToConsume;
    private final Queue<Double> buffer;
    private final int queueLimit;
    private int amount;

    @Override
    public void run() {
        // Номер текущего элемента
        int i = 0;
        while (amount-- > 0){
            lock.lock();
            try {
                // Если достигли лимита буффера - ставим поток в await
                while (buffer.size() == queueLimit)
                    needToProduce.await();

                // Иначе генерируем элемеет
                double num = random.nextDouble(0.1, 10) / 3.14;
                System.out.printf("Produce thread[%d]: generated number %f.%n", i++, num);
                buffer.offer(num);
                // И делаем notify для потока consumer
                needToConsume.signal();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
