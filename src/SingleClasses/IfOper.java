package SingleClasses;

public class IfOper {
    public static void main(String[] args){
        int[] arr = new int[] {10, 11, 32, 85};
        for (int number : arr) {
            if (number % 2 == 0){
                System.out.println(number + " is even");
            }
            else if (number % 5 == 0) {
                System.out.println(number + " is even and could be divided by 5");
            }
            else {
                System.out.println(number + " is odd");
            }
        }
    }
}
