package com.mildred.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Sort in place, space complexity is O(1), since we aren't creating a new array (copy).
     * Time complexity is O(n^2).
     * @param arr
     */
    private static void ascendingSort(int[] arr) {
        //4, 2, 6, 5, 1, 3
        int aux = 1;

        while(aux < arr.length){
            for (int i=0; i<arr.length-aux; i++) {
                if (arr[i + 1] < arr[i]) {
                    int var = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = var;
                }
            }
            aux++;
        }
    }

    /**
     * Sort in place, space complexity is O(1), since we aren't creating a new array (copy).
     * Time complexity is O(n^2).
     * @param arr
     */
    private static void descendingSort(int[] arr) {

        for(int j=1; j<arr.length; j++) {
            for(int i = 0; i < arr.length-j; i++) {
                if(arr[i+1] > arr[i]) {
                    int var = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = var;
                }
            }
        }
    }

    /**
     * Implement the bubble sort algorithm in an array list
     */
    public static void bubbleSort() {
        int[] myArray = {4, 2, 6, 5, 1, 3};

        for (int i = 0; i < myArray.length-1; i++) {
            for (int j=i+1; j < myArray.length; j++) {
                if(myArray[j] < myArray[i]) {
                    int aux = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = aux;
                }
            }
        }

        System.out.println("Sorted array");
        for(int n : myArray) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        int[] myArray = {4, 2, 6, 5, 1, 3};
        int[] myArray2 = {4, 2, 6, 5, 1, 3};
        ascendingSort(myArray);
        System.out.println(Arrays.toString(myArray));
        descendingSort(myArray2);
        System.out.println(Arrays.toString(myArray2));

        bubbleSort();
    }
}
