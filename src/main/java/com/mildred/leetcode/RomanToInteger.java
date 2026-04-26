package com.mildred.leetcode;

import java.util.Map;

import static java.util.Map.entry;

public class RomanToInteger {
    /**
     * Given a roman numeral, convert it to an integer.
     * @param s
     * @return
     * Complexity: O(N)
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> values = Map.ofEntries(
                entry('M', 1000),
                entry('D', 500),
                entry('C', 100),
                entry('L', 50),
                entry('X', 10),
                entry('V', 5),
                entry('I', 1));

        if (s.length() == 1) return values.get(s.charAt(0));

        int value = 0;
        int prev = 0;

        for (int i = s.length() - 1; 0 <= i; i--) {
            int currentValue = values.get(s.charAt(i));
            if (currentValue < prev) {
                value -= currentValue;
            } else {
                value += currentValue;
            }
            prev = currentValue;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("IV: " + romanToInt("IV"));
        System.out.println("XIV: " + romanToInt("XIV"));
        System.out.println("V: " + romanToInt("V"));
        System.out.println("VI: " + romanToInt("VI"));
        System.out.println("MCMXCIV: " + romanToInt("MCMXCIV") + " Expected: 1994");
    }
}
