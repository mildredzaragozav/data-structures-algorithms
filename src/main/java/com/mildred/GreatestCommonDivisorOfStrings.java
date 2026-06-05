package com.mildred;

public class GreatestCommonDivisorOfStrings {
    /**
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     * Complexity for below solution:
     * Time: O(n + m)
     * Space: O(1)
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";

        int length1 = str1.length();
        int length2 = str2.length();
        int temp;

        while (length1 != 0) {
            temp = length1;
            length1 = length2 % length1;
            length2 = temp;
        }

        return str2.substring(0, length2);
    }

    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";
        System.out.println("Input: s1=" + s1 + " s2=" + s2);
        System.out.println("Expected: ABC");
        System.out.println("Output: " + gcdOfStrings(s2,s1));

        s1 = "ABABAB";
        s2 = "ABAB";
        System.out.println("\nInput: s1=" + s1 + " s2=" + s2);
        System.out.println("Expected: AB");
        System.out.println("Output: " + gcdOfStrings(s1,s2));

        s1 = "AAAAAB";
        s2 = "AAA";
        System.out.println("\nInput: s1=" + s1 + " s2=" + s2);
        System.out.println("Expected: \"\"");
        System.out.println("Output: " + gcdOfStrings(s1,s2));

        s1 = "LEET";
        s2 = "CODE";
        System.out.println("\nInput: s1=" + s1 + " s2=" + s2);
        System.out.println("Expected: \"\"");
        System.out.println("Output: " + gcdOfStrings(s1,s2));

        s1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        s2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println("\nInput: s1=" + s1 + " s2=" + s2);
        System.out.println("Expected: TAUXX");
        System.out.println("Output: " + gcdOfStrings(s1,s2));

        s1 = "ABCDEF";
        s2 = "ABC";
        System.out.println("\nInput: s1=" + s1 + " s2=" + s2);
        System.out.println("Expected:  \"\"");
        System.out.println("Output: " + gcdOfStrings(s1,s2));

        s1 = "A";
        s2 = "AA";
        System.out.println("\nInput: s1=" + s1 + " s2=" + s2);
        System.out.println("Expected: A");
        System.out.println("Output: " + gcdOfStrings(s1,s2));

    }
}
