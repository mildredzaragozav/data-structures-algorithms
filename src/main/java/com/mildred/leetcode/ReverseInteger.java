package com.mildred.leetcode;

public class ReverseInteger {
    /**
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit
     * integer range [-2^31, 2^31 - 1], then return 0.
     * NOTE: Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range
     * @param x
     * @return
     * Complexity for this solution
     * Time complexity: O(log(x)) Space complexity: O(1)
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10) return 0;
            if (result < Integer.MIN_VALUE/10) return 0;
            result = result * 10 + pop;
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
