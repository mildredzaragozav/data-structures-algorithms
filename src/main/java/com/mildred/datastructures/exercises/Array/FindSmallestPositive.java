package com.mildred.datastructures.exercises.Array;

import java.util.*;

public class FindSmallestPositive {
    /**
     * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     * Input: [1,3,2,4,5,1]  Output: 5
     * Input: [-1, -3]        Output: 1
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        Set<Integer> positives = new HashSet<>();

        for (int n : A) {
            if(n > 0) positives.add(n);
        }

        int smallest = 1;
        while (positives.contains(smallest)) {
            smallest++;
        }

        return smallest;
    }

    public static void main(String[] args) {

    }

}
