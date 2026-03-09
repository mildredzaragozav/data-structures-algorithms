package com.mildred.datastructures.exercises.Array;

import java.util.Arrays;

public class RemoveElement {
    /**
     * This method removes all ocurrences of val from nums in place and return the new length of the array after the removal.
     * - The first k elements of nums should contain the values that are not equal to val.
     * - The order of these k elements does not matter.
     * - Anything stored in nums after index k - 1 can be ignored and is not checked
     * @param nums:  an integer array
     * @param val: the value to be removed
     * @return int k:  the new length of the array after removal.
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;

        /* Alternative solution */ /*
           int newLength = nums.length;
           for (int i = 0; i < nums.length; i++) {
             if (nums[i] == val) {
                newLength--;
                for (int k = nums.length - 1; i < k; k--) {
                    if (nums[k] != val) {
                        nums[i] = nums[k];
                        break;
                    }
                }
              }
           }
           return newLength;
        */
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test case 1.");
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        int val1 = 1;
        int newLength1 = removeElement(nums1, val1);
        System.out.println("Output: " +
                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
                "\nNew length: " + newLength1);


        // Test case 2
        System.out.println("\nTest case 2.");
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        System.out.println("Input: " + Arrays.toString(nums2));
        int val2 = 6;
        int newLength2 = removeElement(nums2, val2);
        System.out.println("Output: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)) +
                "\nNew length: " + newLength2);

        // Test case 3
        System.out.println("\nTest case 3.");
        int[] nums3 = {-1, -2, -3, -4, -5};
        int val3 = -1;
        int newLength3 = removeElement(nums3, val3);
        System.out.println("Test case 3: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)) +
                "\nNew length: " + newLength3);

        // Test case 4
        System.out.println("\nTest case 4.");
        int[] nums4 = {};
        int val4 = 1;
        int newLength4 = removeElement(nums4, val4);
        System.out.println("Test case 4: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)) +
                "\nNew length: " + newLength4);

        // Test case 5
        System.out.println("\nTest case 5.");
        int[] nums5 = {1, 1, 1, 1, 1};
        int val5 = 1;
        int newLength5 = removeElement(nums5, val5);
        System.out.println("Test case 5: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)) +
                "\nNew length: " + newLength5);

    }
}