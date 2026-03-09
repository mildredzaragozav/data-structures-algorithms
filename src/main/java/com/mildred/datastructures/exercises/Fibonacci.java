package com.mildred.datastructures.exercises;

public class Fibonacci {
    private static int counter = 0;
    private static Integer[] nums = new Integer[100];

    /**
     * Gets the Fibonacci number at index n.
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        counter++;
        if (n == 1 || n == 0) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciMemoization(int n) {
        counter++;
        if (nums[n] != null) {
            return nums[n];
        }
        if (n == 1 || n == 0) return n;

        nums[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return nums[n];
    }

    public static void main(String[] args) {
        int n = 2;
        int x;
        Integer y;
        //System.out.println("Fibonacci of " + n + ": " + fibonacci(n));
        System.out.println("Fibonacci of " + n + ": " + fibonacciMemoization(n));
        System.out.println("Total calls: " + counter);
    }
}
