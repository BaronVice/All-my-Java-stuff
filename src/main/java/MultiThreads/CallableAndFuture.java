package MultiThreads;

import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.*;

/** Callable и Future позволяют возвращать значения и исключения из потоков. Callable - поток,
 * который умеет return. Future дает доступ к результату */
public class CallableAndFuture {
    private static int number = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 12; i++){
            // Inside lambda, it's hard to say which interface method we implement,
            // However, Java can figure itself by what type of return do we use
            // So here we return something, it means that we've implemented method of Callable.
            Future<Integer> result = executorService.submit(() -> {
                System.out.println("Start");
                Thread.sleep(300);
                number++;
                System.out.println("Finish");
                if (number % 5 == 0)
                    throw new Exception("What a number it is");
                return number;
            });

            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getCause().getMessage());
            }
        }


        executorService.shutdown();

        try{
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
