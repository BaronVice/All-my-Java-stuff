package LambdaExpressions;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Lambda - is a way to give some piece of code to method.
 * Also, they allow us to use stuff without creating any classes
 * After Java 8, anywhere we had to provide implementation of interface with only one method
 * It's possible to replace it with lambda expression. So, instead of passing an object, that implements method
 * we actually may pass specific implementation we want to use.
 * -
 * Same is for anon classes if we have two or more abstract methods */
public class LambdaExpressions {
    public static void main(String[] args) {
        thirdExample();
    }

    public static void firstExample(){
        Thread thread = new Thread(LambdaExpressions::printGreeting);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        thread.interrupt();
    }
    public static void printGreeting(){
        while (true){
            System.out.println("Hello there!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Fine, give me a second");
                break;
            }
        }
    }

    public static void secondExample(){
        List<Integer> integers = new ArrayList<>(List.of(12, 32, 43, 12, 67, 98, 99));
        List<Integer> evenIntegers = integers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(evenIntegers);
    }

    public static void printThing(Printable statement, String pref, String suf){
        System.out.println(statement.print(pref, suf));
    }

    public static void thirdExample(){
        String prefix = "Lego city engulfed in flames. ",
               suffix = " Build yourself a boat and get the hell out of here!";
        // Weird, but fine by me
        Printable lambdaPrintable = (pref, suf) -> pref + "Hey!" + suf;
        printThing(lambdaPrintable, prefix, suffix);
    }


}
