package Exceptions;

import java.io.IOException;
import java.util.Scanner;

public class Exceptions2 {
    public static void main(String[] args) throws ScannerException {
        Scanner scan = new Scanner(System.in);
        while(true){
            int x = Integer.parseInt(scan.nextLine());
            if (x != 0){
                throw new ScannerException("User is dumb");
            }
        }
    }
}
