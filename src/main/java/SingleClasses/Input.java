package SingleClasses;

import java.util.Scanner;

public class Input {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ввод текста: ");
        String inputLine = scan.nextLine();
        System.out.println(String.format("Введенный текст: %s", inputLine));
    }
}
