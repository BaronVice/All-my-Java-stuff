package FileManipulations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String path = String.format("C:%sUsers%<s123%<sOneDrive%<sРабочий стол%<sJava lessons%<sRandomNumbers.txt", separator);

        File data = new File(path);

        Scanner scan = new Scanner(data);
        List<Integer> numbers = new ArrayList<>();
        while(scan.hasNextLine()){
            while(scan.hasNextInt()){
                numbers.add(scan.nextInt());
            }
            System.out.println(numbers.toString());
        }

        scan.close();
    }
}
