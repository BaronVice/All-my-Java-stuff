package UpCastDownCast;

public class Test {
    public static void main(String[] args) {
        // Upcast - восходящее преобразование от наследника к родителю (рассматриваем объект как родителя)
        Animal animal1 = new Dog();

        // Downcast - нисходящее преобразование (небезопасно)
        Dog dog1 = (Dog) new Animal(12);

        Animal animal = new Animal(23);
        Dog dog = (Dog) animal;
        dog.bark(); // Ошибка

    }
}
