package MultiThreads;

import java.util.Random;

public class HowInterruptedExceptionWorks {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(HowInterruptedExceptionWorks::someCalculations);

        System.out.println("Start");
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        thread.join();
        System.out.println("End");
    }

    public static void someCalculations(){
        Random random = new Random();
        for(int i = 0; i < 1e9; i++){
//            if (Thread.currentThread().isInterrupted()){
//                System.out.println("Hey, looks like we are done here");
//                break;
//            }
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("I was sleeping you smart boy");
                break;
            }
            Math.sin(random.nextDouble());
        }
    }
}

