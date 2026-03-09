package com.mildred.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    /**
     * Time complexity: O(nlogn)
     * If you have already a sorted array, time complexity: O(n^2) -> worst case scenario
     * @param array
     */
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length);
    }

    public static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);

            quickSortHelper(array, left, pivotIndex);
            quickSortHelper(array, pivotIndex+1, right);
        }

    }

    /**
     * Time complexity: O(n)
     * @param array
     * @param pivotIndex
     * @param endIndex
     * @return
     */
    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i < endIndex; i++) {
            if(array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static void swap (int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static void main(String[] args) {

        int[] myArray = {4, 6, 1, 7, 3, 2, 5};

        quickSort(myArray);

        System.out.println(Arrays.toString(myArray));
    }

}
