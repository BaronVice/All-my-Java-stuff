package Guava;

import com.google.common.base.Preconditions;

/** Stuff to check if method or constructor is invoked with proper args (check if given values are correct)
 * In other words - before doing something check something */
public class PreconditionClass {
    public static void main(String[] args) {
        try {
            System.out.println(sqrt(-123.3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(sum(23, 333));
            System.out.println(sum(null, null));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(getValue(1));
            System.out.println(getValue(22));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double sqrt(double value) {
        Preconditions.checkArgument(
                value > 0.0,
                "Illegal argument for sqrt(%s): given value must be positive",
                value);

        return Math.sqrt(value);
    }

    public static int sum(Integer a, Integer b){
        Preconditions.checkNotNull(a, "Illegal argument for sum: null value found");
        Preconditions.checkNotNull(b, "Illegal argument for sum: null value found");

        return a + b;
    }

    public static int getValue(int index){
        int[] arr = {1, 2, 3, 4};
        Preconditions.checkPositionIndex(
                index,
                arr.length,
                "Illegal argument for getValue: index is out of bounds");

        return arr[index];
    }
}


