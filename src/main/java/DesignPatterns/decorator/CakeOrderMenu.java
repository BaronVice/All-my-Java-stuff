package DesignPatterns.decorator;

import DesignPatterns.decorator.cakes.Cake;
import DesignPatterns.decorator.cakes.CakeComponent;
import DesignPatterns.decorator.cakes.crust.ChocolateCrust;
import DesignPatterns.decorator.cakes.crust.ClassicCrust;
import DesignPatterns.decorator.cakes.filling.BerryFilling;
import DesignPatterns.decorator.cakes.filling.FruitFilling;
import DesignPatterns.decorator.cakes.glaze.ChocolateGlaze;
import DesignPatterns.decorator.cakes.glaze.CreamGlaze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CakeOrderMenu {
    private final List<CakeComponent> orderedCakes;
    private final Scanner scanner;

    public CakeOrderMenu() {
        this.orderedCakes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        CakeComponent glaze =
                // Глазурь
                callGlaze(
                        // Наполнение
                        callFilling(
                                // Корж
                                callCrust(
                                        // Заглушка
                                        new Cake()
                                )
                        )
                );

        System.out.println("Готово!");
        System.out.println(glaze.getDescription());
        orderedCakes.add(glaze);
    }

    private CakeComponent callGlaze(CakeComponent filling) {
        String option;
        String dial = """
                Выберите тип глазури:
                1. Шоколадная
                2. Кремовая
                Номер:\s""";
        System.out.print(dial);
        option = scanner.nextLine();
        return switch (option) {
            case "1" -> new CreamGlaze(filling);
            case "2" -> new ChocolateGlaze(filling);
            default -> callGlaze(filling);
        };
    }

    private CakeComponent callFilling(CakeComponent crust) {
        String option;
        String dial = """
                Выберите тип начинки:
                1. Ягодная
                2. Фруктовая
                Номер:\s""";
        System.out.print(dial);
        option = scanner.nextLine();
        return switch (option) {
            case "1" -> new BerryFilling(crust);
            case "2" -> new FruitFilling(crust);
            default -> callFilling(crust);
        };
    }

    private CakeComponent callCrust(CakeComponent cake) {
        String option;
        String dial = """
                Выберите тип коржа:
                1. Классический
                2. Шоколадный
                Номер:\s""";
        System.out.print(dial);
        option = scanner.nextLine();
        return switch (option) {
            case "1" -> new ClassicCrust(cake);
            case "2" -> new ChocolateCrust(cake);
            default -> callCrust(cake);
        };
    }

    public void showOrderedCakes(){
        System.out.println("Все заказанные торты...");
        // Собираем описание тортов и выводим их
        orderedCakes.stream().map(CakeComponent::getDescription).toList().forEach(System.out::println);
    }
}
