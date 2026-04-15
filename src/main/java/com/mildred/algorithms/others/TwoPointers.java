package com.mildred.algorithms.others;

import java.util.Arrays;

public class TwoPointers {

    /**
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
     * @param target
     * @param nums a sorted array in non-decreasing order.
     * @return the indices of the two numbers index1 and index2,
     */
    static int[] findTwoIndex(int target, int[] nums) {
        if(nums == null || nums.length == 0) return null;

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[]{left + 1 ,right + 1};
            }else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(findTwoIndex(target, numbers)));

        int[] numbers1 = new int[]{2,3,4};
        int target1 = 6;
        System.out.println(Arrays.toString(findTwoIndex(target1, numbers1)));

        int[] numbers2 = new int[]{-1,0};
        int target2 = -1;
        System.out.println(Arrays.toString(findTwoIndex(target2, numbers2)));

        int[] numbers3 = new int[]{5,25,75};
        int target3 = 100;
        System.out.println(Arrays.toString(findTwoIndex(target3, numbers3)));
    }
}
