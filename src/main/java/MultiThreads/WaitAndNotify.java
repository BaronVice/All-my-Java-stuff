package MultiThreads;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Методы в классе Object лежат методы для синхронизации потоков
 * wait вызывается в пределах синхронизованного блока и на синхронизируемом объекте (вне блока не имеет смысла)
 * При вызове wait() - отдаем intrinsic lock (забираем ключ), ждем пока будет вызван notify()
 * При вызове notify() монитор не освобождается, поэтому ждущий поток не продолжает выполнение */
public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitNotify waitNotify = new WaitNotify();
        waitNotify.main();
    }
}

class WaitNotify {

    private void produce() {
        synchronized (this){
            System.out.println("Producer called");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Producer continued execution");
        }
    }

    private void consume(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for return key to continue produce...");
            scanner.nextLine();
            notifyAll(); // Все потоки, которые ждут проснутся
        }

    }

    public void main() throws InterruptedException {
        Thread producerThread = new Thread(this::produce);
        Thread consumerThread = new Thread(this::consume);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}
