package NestedClass;

public class Test {
    public static void main(String[] args) {
        Electrocar electrocar1 = new Electrocar(1);
        Electrocar.AIDriver aiDriver = new Electrocar.AIDriver();
        aiDriver.updatesCheck();
        aiDriver.receiveUpdates();
        aiDriver.receiveUpdates();

        System.out.println();

        electrocar1.fillTank();

        System.out.println();

        try{
            electrocar1.start();
        }
        catch (EmptyFuelException e){
            System.out.println("You have to refuel your car before starting it\n");
        }
        System.out.println();
    }
}
