package com.mildred.leetcode.twopointers;

import java.util.Arrays;

public class ContainerWithMostWater {
    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     * Complexity for solution below:
     * Time: O(n)
     * Space: O(1)
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int maxHeight = Math.min(height[left], height[right]);
            max = Math.max(max, maxHeight * (right - left));

            if (height[right] >= height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Expected: 49");
        System.out.println("Output: " + maxArea(height));

        height = new int[]{1,1};
        System.out.println("\nInput: " + Arrays.toString(height));
        System.out.println("Expected: 1");
        System.out.println("Output: " + maxArea(height));

        height = new int[]{0, 0};
        System.out.println("\nInput: " + Arrays.toString(height));
        System.out.println("Expected: 0");
        System.out.println("Output: " + maxArea(height));
    }
}
