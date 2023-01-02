package Generics;

import java.util.ArrayList;
import java.util.List;

public class Parametrization {
    public static void main(String[] args) {
        ///////////// Before Java 5 /////////////
        List animals = new ArrayList();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        String message1 = (String) animals.get(0); // Downcast
        System.out.println(message1);

        ////// After Java 5 with generics //////
        List<String> betterAnimals = new ArrayList<String>();
        betterAnimals.add("cat");
        betterAnimals.add("dog");
        betterAnimals.add("frog");
        String message2 = betterAnimals.get(2);
        System.out.println(message2);

        ///////////// After Java 7 /////////////
        List<String> bestAnimals = new ArrayList<>();

    }
}
