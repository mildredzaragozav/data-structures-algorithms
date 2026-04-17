package com.mildred.algorithms.searching;

/**
 * Linear search is the simplest algorithm for finding a specific value within a collection of data.
 * It works by systematically checking every element in the data set one by one from the beginning until
 * a match is found or the end of the list is reached.
 */
public class LinearSearch {

    /**
     * @param nums the array of numbers
     * @param target the target number to search
     * @return the index of the target, if target is not in the array returns -1
     */
    static int search(int[] nums, int target) {
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {100, 2, 12, 15, 11, 7, 19, 45};
        int target = 7;
        System.out.println(search(nums, target));

        int[] arr = { 20, -3, 4, 10, 40 };
        int x = 100;
        System.out.println(search(arr, x));
    }
}
