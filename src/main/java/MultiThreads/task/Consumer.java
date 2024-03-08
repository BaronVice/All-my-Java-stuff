package MultiThreads.task;

import lombok.AllArgsConstructor;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Consumer implements Runnable{
    private final Lock lock;
    private final Condition needToProduce;
    private final Condition needToConsume;
    private final Queue<Double> buffer;
    private int amount;

    @Override
    public void run() {
        // Номер текущего элемента
        int i = 0;
        double sum = 0;
        while (amount-- > 0) {

            lock.lock();
            try {
                // Если из буффера нечего поглощать - ставим поток в await
                while (buffer.size() == 0)
                    needToConsume.await();

                // Иначе добавляем элемент в сумму
                sum += buffer.poll();
                System.out.printf("Consume thread[%d]: sum is %f.%n", i++, sum);

                // И делаем notify для потока producer
                needToProduce.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
