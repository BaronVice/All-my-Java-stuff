package MultiThreads;

import java.util.Scanner;

import static java.lang.Thread.sleep;

/** volatile - ключевое слово, когда одна переменная делится между несколькими потоками
 * (когда один поток пишет в переменную, другой ее считывает)
 * Если потоки распределились между разными процессорами, то при плохой когерентности кешей
 * изменения в главной памяти могут не произойти; volatile переменная не кешируется и все ядра
 * знают про значение этой переменной */
public class VolatileThread {
    public static void main(String[] args) {
        RunnerWithVolatile thread = new RunnerWithVolatile();
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        thread.shutDown();
    }
}

class RunnerWithVolatile extends Thread {
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while(isRunning){
            System.out.println("I need some sleep");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutDown(){
        this.isRunning = false;
    }
}
