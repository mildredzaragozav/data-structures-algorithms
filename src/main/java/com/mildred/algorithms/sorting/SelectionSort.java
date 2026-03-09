package com.mildred.algorithms.sorting;

import java.util.Arrays;

/**
 * The selection sort algorithm is a simple, in-place, comparison-based sorting algorithm that works by repeatedly finding
 * the minimum element from the unsorted part of a list and swapping it with the first element of the unsorted section.
 * Initially, the sorted part is empty, and the unsorted part contains all the elements.  The algorithm repeatedly selects
 * the smallest (or largest) element from the unsorted part and moves it to the end of the sorted part.  This process continues
 * until the unsorted part becomes empty, and the list is sorted.
 *
 * Time complexity is O(n^2).
 * Space complexity is O(1)
 */
public class SelectionSort {

    public static void selectionSort(int [] arr) {
        if(arr == null || arr.length == 1) return;

        for(int j=0; j<arr.length-1; j++){
            int minIndex = j;
            for(int i=j+1; i<arr.length; i++) {
                if(arr[i] < arr[minIndex]) minIndex = i;
            }
            if(j != minIndex) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] myArray = {4, 2, 6, 5, 1, 3};

        selectionSort(myArray);

        System.out.println(Arrays.toString(myArray));
    }
}
