package MultiThreads.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {
    /**
     * Запуск паттерна ProducerConsumer
     */
    public static void start(){
        // Объект, на котором будет синхронизация
        Lock lock = new ReentrantLock();
        // Буффер
        Queue<Double> queue = new LinkedList<>();
        // Notify для producer
        Condition needToProduce = lock.newCondition();
        // Notify для consumer
        Condition needToConsume = lock.newCondition();
        // Лимит буффера
        int queueLimit = 3;
        // Количество элементов для генерации/поглощения
        int amount = 1000;

        Producer p = new Producer(
                lock,
                needToProduce,
                needToConsume,
                queue,
                queueLimit,
                amount
        );
        Consumer c = new Consumer(
                lock,
                needToProduce,
                needToConsume,
                queue,
                amount
        );

        Thread producer = new Thread(p);
        Thread consumer = new Thread(c);

        producer.start();
        consumer.start();
    }
}
