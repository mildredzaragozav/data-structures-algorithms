package com.mildred.algorithms.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The sliding window technique is an algorithm optimization that transform nested loops (typically O(n^2)) into
 * a single linear pass(O(n)) by maintaining a dynamic sub-array or sub-string "window" that moves through the data,
 * it reuses previous calculations, making it deal for maximum sum, subarray, or substring problems.
 */
public class SlidingWindow {

    /**
     * Given a string s, find the length of the longest substring without duplicate characters.
     * @param s: a string
     * @return the length of the longest substring.
     * Time: O(n)
     */
    static int findLengthLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
            System.out.println(map);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * Time: O(n^2)
     * @param s
     * @return
     */
    static int findLengthLongestSubstringv2(String s) {
        Set<Character> mySet = new HashSet<>();
        int left = 0;
        int maxCounter = 0;

        for (int right = 0; right < s.length(); right++) {
            // Shrink window from left until duplicate is removed
            while (!mySet.add(s.charAt(right))) {
                mySet.remove(s.charAt(left));
                left++;
            }
            System.out.println(mySet);
            maxCounter = Math.max(maxCounter, right - left + 1);
        }
        return maxCounter;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "abcaef";

        System.out.println("Longest string for " + s1 + ": " +  findLengthLongestSubstringv2(s1));
        System.out.println("Longest string for " + s2 + ": " +  findLengthLongestSubstring(s2));
        System.out.println("Longest string for " + s3 + ": " +  findLengthLongestSubstring(s3));
        System.out.println("Longest string for " + s4 + ": " +  findLengthLongestSubstring(s4));
    }
}
