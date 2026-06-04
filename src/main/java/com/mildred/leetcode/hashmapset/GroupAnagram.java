package com.mildred.leetcode.hashmapset;

import java.util.*;

public class GroupAnagram {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * Note: strs[i] consists of lowercase English letters.
     * Complexity for current solution:
     * Time: O(n*mlog(m))
     * Space: O(n*m)
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            anagrams.computeIfAbsent(Arrays.toString(word), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        String[] a = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(a));
        System.out.println("Expected: [[bat],[nat,tan],[ate,eat,tea]] (any order)");
        System.out.println("Output: " + groupAnagrams(a));

        String[] b = new String[]{""};
        System.out.println("\nInput: " + Arrays.toString(b));
        System.out.println("Expected: []");
        System.out.println("Output: " + groupAnagrams(b));

        String[] c = new String[]{"a"};
        System.out.println("\nInput: " + Arrays.toString(c));
        System.out.println("Expected: [[a]]");
        System.out.println("Output: " + groupAnagrams(c));
    }
}
