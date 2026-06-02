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
        if (s.isEmpty()) return true;

        int sPointer = 0;
        int tPointer = 0;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        while (tPointer < t.length()) {
            if (tArray[tPointer] == sArray[sPointer]) {
                sPointer++;
            }
            tPointer++;
            if (sPointer == s.length()) return true;
        }

        return false;
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
