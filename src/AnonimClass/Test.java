package AnonimClass;

interface AbleToEat{
    public void eat();
}

abstract class Heh{
    protected abstract void poop();
}

// Interfaces and abstract classes may be initialized as anon class (but this sort of object is inheritor);
public class Test {
    public static void main(String[] args) {
        AbleToEat ableToEat = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("Feed me, please");
            }
        };

        Heh heh = new Heh() {
            @Override
            protected void poop() {
                System.out.println("ppphphph");
            }
        };

    }
}
