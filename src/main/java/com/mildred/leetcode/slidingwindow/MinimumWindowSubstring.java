package com.mildred.leetcode.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character
     * in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     * Current complexity
     * Time: O(n + m)
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        if (s.equalsIgnoreCase(t)) return s;

        HashMap<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            frequency.put(t.charAt(i), frequency.getOrDefault(t.charAt(i),0) + 1);
        }

        int targetCharsRemaining = t.length();
        int[] minWindow = {0, Integer.MAX_VALUE};
        int startWindow = 0;

        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char cc = s.charAt(endWindow);

            if (frequency.containsKey(cc) && frequency.get(cc) > 0) targetCharsRemaining--;

            frequency.put(cc, frequency.getOrDefault(cc,0) - 1);

            if (targetCharsRemaining == 0) {
                while (true) {
                    char charAtStart = s.charAt(startWindow);
                    if (frequency.containsKey(charAtStart) && frequency.get(charAtStart) == 0) break;

                    frequency.put(charAtStart, frequency.getOrDefault(charAtStart, 0) + 1);
                    startWindow++;
                }

                if (endWindow - startWindow < minWindow[1] - minWindow[0]) {
                    minWindow[1] = endWindow;
                    minWindow[0] = startWindow;
                }

                frequency.put(s.charAt(startWindow), frequency.getOrDefault(s.charAt(startWindow), 0)+1);
                targetCharsRemaining++;
                startWindow++;
            }
        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1]+1);
    }

    public static void main(String[] args) {
        String  s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Input: s=" + s + " t=" + t);
        System.out.println("Expected: BANC");
        System.out.println("Output: " + minWindow(s,t));

        s = "a";
        t = "aa";
        System.out.println("\nInput: s=" + s + " t=" + t);
        System.out.println("Expected: \"\"");
        System.out.println("Output: " + minWindow(s,t));


    }
}
