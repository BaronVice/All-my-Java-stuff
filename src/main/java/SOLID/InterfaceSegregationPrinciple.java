package SOLID;

/** Many specific interfaces are better than a general interface */
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {

    }
}

interface IMeatFreeServe{
    void serveVegetables();
    void serveFruits();
}

interface IMeatContainServe{
    void serveBeef();
    void serveFish();
}

class VegetarianMenu implements IMeatFreeServe{
    @Override
    public void serveVegetables() {
        System.out.println("Nice vegetables");
    }

    @Override
    public void serveFruits() {
        System.out.println("Awesome fruits");
    }
}

class StandardMenu implements IMeatFreeServe, IMeatContainServe{
    @Override
    public void serveVegetables() {
        System.out.println("Nice vegetables");
    }

    @Override
    public void serveFruits() {
        System.out.println("Awesome fruits");
    }

    @Override
    public void serveBeef() {
        System.out.println("Why yes, hot beef");
    }

    @Override
    public void serveFish() {
        System.out.println("I eat fish, how did you now that?");
    }
}
