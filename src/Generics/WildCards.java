package Generics;


import UpCastDownCast.Animal;
import UpCastDownCast.Dog;

import java.util.ArrayList;
import java.util.List;

public class WildCards {
    public static void main(String[] args) {
        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(123));
        listOfAnimal.add(new Animal(124));
        test(listOfAnimal);

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());
        test(listOfDogs);
    }

    // ? List для любых объектов (Здесь только для Animal и его наследников)
    public static void test(List<? extends Animal> list){ // поставив super вместо extends - будут Animals и выше
        for (Animal animal : list) {
            System.out.println(animal);
        }
    }
}


