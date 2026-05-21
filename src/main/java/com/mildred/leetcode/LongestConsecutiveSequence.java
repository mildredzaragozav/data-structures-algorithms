package com.mildred.leetcode;

import java.util.*;

public class LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * Current complexity:
     * Time O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) continue;

            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);

            int sum = left + right + 1;

            map.put(num, sum);

            // update boundaries
            map.put(num - left, sum);
            map.put(num + right, sum);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-9,-4,9,-7,0,7,3,-1,6,2,-2,8,-2,0,2,-7,-5,-2,6,-5,0,-8,8,1,0,6,8,-8,-1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Expected: 6");
        System.out.println("Output: " + longestConsecutive(nums));

        nums = new int[]{100,4,200,1,3,2};
        System.out.println("\nInput: " + Arrays.toString(nums));
        System.out.println("Expected: 4");
        System.out.println("Output: " + longestConsecutive(nums));

        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println("\nInput: " + Arrays.toString(nums));
        System.out.println("Expected: 9");
        System.out.println("Output: " + longestConsecutive(nums));

        nums = new int[]{1,0,1,2};
        System.out.println("\nInput: " + Arrays.toString(nums));
        System.out.println("Expected: 3");
        System.out.println("Output: " + longestConsecutive(nums));

        nums = new int[]{0};
        System.out.println("\nInput: " + Arrays.toString(nums));
        System.out.println("Expected: 1");
        System.out.println("Output: " + longestConsecutive(nums));

        nums = new int[]{0, 0};
        System.out.println("\nInput: " + Arrays.toString(nums));
        System.out.println("Expected: 1");
        System.out.println("Output: " + longestConsecutive(nums));

        nums = new int[]{0,-1};
        System.out.println("\nInput: " + Arrays.toString(nums));
        System.out.println("Expected: 2");
        System.out.println("Output: " + longestConsecutive(nums));
    }
}
