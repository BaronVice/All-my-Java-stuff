package MultiThreads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerRealization {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerReentrantLock pattern = new ProducerConsumerReentrantLock();
        pattern.main();
    }
}


class ProducerConsumerReentrantLock{
    private final Queue<Integer> integerQueue = new LinkedList<>();
    private final int QUEUE_LIMIT = 10;
    private final Random random = new Random();

    private final Lock lock = new ReentrantLock();
    private final Condition needToProduce = lock.newCondition();
    private final Condition needToConsume = lock.newCondition();

    private boolean work = true;

    public void produce() {
        while (work){
            createTimeInterval();

            lock.lock();
            try {
                while (integerQueue.size() == QUEUE_LIMIT)
                    needToProduce.await();

                integerQueue.offer(random.nextInt(100));
                needToConsume.signal();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume(){
        while (work) {
            createTimeInterval();

            lock.lock();
            try {
                while (integerQueue.size() == 0)
                    needToConsume.await();

                System.out.println("Taken element: " + integerQueue.poll());
                System.out.println("Now queue size is " + integerQueue.size());

                needToProduce.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }
    }

    public void createTimeInterval(){
        try {
            Thread.sleep(random.nextInt(300, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutDown(){
        work = false;
    }

    public void main() throws InterruptedException {
        Thread consumer = new Thread(this::consume);
        Thread producer = new Thread(this::produce);

        consumer.start();
        producer.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        shutDown();
    }
}
