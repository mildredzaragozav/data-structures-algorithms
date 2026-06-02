package com.mildred.leetcode.twopointers;

import java.util.Arrays;

public class MoveZeroes {

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Current complexity for this solution:
     * Time O(n)
     * Space O(1)
     */
    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println("Input: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Expected: [1, 3, 12, 0, 0] \n");

        nums = new int[]{0};
        System.out.println("Input: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Expected: [0] \n");
    }
}
