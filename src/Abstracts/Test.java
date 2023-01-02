package Abstracts;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        // Абстракции используются при создании иерархии классов и указании, что родительский класс несамостоятельный
        // Animal animal1 = new Animal(); - поскольку Animal абстракция, то теперь его нельзя инициализировать
        Animal animal1 = new Cat();
    }
}
