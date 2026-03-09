package com.mildred.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    /**
     * This method takes two sorted arrays and merge them into a sorted array.
     * Time complexity  -> O(n)
     * Space complexity ->
     * @param array1
     * @param array2
     * @return a sorted array int[]
     */
    public static int[] merge(int[] array1, int[] array2) {
        int [] combined = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int combinedIndex = 0;

        while(i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[combinedIndex] = array1[i];
                i++;
            } else {
                combined[combinedIndex] = array2[j];
                j++;
            }
            combinedIndex++;
        }

        while (i < array1.length) {
            combined[combinedIndex] = array1[i];
            i++;
            combinedIndex++;
        }

        while (j < array2.length) {
            combined[combinedIndex] = array2[j];
            j++;
            combinedIndex++;
        }

        return combined;
    }

    /**
     * O(n) -> Space complexity
     * O(nlogn) -> Time complexity (sumando el time complexity de merge() + mergeSort() -> O(n) + O(logn) )
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {
        int [] array1 = {1,3,7,8};
        int [] array2 = {2,4,5,6};
        System.out.println(Arrays.toString(merge(array1,array2)));
    }
}
