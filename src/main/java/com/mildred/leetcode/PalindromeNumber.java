package com.mildred.leetcode;

public class PalindromeNumber {
    /**
     * Given an integer x, return true if x is a palindrome, and false otherwise.
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String xNumber = String.valueOf(x);
        int left = 0;
        int right = xNumber.length() - 1;

        while(left < right) {
            if (xNumber.charAt(left) != xNumber.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        int n1 = 121;
        System.out.println("Expected: true");
        System.out.println("Output: " + isPalindrome(n1));
        System.out.println();

        int n2 = 10;
        System.out.println("Expected: false");
        System.out.println("Output: " + isPalindrome(n2));
        System.out.println();

        int n3 = -121;
        System.out.println("Expected: false");
        System.out.println("Output: " + isPalindrome(n3));
        System.out.println();
    }
}
