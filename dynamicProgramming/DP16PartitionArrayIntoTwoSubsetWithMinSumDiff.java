package dynamicProgramming;

import java.util.Arrays;



/* 
 * Problem needs to be solved with DP
 */





/*
    Problem Statement:

    You are given an integer array nums of 2 * n integers. 
    You need to partition nums into two arrays of length n 
    to minimize the absolute difference of the sums of the arrays. 
    To partition nums, put each element of nums into one of the two arrays.
    Return the minimum possible absolute difference.

    Input: nums = [3,9,7,3]
    Output: 2
    Explanation: One optimal partition is: [3,9] and [7,3].
    The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
 */
public class DP16PartitionArrayIntoTwoSubsetWithMinSumDiff {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] arr = {13,40,61,94,35,55};
        recursion(arr);
    }

    private static void recursion(int[] arr) {
        long startTime = System.nanoTime();
        int output = recursion(arr, 0, 0, 0, 0, 0);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + output);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }


    /* 
     * Time Complexity: O(2^N)
     * Space Complexity: O(N) + O(N)
     */
    private static int recursion(int[] nums, int index,
    int arr1_sum, int arr2_sum,
    int arr1_length,
    int arr2_length) {
        if (arr1_length > nums.length / 2
        || arr2_length > nums.length / 2) {
        return Integer.MAX_VALUE;
    }

    if (index == nums.length) {
        int diff = arr1_sum - arr2_sum;
        // min = Math.min(min, Math.abs(diff));
        return Math.abs(diff);
    }

    return Math.min(recursion(nums, index + 1, arr1_sum + nums[index],
          arr2_sum, arr1_length + 1, arr2_length),
          recursion(nums, index + 1, arr1_sum,
          arr2_sum + nums[index], arr1_length,
          arr2_length + 1));
    }

    
}