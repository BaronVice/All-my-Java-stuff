package SingleClasses;

public class WhileLoop {
    public static void main(String[] args){
        int i = 0;
        boolean check = i < 5;
        while (check){
            i++;
            System.out.println("Current while done " + i + " times");
            check = i < 5;
        }
    }
}
