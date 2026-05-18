package com.mildred.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    /**
     * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where
     * the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * Current complexity for this solution:
     * Time O(n+m)
     * Space O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = m + n - 1;
        int p2 = n -1;

        while (0 <= p2) {
            if (0 <= left && nums2[p2] < nums1[left]) {
                nums1[right--] = nums1[left--];
            } else {
                nums1[right--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0}; int m = 3;
        int[] nums2 = new int[]{2,5,6}; int n = 3;

        System.out.println("Input: \nnums1: " + Arrays.toString(nums1) + " m: " + m);
        System.out.println("nums2: " + Arrays.toString(nums2) + " n: " + n);
        merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1, 2, 2, 3, 5, 6] \n");

        nums1 = new int[]{1}; m = 1;
        nums2 = new int[]{};  n = 0;

        System.out.println("Input: \nnums1: " + Arrays.toString(nums1) + " m: " + m);
        System.out.println("nums2: " + Arrays.toString(nums2) + " n: " + n);
        merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1] \n");

        nums1 = new int[]{1,20,30,0,0,0}; m = 3;
        nums2 = new int[]{5,25,35};  n = 3;

        System.out.println("Input: \nnums1: " + Arrays.toString(nums1) + " m: " + m);
        System.out.println("nums2: " + Arrays.toString(nums2) + " n: " + n);
        merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1, 5, 20, 25, 30, 35] \n");

        nums1 = new int[]{0}; m = 0;
        nums2 = new int[]{1};  n = 1;

        System.out.println("Input: \nnums1: " + Arrays.toString(nums1) + " m: " + m);
        System.out.println("nums2: " + Arrays.toString(nums2) + " n: " + n);
        merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1] \n");

        nums1 = new int[]{50,0,0,0,0,0}; m = 1;
        nums2 = new int[]{1,5,8,9,19};  n = 5;

        System.out.println("Input: \nnums1: " + Arrays.toString(nums1) + " m: " + m);
        System.out.println("nums2: " + Arrays.toString(nums2) + " n: " + n);
        merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1, 5, 8, 9, 19, 50] \n");

        nums1 = new int[]{2,0}; m = 1;
        nums2 = new int[]{1};  n = 1;

        System.out.println("Input: \nnums1: " + Arrays.toString(nums1) + " m: " + m);
        System.out.println("nums2: " + Arrays.toString(nums2) + " n: " + n);
        merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1, 2] \n");
    }
}
