package MultiThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.main();
    }
}


class Test{
    Random random = new Random();

    private final Object list1Lock = new Object();
    private final Object list2Lock = new Object();

    // Посмотри позже результат с размерностью
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    private void addToList1(){
        synchronized (list1Lock){
            addIntegerToList(list1);
        }
    }

    private void addToList2(){
        synchronized (list2Lock){
            addIntegerToList(list2);
        }
    }

    private void addIntegerToList(List<Integer> list){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.add(random.nextInt(1000));
    }

    private void work(){
        for (int i = 0; i < 1000; i++){
            addToList1();
            addToList2();
        }
    }

    public void main() throws InterruptedException {
        Thread thread1 = new Thread(this::work);
        Thread thread2 = new Thread(this::work);

        long start = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long stop = System.currentTimeMillis();

        System.out.println("Time: " + (stop - start));
        System.out.println(list1.size());
        System.out.println(list2.size());
    }
}
