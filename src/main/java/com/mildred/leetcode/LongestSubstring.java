package com.mildred.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    /**
     * Given a string s, find the length of the longest substring without duplicate characters.
     * @param s
     * @return the length of the longest substring
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int longest = 0;
        Map<Character, Integer> uniques = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (uniques.containsKey(ch) && uniques.get(ch) >= left) {
                left = uniques.get(ch) + 1;
            }
            uniques.put(ch, right);
            longest = Math.max(longest, right-left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Input:    " + s1);
        System.out.println("Output:   " + lengthOfLongestSubstring(s1));
        System.out.println("Expected: 3\n" );

        String s2 = "bbbbb";
        System.out.println("Input:    " + s2);
        System.out.println("Output:   " + lengthOfLongestSubstring(s2));
        System.out.println("Expected: 1\n" );

        String s3 = "pwwkew";
        System.out.println("Input:    " + s3);
        System.out.println("Output:   " + lengthOfLongestSubstring(s3));
        System.out.println("Expected: 3\n" );

        String s4 = " ";
        System.out.println("Input:    " + s4);
        System.out.println("Output:   " + lengthOfLongestSubstring(s4));
        System.out.println("Expected: 1\n" );
    }
}
