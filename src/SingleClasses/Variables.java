package SingleClasses;

public class Variables {
    public static void main(String[] args){
        byte firstNumber = 10;
        byte secondNumber = 3;
        float thirdNumber = 6.6666666f;

        var result = (float)firstNumber / secondNumber + thirdNumber;
        System.out.println(result);

        char let1 = 'j';
        String let2 = "ava";
        boolean check = true;
        System.out.println(!check ? "nothing" : let1 + let2);

    }
}
