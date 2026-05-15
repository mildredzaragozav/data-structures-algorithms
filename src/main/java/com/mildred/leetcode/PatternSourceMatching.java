package com.mildred.leetcode;

import java.util.Set;

public class PatternSourceMatching {

    private static final Set<Character> VOWELS = Set.of('a','e','i','o','u');

    /**
     * You are given two strings: pattern and source. The first string pattern contains only the symbols 0 and 1, and
     * the second string source contains only lowercase English letters. Your task is to calculate the number of
     * substrings of source that match pattern.
     * We’ll say that a substring source[l..r] matches pattern if the following three conditions are met:
     * • The pattern and substring are equal in length.
     * • Where there is a 0 in the pattern, there is a vowel in the substring.
     * • Where there is a 1 in the pattern, there is a consonant in the substring.
     * @param pattern
     * @param source
     * @return
     */
    public static int findMatches(String pattern, String source) {
        int matches = 0;

        for (int i = 0; i <= source.length() - pattern.length(); i++) {
            matches += checkSubstring(source, pattern, i);
        }

        return matches;
    }

    private static int checkSubstring(String source, String pattern, int startIndex) {
        for (int j = 0; j < pattern.length(); j++) {
            boolean isVowel = VOWELS.contains(source.charAt(startIndex + j));
            if (pattern.charAt(j) == '0') {
                if (!isVowel) return 0;
            } else {
                if (isVowel) return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "amazing";
        String p= "010";
        System.out.println("Source: " + s + " Pattern: " + p);
        System.out.println("Expected: 2");
        System.out.println("Output: " + findMatches(p, s) + "\n");

        String s1 = "codesignal";
        String p1= "100";
        System.out.println("Source: " + s1 + " Pattern: " + p1);
        System.out.println("Expected: 0");
        System.out.println("Output: " + findMatches(p1, s1) + "\n");
    }
}
