package Interfaces;

public class Animal implements Info {
    public int id;

    public Animal(int id){
        this.id = id;
    }

    public void showInfo(){
        System.out.println(String.format("This animal id: %d", this.id));
    }

    public void sleep(){
        System.out.println("I need some sleep, it can't go on like this");
    }
}
