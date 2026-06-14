package com.mildred.leetcode.twopointers;

public class LongestContiguousSubstring {

    /**
     * You are given a string word consisting of lowercase english letters and an integer k. A substring is called k-interspace if
     * for every pair of adjacents characters in the substring the absolute difference between their ascii values is less than or equal to k.
     * The task is find the longest contiguous substring of word that satisfies this condition:
     * - If multiple substrings have the same maximum length, return the one that appears first in the string.
     * Complexity for this solution:
     * Time: O(n)
     * Space: O(1)
     * @param word
     * @param k
     * @return
     */
    public static String longestKInterspaceSubstring(String word, int k) {
        if (word.isBlank()) return "";

        int maxLen = 1;
        int maxStart = 0;
        int currentLen = 1;
        int currentStart = 0;

        for (int i = 1; i < word.length(); i++) {
            // Check the absolute ASCII difference between adjacent characters
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) <= k) {
                currentLen++;
            } else {
                // Chain breaks, update maximum if the current chain is strictly longer
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxStart = currentStart;
                }
                // Reset pointers for the next potential substring
                currentStart = i;
                currentLen = 1;
            }
        }

        // Final check after the loop ends to catch the last substring
        if (currentLen > maxLen) {
            maxLen = currentLen;
            maxStart = currentStart;
        }

        return word.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        // Test Case 1: Multiple equal length maximums, should return the first one
        String word1 = "abczabc";
        int k1 = 2;
        System.out.println("Input: " + word1);
        System.out.println("Output: " + longestKInterspaceSubstring(word1, k1)); // Output: "abc"

        // Test Case 2: Complete string is valid
        String word2 = "aceg";
        int k2 = 2;
        System.out.println("\nInput: " + word2);
        System.out.println("Output: " + longestKInterspaceSubstring(word2, k2)); // Output: "aceg"
    }
}
