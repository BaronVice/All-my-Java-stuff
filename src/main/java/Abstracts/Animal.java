package Abstracts;
// Интерфейс - то, что класс умеет делать
// Абстракт - то, чем класс является
public abstract class Animal {
    // Все животные едят одинаково
    public void eat(){
        System.out.println("And now food is gone");
    }
    // Абстрактный метод не имеет тела
    // Но все животные издают разные звуки
    public abstract void makeSound();
}
