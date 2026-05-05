package com.mildred.leetcode;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    /**
     * Complexity for current solution: O(S), where S is the sum of all characters in all strings.
     * @param strs an array of strings
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs[0].isBlank()) return "";
        String longestPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].isBlank() || longestPrefix.charAt(0) != strs[i].charAt(0)) return "";

            int limit = 1;
            for (int j = 1; j < Math.min(longestPrefix.length(), strs[i].length()); j++) {
                if (longestPrefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                limit ++;
            }
            longestPrefix = longestPrefix.substring(0, limit);
        }

        return longestPrefix;
    }

    public static void main(String[] args) {
        System.out.println("Test 1");
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Input: " + Arrays.toString(strs));
        System.out.println("Output: " + longestCommonPrefix(strs));
        System.out.println("Expected: fl");

        System.out.println("\nTest 2");
        String[] strs1 = {"dog", "racecar", "car"};
        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Output: " + longestCommonPrefix(strs1));
        System.out.println("Expected: \"\"");

        System.out.println("\nTest 3");
        String[] strs2 = {"reflower","flow","flight"};
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Output: " + longestCommonPrefix(strs2));
        System.out.println("Expected: \"\"");

        System.out.println("\nTest 4");
        String[] strs3 = {"",""};
        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Output: " + longestCommonPrefix(strs3));
        System.out.println("Expected: \"\"");

        System.out.println("\nTest 5");
        String[] strs4 = {"rowdynas","rowpynas","rowllbynas"};
        System.out.println("Input: " + Arrays.toString(strs4));
        System.out.println("Output: " + longestCommonPrefix(strs4));
        System.out.println("Expected: row");

        System.out.println("\nTest 6");
        String[] strs5 = {"ab","a"};
        System.out.println("Input: " + Arrays.toString(strs5));
        System.out.println("Output: " + longestCommonPrefix(strs5));
        System.out.println("Expected: a");

        System.out.println("\nTest 6");
        String[] strs6 = {"flower","flower", "flower","flower"};
        System.out.println("Input: " + Arrays.toString(strs6));
        System.out.println("Output: " + longestCommonPrefix(strs6));
        System.out.println("Expected: flower");

        System.out.println("\nTest 7");
        String[] strs7 = {"baab","bacb","b","cbc"};
        System.out.println("Input: " + Arrays.toString(strs7));
        System.out.println("Output: " + longestCommonPrefix(strs7));
        System.out.println("Expected: \"\"");

    }
}
