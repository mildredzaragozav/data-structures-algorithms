package com.mildred.leetcode;

public class IntegerToRoman {

    /**
     * Given an integer, convert it to a Roman numeral.
     * @param num: a decimal number
     * @return the roman numeral
     */
    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) return null;

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int n = 3525;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: MMMDXXV \n" );

        n = 3749;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: MMMDCCXLIX \n");

        n = 58;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: LVIII \n" );

        n = 3;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: III \n" );
    }
}
