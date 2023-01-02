package SingleClasses;

public class ThisKeyWord {
    public static void main(String[] args) {
        Car model1 = new Car();
        model1.setModel("DMC");
        model1.setMileage(12345);
        model1.getInfo();
    }
}

class Car{
    private String model;
    private int mileage;

    // Setters
    public void setModel(String model){
        this.model = model;
    }
    public void setMileage(int mileage){
        this.mileage = mileage;
    }

    // Getters
    public String getModel(){
        return model;
    }
    public int getMileage(){
        return mileage;
    }

    // Others
    public void getInfo(){
        System.out.println(String.format("Model: %s\nMileage: %d\n", model, mileage));
    }
}
