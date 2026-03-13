package com.mildred.datastructures.exercises.HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class SubarraySum {
    /**
     * This method finds the indices of a contiguous subarray in nums that add up to the target sum using a hash table (HashMap).
     * It returns an array of two integers representing the starting and ending indices of the subarray that adds up to the target
     * sum. If there is no such subarray, your function should return an empty list.
     * @param nums
     * @param target
     * @return
     */
    public static int[] subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int rest = currentSum - target;
            if (map.containsKey(rest)) {
               return new int[]{map.get(rest) + 1, i};
            }
            map.put(currentSum, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("These tests confirm subarraySum() returns");
        System.out.println("the start and end indices of a subarray");
        System.out.println("that sums to the target, or [] if none exists.");
        System.out.println();

        // Test 1: Basic subarray
        System.out.println("Test 1: Basic Subarray");
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        System.out.println("Expected: Indices of subarray summing to 9");
        System.out.println("Actual: " + formatResult(subarraySum(nums1, target1)));
        System.out.println();

        // Test 2: Multiple possible subarrays
        System.out.println("Test 2: Multiple Possible Subarrays");
        int[] nums2 = {1, 2, 2, 3, 1};
        int target2 = 5;
        System.out.println("Expected: Any valid subarray summing to 5");
        System.out.println("Actual: " + formatResult(subarraySum(nums2, target2)));
        System.out.println();

        // Test 3: Includes negative numbers
        System.out.println("Test 3: Handles Negative Numbers");
        int[] nums3 = {3, 4, -7, 5, 1};
        int target3 = 5;
        System.out.println("Expected: Any valid subarray summing to 5");
        System.out.println("Actual: " + formatResult(subarraySum(nums3, target3)));
        System.out.println();

        // Test 4: Entire array is the subarray
        System.out.println("Test 4: Entire Array Matches");
        int[] nums4 = {2, 2, 2, 2};
        int target4 = 8;
        System.out.println("Expected: Indices for full array [0,3]");
        System.out.println("Actual: " + formatResult(subarraySum(nums4, target4)));
        System.out.println();

        // Test 5: No subarray found
        System.out.println("Test 5: No Subarray Found");
        int[] nums5 = {1, 1, 1};
        int target5 = 10;
        System.out.println("Expected: []");
        System.out.println("Actual: " + formatResult(subarraySum(nums5, target5)));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm subarraySum() returns
            the start and end indices of a subarray
            that sums to the target, or [] if none exists.

            Test 1: Basic Subarray
            Expected: Indices of subarray summing to 9
            Actual: [1, 3] (or valid subarray indices)

            Test 2: Multiple Possible Subarrays
            Expected: Any valid subarray summing to 5
            Actual: [0, 2] (or other valid indices)

            Test 3: Handles Negative Numbers
            Expected: Any valid subarray summing to 5
            Actual: [3, 4] (or other valid indices)

            Test 4: Entire Array Matches
            Expected: [0, 3]
            Actual: [0, 3]

            Test 5: No Subarray Found
            Expected: []
            Actual: []
        */
    }

    private static String formatResult(int[] result) {
        return result.length == 0 ? "[]" : Arrays.toString(result);
    }
}
