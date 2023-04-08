package AnonimClass;

interface AbleToEat{
    public void eat();
}

abstract class Heh{
    protected abstract void poop();
    protected abstract void eat();
}

// Interfaces and abstract classes can be implemented by lambdas or anon subclass
public class Test {
    public static void main(String[] args) {
        AbleToEat ableToEat = () -> System.out.println("Some sounds...");

        Heh heh = new Heh() {
            @Override
            protected void poop() {
                System.out.println("ppphphph");
            }

            @Override
            protected void eat() {
                System.out.println("Hrum-hrum");
            }
        };

    }
}
