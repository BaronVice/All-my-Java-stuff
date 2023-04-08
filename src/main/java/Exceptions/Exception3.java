package Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception3 {
    public static void main(String[] args) {
        // Checked exception - compile time exception возникают во время компиляции (исключительный случай)
        File file = new File("src/Exceptions/loggggs");
        try {
            Scanner scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exists");
        }

        // Unchecked exception - runtime exception возникают во время выполнения программы (ошибка в работе программы)
        try{
            int a = 123/0;
        }
        catch (ArithmeticException e){
            System.out.println("Zero division is not possible");
        }

    }
}
