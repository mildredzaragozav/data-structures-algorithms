package com.mildred.leetcode;

import java.util.*;

public class ThreeSum {
    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     * Current complexity: O(n^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> response = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) continue;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    response.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return response;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println("Input:  " + Arrays.toString(nums));
        System.out.println("Output: " + threeSum(nums));
        System.out.println("Expected: [[-1, -1, 2],[-1, 0, 1]] \n");

        int[] nums1 = new int[]{0,1,1};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + threeSum(nums1));
        System.out.println("Expected: [] \n");

        int[] nums2 = new int[]{0,0,0};
        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSum(nums2));
        System.out.println("Expected: [0, 0, 0] \n");

    }
}
