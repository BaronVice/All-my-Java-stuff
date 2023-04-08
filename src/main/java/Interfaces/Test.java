package Interfaces;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(123);
        Person person1 = new Person("John");

//        animal1.showInfo();
//        person1.showInfo();

//        Info info1 = new InheritExample.Animal(1);
//        Info info2 = new Person("Bob");
//        info1.showInfo();
//        info2.showInfo();

        outputInfo(animal1);
        outputInfo(person1);
    }

    public static void outputInfo(Info info){
        info.showInfo();
    }
}
