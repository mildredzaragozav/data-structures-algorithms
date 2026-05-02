package com.mildred.leetcode;

public class ReverseInteger {
    /**
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit
     * integer range [-2^31, 2^31 - 1], then return 0.
     * NOTE: Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range
     * @param x
     * @return
     * Complexity for this solution: O(n^2)
     */
    public static int reverse(int x) {
        if (x < 0) {
            return -helper(String.valueOf(x).substring(1), true);
        } else {
            return helper(String.valueOf(x), false);
        }
    }

    private static int helper (String s, boolean isNegative){
        int result = 0;
        for (int i = s.length() - 1; 0 <= i; i--) {
            result = (int) (Integer.parseInt(String.valueOf(s.charAt(i))) * (Math.pow(10, i)) + result);
        }

        if ( !isNegative && result == Integer.MAX_VALUE) {
            return 0;
        } else if (isNegative && -result == Integer.MIN_VALUE+1) {
            return 0;
        }

        return result;
    }

    public static void main (String[]args){
        System.out.println("Input:  1425897121 Expected: 1217985241    Output: " + reverse(1425897121));
        System.out.println("Input: -2147483648 Expected: 0             Output: " + reverse(-2147483648));
        System.out.println("Input:  1534236469 Expected: 0             Output: " + reverse(1534236469));
        System.out.println("Input:  123567     Expected: 765321        Output: " + reverse(123567));
        System.out.println("Input:  856420     Expected:  24658        Output: " + reverse(856420));
        System.out.println("Input: -1894       Expected: -4981         Output: " + reverse(-1894));
    }
}
