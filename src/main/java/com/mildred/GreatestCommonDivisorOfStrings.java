package com.mildred;

public class GreatestCommonDivisorOfStrings {
    /**
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) return str1;

        String t = str1.length() < str2.length() ? str1 : str2;

        while (str1.length() % t.length() != 0 || str2.length() % t.length() != 0) {
            t = t.substring(0, t.length() -1);
        }

        int index = 0;

        while (index < str1.length()) {
            String s1 = str1.substring(index, index + t.length());
            if (!s1.equals(t)) return "";
            index += t.length();
        }

        index = 0;

        while (index < str2.length()) {
            String s2 = str2.substring(index, index + t.length());
            if (!s2.equals(t)) return "";
            index += t.length();
        }

        return t;
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
