package MultiThreads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerRealization {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerReentrantLock pattern = new ProducerConsumerReentrantLock(1000, 3);
        pattern.main();
    }
}


class ProducerConsumerReentrantLock{
    private volatile Queue<Double> doubleQueue;
    private final int queueLimit;
    private final Random random;
    private volatile Lock lock;
    private volatile Condition needToProduce;
    private volatile Condition needToConsume;
    private volatile int work;

    public ProducerConsumerReentrantLock(int amountToGenerate, int limit){
        doubleQueue = new LinkedList<>();
        random = new Random();
        lock = new ReentrantLock();
        needToProduce = lock.newCondition();
        needToConsume = lock.newCondition();

        this.queueLimit = limit;
        this.work = amountToGenerate;
    }

    public void produce() {
        int amount = work;
        int i = 0;
        while (amount-- > 0){
            lock.lock();
            try {
                while (doubleQueue.size() == queueLimit)
                    needToProduce.await();

                double num = random.nextDouble(0.1, 10) / 3.14;
                System.out.printf("Produce thread[%d]: generated number %f.%n", i++, num);
                doubleQueue.offer(num);
                needToConsume.signal();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume(){
        int amount = work;
        int i = 0;
        double sum = 0;
        while (amount-- > 0) {

            lock.lock();
            try {
                while (doubleQueue.size() == 0)
                    needToConsume.await();

                sum += doubleQueue.poll();
                System.out.printf("Consume thread[%d]: sum is %f.%n", i++, sum);

                needToProduce.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void main() throws InterruptedException {
        Thread consumer = new Thread(this::consume);
        Thread producer = new Thread(this::produce);

        consumer.start();
        producer.start();
    }
}
