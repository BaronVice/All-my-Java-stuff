package Algorythms;

import java.util.Random;

public class Mergesort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before: ");
        for(int x : numbers){
            System.out.printf("%d ", x);
        }

        merge_sort(numbers);

        System.out.println("\nAfter: ");
        for(int x : numbers){
            System.out.printf("%d ", x);
        }
    }

    private static void merge_sort(int[] array){
        int len = array.length;

        if (len < 2){
            return;
        }

        int mid = len / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[len - mid];

        for (int i = 0; i < mid; i++){
            leftHalf[i] = array[i];
        }
        for (int i = mid; i < len; i++){
            rightHalf[i - mid] = rightHalf[i];
        }

        merge_sort(leftHalf);
        merge_sort(rightHalf);

        // merge time
        merge(array, leftHalf, rightHalf);
    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf){
        int leftLen = leftHalf.length;
        int rightLen = rightHalf.length;
        // left, right, me  rge
        int i = 0, j = 0, k = 0;
        // while we have elements in halves
        while(i < leftLen && j < rightLen){
            if (leftHalf[i] <= rightHalf[j]){
                array[k] = leftHalf[i];
                i++;
            }
            else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        // add last element
        while(i < leftLen){
            array[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j < rightLen){
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
