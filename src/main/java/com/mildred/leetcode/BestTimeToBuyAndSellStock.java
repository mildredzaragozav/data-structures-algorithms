package com.mildred.leetcode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * Current complexity for this solution:
     * Time: O(n)
     * Space: O(1)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;

        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i]-buy);
        }
        return sell;
    }

    public static void main(String[] args) {
        int prices [] = new int[]{7,1,5,3,6,4};
        System.out.println("Input: " + Arrays.toString(prices));
        System.out.println("Expected: 5");
        System.out.println("Output: " + maxProfit(prices) + " \n");

        prices = new int[]{7,6,4,3,1};
        System.out.println("Input: " + Arrays.toString(prices));
        System.out.println("Expected: 0");
        System.out.println("Output: " + maxProfit(prices) + " \n");
    }
}
