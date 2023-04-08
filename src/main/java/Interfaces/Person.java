package Interfaces;

public class Person implements Info {
    public String name;

    public Person(String name){
        this.name = name;
    }

    public void showInfo(){
        System.out.println(String.format("Well so you asked, my name is %s", this.name));
    }

    public void sayHello(){
        System.out.println("Hey");
    }
}
