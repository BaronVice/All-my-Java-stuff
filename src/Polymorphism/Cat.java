package Polymorphism;

public class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("Cat food now gone");
    }

    public void meow(){
        System.out.println("Meow");
    }
}
