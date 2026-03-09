package com.mildred.algorithms.sorting;

import java.util.Arrays;

/**
 * Insertion sort is a simple, in-place sorting algorithm that builds a final sorted array one element at a
 * time, similar to how one might sort a hand of playing cards. It is efficient for small lists and nearly
 * sorted lists but less efficient for large, randomly ordered datasets.
 *
 * For worst case scenario, time complexity is O(n^2)
 * Best case scenario (when array is almost sorted), time complexity is O(n)
 * Space complexity is O(1)
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for(int i=1; i< arr.length; i++) {
            int temp = arr[i];
            for(int j=i-1; 0<=j; j--) {
                if(temp < arr[j]) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
        /* Alternative solution */
        /*for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }*/
    }

    public static void main(String[] args) {

        int[] myArray = {4, 2, 6, 5, 1, 3};

        insertionSort(myArray);

        System.out.println(Arrays.toString(myArray));
    }
}
