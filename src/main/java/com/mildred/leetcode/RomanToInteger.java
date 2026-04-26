package com.mildred.leetcode;

public class RomanToInteger {
    /**
     * Given a roman numeral, convert it to an integer.
     * @param s
     * @return
     * Complexity: O(N)
     */
    public static int romanToInt(String s) {
        int value = 0;
        int prev = getInt(s.charAt(s.length()-1));

        for (int i = s.length() - 1; 0 <= i; i--) {
            int currentValue = getInt(s.charAt(i));

            if (currentValue < prev) {
                value -= currentValue;
            } else {
                value += currentValue;
            }

            prev = currentValue;
        }
        return value;
    }

    private static int getInt(char roman) {
        return switch (roman) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println("Input: V   Expected: 5  Output: " + romanToInt("V"));
        System.out.println("Input: IV  Expected: 4  Output: " + romanToInt("IV"));
        System.out.println("Input: VI  Expected: 6  Output: " + romanToInt("VI"));
        System.out.println("Input: XIV Expected: 14 Output: " + romanToInt("XIV"));
        System.out.println("Input: MCMXCIV Expected: 1994 Output: " + romanToInt("MCMXCIV"));
    }
}
