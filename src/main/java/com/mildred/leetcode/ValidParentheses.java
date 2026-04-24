package com.mildred.leetcode;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 3. Every close bracket has a corresponding open bracket of the same type.
     * @param s input string
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char temp = stack.pop();
                if (c == ')' && temp != '(') {
                    return false;
                }

                if (c == '}' && temp != '{') {
                    return false;
                }

                if (c == ']' && temp != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        System.out.println("Input:     " + s1);
        System.out.println("Output:    " + isValid(s1));
        System.out.println("Expected:  true" );
        System.out.println();

        String s2 = "(]";
        System.out.println("Input:     " + s2);
        System.out.println("Output:    " + isValid(s2));
        System.out.println("Expected:  false" );
        System.out.println();

        String s3 = "()";
        System.out.println("Input:     " + s3);
        System.out.println("Output:    " + isValid(s3));
        System.out.println("Expected:  true" );
        System.out.println();

        String s4 = "([])";
        System.out.println("Input:     " + s4);
        System.out.println("Output:    " + isValid(s4));
        System.out.println("Expected:  true" );
        System.out.println();

        String s5 = "([)]";
        System.out.println("Input:     " + s5);
        System.out.println("Output:    " + isValid(s5));
        System.out.println("Expected:  false" );
        System.out.println();
    }
}
