package MultiThreads;

/** Основная цель многопоточного программирования - реализовать какой-то функционал
 * (обработка сложных задач в фоновом режиме, загрузка данных, веб-сервера и т.д.)
 * Потоки не синхронизируются.
 * Чтобы избежать InterruptedException лучше использовать SystemClock.sleep() или вовсе не пользоваться sleep
 * Поток завершится при условии отсутствия кода для исполнения
 * и исполняемых потоков, запущенных от текущего */
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("first");
        // start - потому что он запускает параллельный поток
        myThread1.start();

        MyThread myThread2 = new MyThread("second");
        myThread2.start();

        Thread.sleep(2000);
        myThread1.interrupt();
        Thread.sleep(2000);
        myThread2.interrupt();

        Thread thread = new Thread(new Runner());
        thread.start();
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        System.out.println("""
                I am a Runner created with Runnable
                My realization is better:
                1) can implement other interfaces
                2) still able to extend some class
                """);
    }
}

class MyThread extends Thread {
    private final String threadName;

    public MyThread(String threadName){
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from " + threadName);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted");
            }
        }
    }
}