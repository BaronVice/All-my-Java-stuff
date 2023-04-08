package SingleClasses;

import java.util.Scanner;

public class ArrayOfStrings {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String[] strArr = new String[]{"apple", "banana", "grape"};
        System.out.print("Искомое слово: ");
        String lineToFind = scan.nextLine();

        for(String element : strArr){
            if (element.equals(lineToFind)){
                System.out.println(String.format("%s found!", lineToFind));
            }
            else {
                System.out.println(element);
            }
        }


    }
}
