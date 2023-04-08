package SingleClasses;

public class Arrays {
    public static void main(String[] args){
        int[] numbers = new int[5];
        for (int i = 1; i <= 5; i++){
            numbers[i-1] = i * 5;
        }
        for (int i = 0; i < 5; i++){
            System.out.println(String.format("element %d: %d", i, numbers[i]));
        }

    }
}
