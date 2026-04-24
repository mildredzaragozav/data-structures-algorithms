package com.mildred.leetcode;

public class PalindromeNumber {
    /**
     * Given an integer x, return true if x is a palindrome, and false otherwise.
     * This approach stores one half of the integer in a another variable in reversed order. Then compares it
     * to the other unaltered half of the number and see if they are equal or not
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int reversed = 0;
        while(x > reversed){
            reversed = reversed * 10 + (x % 10); // Add last digit
            x /= 10; // Delete last digit
        }

        return x == reversed || x == reversed / 10;
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
