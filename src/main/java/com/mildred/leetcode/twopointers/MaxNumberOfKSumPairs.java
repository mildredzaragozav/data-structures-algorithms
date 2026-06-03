package com.mildred.leetcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;

public class MaxNumberOfKSumPairs {
    /**
     * You are given an integer array nums and an integer k.
     * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
     * Return the maximum number of operations you can perform on the array.
     * Complexity for below solution:
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int maxOperations(int[] nums, int k) {
        int operations = 0;
        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int num : nums) {
            int toTarget = k - num;
            if (pairs.containsKey(toTarget)) {
                operations++;
                pairs.put(toTarget, pairs.get(toTarget)-1);
                if (pairs.get(toTarget) == 0) pairs.remove(toTarget);
                continue;
            }
            pairs.put(num, pairs.getOrDefault(num, 0) + 1);
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int k = 5;
        System.out.println("Input: k=" + k + " nums=" + Arrays.toString(nums));
        System.out.println("Expected: 2");
        System.out.println("Output: " + maxOperations(nums, k));

        nums = new int[]{3,1,3,4,3};
        k = 6;
        System.out.println("\nInput: k=" + k + " nums=" + Arrays.toString(nums));
        System.out.println("Expected: 1");
        System.out.println("Output: " + maxOperations(nums, k));

        nums = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        k = 3;
        System.out.println("\nInput: k=" + k + " nums=" + Arrays.toString(nums));
        System.out.println("Expected: 4");
        System.out.println("Output: " + maxOperations(nums, k));

        nums = new int[]{3,1,5,1,1,1,1,1,2,2,3,2,2};
        k = 1;
        System.out.println("\nInput: k=" + k + " nums=" + Arrays.toString(nums));
        System.out.println("Expected: 0");
        System.out.println("Output: " + maxOperations(nums, k));

        nums = new int[]{2,2,2,3,1,1,4,1};
        k = 3;
        System.out.println("\nInput: k=" + k + " nums=" + Arrays.toString(nums));
        System.out.println("Expected: 3");
        System.out.println("Output: " + maxOperations(nums, k));

        nums = new int[]{29,26,81,70,75,4,48,38,22,10,51,62,17,50,7,7,24,61,54,44,30,29,66,83,6,45,24,49,42,31,10,6,88,48,34,10,54,56,80,41,19};
        k = 12;
        System.out.println("\nInput: k=" + k + " nums=" + Arrays.toString(nums));
        System.out.println("Expected: 1");
        System.out.println("Output: " + maxOperations(nums, k));
    }
}
