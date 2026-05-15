package com.mildred.datastructures.exercises.Array;

import java.util.Arrays;

public class BasicArrayOperations {
    /**
     * Given an array a, output an array b of the same length by applying the following transformation:
     * - For each i from 0 to a.length - 1 inclusive, b[i] = a[i - 1] + a[i] + a[i + 1]
     * - If an element in the sum a[i - 1] + a[i] + a[i + 1] does not exist, use 0 in its place:
     *      -For instance, b[0] = 0 + a[0] + a[1]
     * @param a
     * @return
     */
    public static int[] transformArray(int[] a) {
        int [] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
            if (i > 0) {
                b[i] += a[i - 1];
            }

            if (i < a.length - 1) {
                b[i] += a[i + 1];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,0,1,-2,3};
        System.out.println("Input: " + Arrays.toString(a));
        System.out.println("Expected: [4, 5, -1, 2, 1]");
        System.out.println("Output: " + Arrays.toString(transformArray(a)));
    }
}
