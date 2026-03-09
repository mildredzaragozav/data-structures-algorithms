package com.mildred.datastructures.exercises.Stack;

/**
 * By "balanced," we mean that for every open parenthesis, there is a matching closing parenthesis in the
 * correct order. For example, the string "((()))" has three pairs of balanced parentheses, so it is a balanced
 * string. On the other hand, the string "(()))" has an imbalance, as the last two parentheses do not match,
 * so it is not balanced.  Also, the string ")(" is not balanced because the close parenthesis needs to follow
 * the open parenthesis.
 */
public class ParenthesesBalanced {

    public static boolean isBalancedParentheses(String s) {
        Stack<Character> stackList = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stackList.push(c);
            } else {
                if(stackList.isEmpty()) return false;
                stackList.pop();
            }
        }

        return stackList.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("These tests confirm isBalancedParentheses");
        System.out.println("works for empty strings, simple pairs,");
        System.out.println("nested parentheses, and unbalanced cases.");
        System.out.println();

        // Test 1
        System.out.println("Test 1: Empty String");
        System.out.println("Input: ''");
        System.out.println("Expected: true");
        System.out.println("Actual: " + isBalancedParentheses(""));
        System.out.println();

        // Test 2
        System.out.println("Test 2: Single Pair");
        System.out.println("Input: '()'");
        System.out.println("Expected: true");
        System.out.println("Actual: " + isBalancedParentheses("()"));
        System.out.println();

        // Test 3
        System.out.println("Test 3: Missing Open");
        System.out.println("Input: ')'");
        System.out.println("Expected: false");
        System.out.println("Actual: " + isBalancedParentheses(")"));
        System.out.println();

        // Test 4
        System.out.println("Test 4: Missing Close");
        System.out.println("Input: '('");
        System.out.println("Expected: false");
        System.out.println("Actual: " + isBalancedParentheses("("));
        System.out.println();

        // Test 5
        System.out.println("Test 5: Multiple Pairs");
        System.out.println("Input: '()()'");
        System.out.println("Expected: true");
        System.out.println("Actual: " + isBalancedParentheses("()()"));
        System.out.println();

        // Test 6
        System.out.println("Test 6: Nested Balanced");
        System.out.println("Input: '(())'");
        System.out.println("Expected: true");
        System.out.println("Actual: " + isBalancedParentheses("(())"));
        System.out.println();

        // Test 7
        System.out.println("Test 7: Nested Unbalanced");
        System.out.println("Input: '(()'");
        System.out.println("Expected: false");
        System.out.println("Actual: " + isBalancedParentheses("(()"));
        System.out.println();

        // Test 8
        System.out.println("Test 8: Complex Balanced");
        System.out.println("Input: '(()())()'");
        System.out.println("Expected: true");
        System.out.println("Actual: " + isBalancedParentheses("(()())()"));
        System.out.println();

        // Test 9
        System.out.println("Test 9: Complex Unbalanced");
        System.out.println("Input: '())(()'");
        System.out.println("Expected: false");
        System.out.println("Actual: " + isBalancedParentheses("())(()"));
        System.out.println();
    }
}
