package SOLID;

import lombok.Getter;
import lombok.Setter;

/** A class should be opened for extensions, but close for modifications */
public class OpenedClosedPrinciple {
    public static void main(String[] args) {

    }
}

@Getter
@Setter
class Employee{
    private double rate;
    private int hours;
}

// No: it is opened for modification since we may add another expression in switch and so create
// another methods. Solution is to create separate classes attached to interfaces

//class Earnings {
//
//    public static double countEarnings(Employee employee){
//        return switch (employee.getState()){
//            case UTICA -> calculateTaxesForUtica(employee);
//            case WEST_VIRGINIA -> calculateTaxesForWestVirginia(employee);
//            case TEXAS -> calculateTaxesForTexas(employee);
//        };
//    }
//
//    public static double calculateTaxesForUtica(Employee employee){
//        return employee.getRate * employee.getHours * 0.1;
//    }
//
//    public static double calculateTaxesForWestVirginia(Employee employee){
//        return employee.getRate * employee.getHours * 0.05;
//    }
//
//    public static double calculateTaxesForTexas(Employee employee){
//        return employee.getRate * employee.getHours * 0.2;
//    }
//}

// We are bringing tools. Hence, classes are extended and closed for modifications.
interface ITaxesCalculator{
    double calculateTaxes(Employee employee);
}

class TaxesCalculatorForUtica implements ITaxesCalculator {
    @Override
    public double calculateTaxes(Employee employee) {
        return employee.getRate() * employee.getHours() * 0.1;
    }
}

class TaxesCalculatorForWestVirginia implements ITaxesCalculator {
    @Override
    public double calculateTaxes(Employee employee) {
        return employee.getRate() * employee.getHours() * 0.05;
    }
}

class TaxesCalculatorForTexas implements ITaxesCalculator {
    @Override
    public double calculateTaxes(Employee employee) {
        return employee.getRate() * employee.getHours() * 0.2;
    }
}