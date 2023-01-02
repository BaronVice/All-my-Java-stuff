package InheritExample;

public class Inheritance {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        animal1.eat();
        animal1.sleep();

        System.out.println();

        Dog dog1 = new Dog();
        dog1.eat();
        dog1.sleep();
        dog1.bark();
        dog1.setName("Tedd");

        System.out.println(dog1.getName());

    }
}
