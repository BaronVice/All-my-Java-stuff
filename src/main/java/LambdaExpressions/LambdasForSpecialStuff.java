package LambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class LambdasForSpecialStuff {
    public static void main(String[] args) {
        // Creating array of random ints. 10 elements from -1000 to 1000
        int[] integerArray = IntStream.generate(() -> new Random().nextInt(-1000, 1000))
                                    .limit(10).toArray();

        // Creating list of random ints. 10 elements from -1000 to 1000
        List<Integer> integerList = new Random().ints(10, -1000, 1000)
                                    .boxed().toList();

        // As an option
        // int a[] = new int[10];
        // a = Arrays.stream(a).map(el -> new Random().nextInt(-1000, 1000)).toArray();

        // Map
        integerArray = Arrays.stream(integerArray).map(a -> a + 1).toArray();
        integerList = integerList.stream().map(a -> a + 1).toList();

//        Arrays.stream(integerArray).forEach(System.out::println);
//        integerList.forEach(System.out::println);

        System.out.println(Arrays.toString(integerArray));
        System.out.println(integerList);

        // Filter
        integerArray = Arrays.stream(integerArray).filter(LambdasForSpecialStuff::isPrime).toArray();
        integerList = integerList.stream().filter(LambdasForSpecialStuff::isPrime).toList();

        System.out.println(Arrays.toString(integerArray));
        System.out.println(integerList);

        // Reduce
        List<Integer> listToReduce = new Random().ints(10, -100, 100)
                                    .boxed().toList();
        // First arg is accumulator, second is current element. If identify not given, then first element is taken
        // and iteration goes from second element. Otherwise, it starts from first element and .get is not needed
        int sumOfSquares = listToReduce.stream().reduce(0, (acc, num) -> acc + num * num)/*.get*/;
        System.out.println(sumOfSquares);

    }

    public static boolean isPrime(int number){
        if (number == 2 || number == 3)
            return true;
        if (number <= 1 || number % 2 == 0 || number % 3 == 0)
            return false;
        for (int i = 5; i * i <= number; i += 6)
            if (number % i == 0 || number % (i + 2) == 0)
                return false;

        return true;
    }
}
