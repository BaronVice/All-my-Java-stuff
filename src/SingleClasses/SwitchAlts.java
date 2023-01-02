package SingleClasses;

import java.util.Scanner;

public class SwitchAlts {

    public static String dayType(int day){
        return switch (day){
            case 1, 2, 3, 4, 5 -> "рабочий";
            case 6, 7 -> "выходной";
            default -> "странный";
        } + " день";
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите номер дня недели: ");
        int number = Integer.parseInt(scan.nextLine());
        System.out.println(SwitchAlts.dayType(number));

    }
}
