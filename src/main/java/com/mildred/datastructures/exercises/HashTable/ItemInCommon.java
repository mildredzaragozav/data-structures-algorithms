package com.mildred.datastructures.exercises.HashTable;

import java.util.HashMap;

public class ItemInCommon {

    /**
     * Complexity O(n^2)
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean itemInCommonInefficient(int[] arr1, int[] arr2) {
        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) return true;
            }
        }
        return false;
    }

    /**
     * O(n)
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean itemInCommon(int[] arr1, int[] arr2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();
        for (int i : arr1) {
            myHashMap.put(i, true);
        }

        for (int j : arr2) {
            if (myHashMap.get(j) != null) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {100,300,180,600,700,80,90,70,5};
        int[] arr2 = {10,40,10,6,19,23,4,8,5};


        System.out.println(itemInCommonInefficient(arr1, arr2));
        System.out.println(itemInCommon(arr1, arr2));
    }
}
