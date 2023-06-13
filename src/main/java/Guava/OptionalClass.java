package Guava;


import java.util.Optional;

/** Optional - thing to avoid null checks and therefore, make code more neat (since Java 8)
 * There minor differences between google.base and java.util Optional, but their purpose are the same

 * - From guava docs it's more preferable to use Java's Optional - so I'll use java.util.Optional */
public class OptionalClass {
    public static void main(String[] args) {

        Optional<Integer> firstNumber = Optional.empty();
        Optional<Integer> secondNumber = Optional.of(123);

        System.out.println(OptionalClass.test(firstNumber));
        System.out.println(OptionalClass.test(secondNumber));
        System.out.println(OptionalClass.test(firstNumber, secondNumber));
    }

    @SafeVarargs
    public static int test(Optional<Integer>... arr){
        int s = 0;
        for (Optional<Integer> a: arr) {
            if (a.isPresent())
                s += a.get();
        }

        return s;
    }
}
