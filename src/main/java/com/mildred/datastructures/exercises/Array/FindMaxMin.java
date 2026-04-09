package com.mildred.datastructures.exercises.Array;

import java.util.Arrays;

public class FindMaxMin {
    /**
     * This methods finds the maximum and minimum value of an array and returns these two numbers as an array with the
     * maximum number at the first index and the minimum number at the second index.
     * @param myList
     * @return
     */
    public static int[] findMaxMin(int[] myList) {
        int max = myList[0];
        int min = myList[0];

        for (int num : myList) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {

        int[] myList1 = {5, 3, 8, 1, 6, 9};
        int[] result1 = findMaxMin(myList1);
        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"

        int[] myList2 = {-5, -3, -8, -1, -6, -9};
        int[] result2 = findMaxMin(myList2);
        System.out.println("Test case 2: MaxMin: " + Arrays.toString(result2)); // prints "[-1, -9]"

        int[] myList3 = {0, 0, 0, 0, 0};
        int[] result3 = findMaxMin(myList3);
        System.out.println("Test case 3: MaxMin: " + Arrays.toString(result3)); // prints "[0, 0]"

        int[] myList4 = {100, 200, 300, 400, 500};
        int[] result4 = findMaxMin(myList4);
        System.out.println("Test case 4: MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"

        int[] myList5 = {1};
        int[] result5 = findMaxMin(myList5);
        System.out.println("Test case 4: MaxMin: " + Arrays.toString(result5)); //

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: MaxMin: [9, 1]
            Test case 2: MaxMin: [-1, -9]
            Test case 3: MaxMin: [0, 0]
            Test case 4: MaxMin: [500, 100]
        */

    }
}
