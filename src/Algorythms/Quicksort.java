package Algorythms;

import java.util.Random;

public class Quicksort {
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

        quick_sort(numbers);

        System.out.println("\nAfter: ");
        for(int x : numbers){
            System.out.printf("%d ", x);
        }
    }

    private static void quick_sort(int[] array){
        quick_sort(array, 0, array.length-1);
    }
    private static void quick_sort(int[] array, int lowIndex, int highIndex){
        if (lowIndex >= highIndex){
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPoint = partition(array, lowIndex, highIndex, pivot);

        quick_sort(array, lowIndex, leftPoint-1);
        quick_sort(array, leftPoint+1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot){
        int leftPoint = lowIndex;
        int rightPoint = highIndex;

        while (leftPoint < rightPoint){
            while (array[leftPoint] <= pivot && leftPoint < rightPoint){
                leftPoint++;
            }
            while (array[rightPoint] >= pivot && leftPoint < rightPoint){
                rightPoint--;
            }
            swap(array, leftPoint, rightPoint);
        }
        swap(array, leftPoint, highIndex);
        return leftPoint;
    }

    private static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
