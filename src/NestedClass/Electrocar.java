package NestedClass;
// Вложенные классы нужны для упрощения сложных классов
public class Electrocar {
    private int id;
    private FuelTank fuelTank = new FuelTank();
    private Motor motor = new Motor();

    public Electrocar(){}
    public Electrocar(int id){
        this.id = id;
    }

    // Статический вложенный класс
    public static class AIDriver{
        private boolean latestUpdates = false;

        public void updatesCheck(){
            System.out.println(latestUpdates ? "You have the latest version of AI" : "New updates are available");
        }
        public void receiveUpdates(){
            if(latestUpdates){
                System.out.println("Latest version is already installed");
            }
            else{
                latestUpdates = true;
                System.out.println("AI Driver updated for all cars");
            }
        }
    }

    // Вложенный нестатический класс
    private class Motor {
        public void startMotor(){
            System.out.println("Motor goes brrr");
        }
    }
    private class FuelTank{
        private boolean isEmpty = true;
    }
    public void fillTank(){
        this.fuelTank.isEmpty = false;
        System.out.println("Tank is refueled");
    }

    public void start() throws EmptyFuelException {
        System.out.println("Trying to start a car...");
        if (fuelTank.isEmpty){
            throw new EmptyFuelException("Can't start with empty tank");
        }
        else {
            motor.startMotor();
            System.out.print(String.format("Car %d is ready for a ride", this.id));
        }
    }
}
