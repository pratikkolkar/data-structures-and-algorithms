package arrays;

import java.util.Arrays;

import utils.Util;

public class Arrays13FindMissingNum {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        int n = arr.length;
        // solution1(arr,n);
        solution2(arr,n);
    }

    /* 
     * Observation:
     * Use
     * 
     */
    private static void solution2(int[] arr, int n) {
       int xor1 =0, xor2=0;
       for(int i=0; i<n; i++){
        xor1 = xor1 ^ arr[i]; // xor all the elements of array
        xor2 = xor2 ^ (i+1); // xor from 1 to N
       }
       Util.print(xor1 ^ xor2);// this will give missing number
    }

    /* 
     * Observation:
     * We know that the array elements are between 1 to N, hence we can calculate sum of first N natural number
     * and substract the total sum of the given array from first N natural number, then the result will be that missing number.
     * 
     * To calculate sum of first N natural number we can use below formula
     * sum = N*(N+1)/2
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private static void solution1(int[] arr, int n) {
        int sum = n*(n+1)/2;
        int arrSum = Arrays.stream(arr).sum();
        Util.print(sum-arrSum);
    }
}
