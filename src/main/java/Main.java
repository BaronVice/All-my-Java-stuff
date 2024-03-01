import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(System.in);
            System.out.print("n: ");
            int n = s.nextInt();

            double positive = 0;
            int positiveAmount = 0;
            double negative = 0;
            int negativeAmount = 0;
            System.out.println("Use ',' as decimetre. Otherwise I'll trow input error :(");
            for (int i = 0; i < n; i++){
                System.out.printf("s[%d]: ", i);
                double c = s.nextDouble();
                if (c < 0) { negative += c; negativeAmount++; }
                else if (c > 0) { positive += c; positiveAmount++; }
            }

            positive /= positiveAmount;
            negative /= negativeAmount;

            System.out.printf("Result: %f", positive * negative);
        } catch (InputMismatchException e) {
            System.out.println("Input error");
        }
    }
}


