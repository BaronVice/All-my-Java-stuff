package MultiThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBlockReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        test.main();
    }
}


class ReentrantLockTest {
    private final Random random = new Random();
    private final List<Integer> firstList = new ArrayList<>();
    private final List<Integer> secondList = new ArrayList<>();

    private final Lock firstListLock = new ReentrantLock();
    private final Lock secondListLock = new ReentrantLock();


    private void work(){
        for (int i = 0; i < 2000; i++){
            addRandomIntToFirstList();
            addRandomIntToSecondList();
        }
    }

    private void addRandomIntToFirstList() {
        if (firstListLock.tryLock()){
            try{
                firstListLock.lock();
                addRandomIntToList(firstList);
            }
            finally {
                firstListLock.unlock();
            }
        }
    }

    private void addRandomIntToSecondList() {
        if (secondListLock.tryLock()){
            try{
                secondListLock.lock();
                addRandomIntToList(secondList);
            }
            finally {
                secondListLock.unlock();
            }
        }
    }

    private void addRandomIntToList(List<Integer> list){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.add(random.nextInt(1000));
    }

    public void main() throws InterruptedException {
        Thread thread1 = new Thread(this::work);
        Thread thread2 = new Thread(this::work);

        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Time: " + (endTime - startTime));
        System.out.println(firstList.size());
        System.out.println(secondList.size());
    }
}
