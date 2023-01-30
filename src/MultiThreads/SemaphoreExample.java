package MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/** Используется когда у нас есть ресурс, который используют много потоков и мы хотим ограничить
 * доступ к ресурсу (много потоков взаимодействует с сервером и из-за пропускной способности кабеля
 * надо как-то делить сервер) */
public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        /*
        Semaphore semaphore = new Semaphore(3);

        // Пробует забрать разрешение, или если нет будет ждать
        semaphore.acquire();
        // Поток отдает забранное разрешение
        semaphore.release();
        // Количество свободных разрешений
        semaphore.availablePermits();
        */

        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++)
            executorService.submit(Connection.getConnection()::takeAccess);

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Hey");
    }
}

class Connection{

    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore permitsToConnect = new Semaphore(10);


    // Singleton - for one socket or DB connection
    private Connection(){

    }

    public static Connection getConnection(){
        return connection;
    }

    public void takeAccess(){
        try {
            permitsToConnect.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try{
            connectToDataBase();
        }
        finally {
            permitsToConnect.release();
        }
    }

    private void connectToDataBase() {
        synchronized (this){
            connectionsCount++;
            System.out.println(connectionsCount);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this){
            connectionsCount--;
        }
    }
}
