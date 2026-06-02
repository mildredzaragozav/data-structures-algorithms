package com.mildred.leetcode.twopointers;

public class IsSubsequence {

    /**
     * Given two strings s & t return true if s is a subsequence of t, or false otherwise.
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
     * without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     * @param s is a String with only lowercase English letter
     * @param t is a String with only lowercase English letter
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.equals(t) || s.isEmpty()) return true;

        int left = 0;
        boolean isCharPresent = false;
        for (char c : s.toCharArray()) {
            isCharPresent = false;
            for (int right = left; right < t.length(); right++) {
                char ct = t.charAt(right);
                if (c == ct) {
                    left = right+1;
                    isCharPresent = true;
                    break;
                } else if (right == t.length() -1) {
                    return false;
                }
            }
        }

        return isCharPresent;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("Input: s=" + s + " t=" + t);
        System.out.println("Expected: true");
        System.out.println("Output: " + isSubsequence(s,t));

        s = "";
        System.out.println("\nInput: s=" + s + " t=" + t);
        System.out.println("Expected: true");
        System.out.println("Output: " + isSubsequence(s,t));

        s = "acb";
        System.out.println("\nInput: s=" + s + " t=" + t);
        System.out.println("Expected: false");
        System.out.println("Output: " + isSubsequence(s,t));

        s = "axc";
        System.out.println("\nInput: s=" + s + " t=" + t);
        System.out.println("Expected: false");
        System.out.println("Output: " + isSubsequence(s,t));

        s = "leeeeetcode";
        t = "yyyyylyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy";
        System.out.println("\nInput: s=" + s + " t=" + t);
        System.out.println("Expected: false");
        System.out.println("Output: " + isSubsequence(s,t));

        s = "";
        t = "";
        System.out.println("\nInput: s=" + s + " t=" + t);
        System.out.println("Expected: true");
        System.out.println("Output: " + isSubsequence(s,t));

        s = "abc";
        t = "";
        System.out.println("\nInput: s=" + s + " t=" + t);
        System.out.println("Expected: false");
        System.out.println("Output: " + isSubsequence(s,t));

    }
}
