package DesignPatterns.decorator;

public class Main {
    public static void main(String[] args) {
        CakeOrderMenu menu = new CakeOrderMenu();
        menu.showMenu();
        menu.showMenu();
        menu.showOrderedCakes();
    }
}
