package com.mildred.leetcode;

import java.util.Arrays;

public class RotateArray {
    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     * Current complexity:
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println("Input: " + Arrays.toString(nums) + " k: 3");
        System.out.println("Expected: [5, 6, 7, 1, 2, 3, 4]");
        System.out.println("Output:  " + Arrays.toString(nums) + "\n");

        nums = new int[]{-1,-100,3,99};
        rotate(nums, 2);
        System.out.println("Input: " + Arrays.toString(nums) + " k: 2");
        System.out.println("Expected: [3, 99, -1, -100]");
        System.out.println("Output:  " + Arrays.toString(nums)  + "\n");
    }
}
