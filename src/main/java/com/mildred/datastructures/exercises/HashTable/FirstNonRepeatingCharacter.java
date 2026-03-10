package com.mildred.datastructures.exercises.HashTable;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static Character firstNonRepeatingChar(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            if(map.get(string.charAt(i)) == 1) return string.charAt(i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("These tests confirm firstNonRepeatingChar()");
        System.out.println("returns the first unique character or null");
        System.out.println("if no unique character exists.");
        System.out.println();

        // Test 1: First unique character exists
        System.out.println("Test 1: First Unique Exists");
        String input1 = "swiss";
        System.out.println("Expected: w");
        System.out.println("Actual: " + firstNonRepeatingChar(input1));
        System.out.println();

        // Test 2: No unique character
        System.out.println("Test 2: No Unique Character");
        String input2 = "aabbcc";
        System.out.println("Expected: null");
        System.out.println("Actual: " + firstNonRepeatingChar(input2));
        System.out.println();

        // Test 3: First character is unique
        System.out.println("Test 3: First Character Unique");
        String input3 = "alphabet";
        System.out.println("Expected: l");
        System.out.println("Actual: " + firstNonRepeatingChar(input3));
        System.out.println();

        // Test 4: Mixed duplicates
        System.out.println("Test 4: Mixed Duplicates");
        String input4 = "success";
        System.out.println("Expected: u");
        System.out.println("Actual: " + firstNonRepeatingChar(input4));
        System.out.println();

        // Test 5: Empty string
        System.out.println("Test 5: Empty String");
        String input5 = "";
        System.out.println("Expected: null");
        System.out.println("Actual: " + firstNonRepeatingChar(input5));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm firstNonRepeatingChar()
            returns the first unique character or null
            if no unique character exists.

            Test 1: First Unique Exists
            Expected: w
            Actual: w

            Test 2: No Unique Character
            Expected: null
            Actual: null

            Test 3: First Character Unique
            Expected: l
            Actual: l

            Test 4: Mixed Duplicates
            Expected: u
            Actual: u

            Test 5: Empty String
            Expected: null
            Actual: null
        */

    }
}
