package Polymorphism;
// Полиморфизм - способность метода обрабатывать данные разных типов. Может сделать код меньше и многоразовым
public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Cat(); // Будет доступ к методам Animal, но не Cat. Также вызываться будут методы потомка:
        animal1.eat(); // вместо eat класса Animal возьмет из Cat (позднее связывание, если такой метод есть в потомке)
//        animal1.meow(); // но здесь будет ошибка

        Cat cat1 = new Cat();
        Dog dog1 = new Dog();

        testing(animal1);
        testing(cat1);
        testing(dog1);
    }

    public static void testing(Animal animal) {
        animal.eat();
    }
}
