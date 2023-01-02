package Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions1 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            readFile();
            System.out.println("File found");
        }
        catch (FileNotFoundException e){
            System.out.println("File doesn't exists");
        }
    }

    public static void readFile() throws FileNotFoundException {
        String path = "src/Exceptions/logs";
        File file = new File(path);
        Scanner scan = new Scanner(file);
    }
}
