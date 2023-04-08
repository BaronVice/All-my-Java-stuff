package InheritExample;

public class Dog extends Animal {
    // SingleClasses.Constructors
    public Dog(){
        this.name = "Unknown";
    }
    public Dog(String name){
        this.name = name;
    }

    // Other functions
    public void eat(){
        System.out.println("I'm eating drumstick (nothing common with music)");
    }
    public void bark(){
        System.out.println("Bark-Bark!");
    }
}
