package InheritExample;

public class Animal {
    // Vars
    protected String name;

    // SingleClasses.Constructors
    public Animal(){
        this.name = "Unknown";
    }
    public Animal(String name){
        this.name = name;
    }

    // Setters
    public void setName(String name){ this.name = name; }

    // Getters
    public String getName(){
        return name;
    }

    // Other functions
    public void eat(){
        System.out.println("I'm eating");
    }
    public static void sleep(){
        System.out.println("I'm sleeping");
    }
}
