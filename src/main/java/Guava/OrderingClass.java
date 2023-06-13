package Guava;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Ordering - Comparator with wider functionality (there is even a method with bin search algo) */
public class OrderingClass {
    public static void main(String[] args) {
        List<Integer> list = intListGenerator(20);

        Ordering<Integer> natural = Ordering.natural().reverse();
        Ordering<Object> arbitrary = Ordering.arbitrary();

        System.out.println(list);
        list.sort(natural);
        System.out.println(list);
        list.sort(arbitrary);
        System.out.println(list);
    }

    public static List<Integer> intListGenerator(int size){
        Random random = new Random();
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            list.add(random.nextInt(1, 10));

        return list;
    }
}
