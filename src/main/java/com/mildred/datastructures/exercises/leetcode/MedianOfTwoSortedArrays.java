package com.mildred.datastructures.exercises.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 1 && nums2.length == 1) return (double) (nums1[0] + nums2[0]) / 2;

        int index1 = 0;
        int index2 = 0;
        double median = 0;

        int totalSize = nums1.length + nums2.length;
        int medianIndex = (totalSize - 1) / 2;
        int aux = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (aux == medianIndex) {
                median = median + Math.min(nums1[index1], nums2[index2]);
                if (totalSize % 2 != 0) {
                    return median;
                } else {
                    if (nums1[index1] < nums2[index2]) {
                        index1++;
                        return (median + getSecondValue(nums1, index1, nums2, index2))/2;
                    } else {
                        index2++;
                        return (median + getSecondValue(nums2, index2, nums1, index1))/2;
                    }
                }
            }

            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }

            aux++;
        }

        if (index1 < nums1.length) {
            return traverseRemainingArray(aux, index1, nums1, medianIndex, totalSize);
        } else {
            return traverseRemainingArray(aux, index2, nums2, medianIndex, totalSize);
        }
    }

    private static double getSecondValue (int[] numsA, int indexA, int[] numsB, int indexB) {
        if (numsA.length == indexA) {
            return Math.min(numsB[indexB], numsB[indexB + 1]);
        } else {
            return Math.min(numsB[indexB], numsA[indexA]);
        }
    }
    private static double traverseRemainingArray(int aux, int index, int[] nums, int medianIndex, int totalSize) {
        while (index < nums.length) {
            if (aux == medianIndex) {
                if (totalSize % 2 != 0) {
                    return nums[index];
                } else {
                    return (double) (nums[index] + nums[index + 1]) / 2;
                }
            }
            index++;
            aux++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,4,5};
        int [] nums2 = {6,7,8,9};
        System.out.println("Input:    " + Arrays.toString(nums1) + " " + Arrays.toString(nums2));
        System.out.println("Output:   " + findMedianSortedArrays(nums1, nums2));
        System.out.println("Expected: 5.0");
        System.out.println();

        int [] nums3 = {1,3};
        int [] nums4 = {};
        System.out.println("Input:    " + Arrays.toString(nums3) + " " + Arrays.toString(nums4));
        System.out.println("Output:   " + findMedianSortedArrays(nums3, nums4));
        System.out.println("Expected: 2.0");
        System.out.println();

        int [] nums5 = {1};
        int [] nums6 = {2,3,4,5};
        System.out.println("Input:    " + Arrays.toString(nums5) + " " + Arrays.toString(nums6));
        System.out.println("Output:   " + findMedianSortedArrays(nums5, nums6));
        System.out.println("Expected: 3.0");
        System.out.println();

        int [] nums7 = {1,2};
        int [] nums8 = {3,4};
        System.out.println("Input:    " + Arrays.toString(nums7) + " " + Arrays.toString(nums8));
        System.out.println("Output:   " + findMedianSortedArrays(nums7, nums8));
        System.out.println("Expected: 2.5");
        System.out.println();

        int [] numsa = {1,3};
        int [] numsb = {2,7};
        System.out.println("Input:    " + Arrays.toString(numsa) + " " + Arrays.toString(numsb));
        System.out.println("Output:   " + findMedianSortedArrays(numsa, numsb));
        System.out.println("Expected: 2.5");
        System.out.println();

        int [] nums9 = {1,2,3,4,5};
        int [] nums10 = {6,7,8,9,10};
        System.out.println("Input:    " + Arrays.toString(nums9) + " " + Arrays.toString(nums10));
        System.out.println("Output:   " + findMedianSortedArrays(nums9, nums10));
        System.out.println("Expected: 5.5");
        System.out.println();

        int [] numsA = {1};
        int [] numsB = {1};
        System.out.println("Input:    " + Arrays.toString(numsA) + " " + Arrays.toString(numsB));
        System.out.println("Output:   " + findMedianSortedArrays(numsA, numsB));
        System.out.println("Expected: 1.0");
        System.out.println();
    }
}
