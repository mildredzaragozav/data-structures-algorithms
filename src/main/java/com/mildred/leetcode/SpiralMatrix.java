package com.mildred.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    /**
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * Current complexity for this solution:
     * Time: O(m*n)
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int directRow = 0;
        int reverseRow = m-1;
        int directColumn = n-1;
        int reverseColumn = 0;
        boolean flag = true;

        while (spiral.size() < m * n) {
            if (flag) {
                for (int i = n - directColumn - 1; i <= directColumn; i++) {
                    spiral.add(matrix[directRow][i]);
                }
                for (int i = m - reverseRow; i <= reverseRow; i++) {
                    spiral.add(matrix[i][directColumn]);
                }
                directColumn--;
                directRow++;
            } else {
                for (int i = n-reverseColumn-2; n -directColumn - 2 <= i; i--) {
                    spiral.add(matrix[reverseRow][i]);
                }
                for (int i = m - directRow-1; m - reverseRow <= i; i--) {
                    spiral.add(matrix[i][reverseColumn]);
                }
                reverseRow--;
                reverseColumn++;
            }
            flag = !flag;
        }

        return spiral;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}, {19,20,21,22,23,24}, {25,26,27,28,29,30}};
        System.out.println("Input: " + Arrays.deepToString(matrix1));
        System.out.println("Output: " + spiralOrder(matrix1));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 12, 18, 24, 30, 29, 28, 27, 26, 25, 19, 13, 7, 8, 9, 10, 11, 17, 23, 22, 21, 20, 14, 15, 16] \n");

        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("Input: " + Arrays.deepToString(matrix));
        System.out.println("Output: " + spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5] \n");

        matrix = new int[][]{{1,2,3,4},{5,6,7,8}, {9,10,11,12}};
        System.out.println("Input: " + Arrays.deepToString(matrix));
        System.out.println("Output: " + spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3, 4, 8, 12, 11, 10 ,9, 5,6, 7] \n");

        matrix = new int[][]{{1},{2},{3}};
        System.out.println("Input: " + Arrays.deepToString(matrix));
        System.out.println("Output: " + spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3] \n");

        matrix = new int[][]{{1}};
        System.out.println("Input: " + Arrays.deepToString(matrix));
        System.out.println("Output: " + spiralOrder(matrix));
        System.out.println("Expected: [1] \n");

        matrix = new int[][]{{1,2,3,4}};
        System.out.println("Input: " + Arrays.deepToString(matrix));
        System.out.println("Output: " + spiralOrder(matrix));

    }
}
