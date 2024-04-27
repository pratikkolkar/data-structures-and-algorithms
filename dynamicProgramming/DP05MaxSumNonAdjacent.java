package dynamicProgramming;

import java.util.Arrays;

/**
 * DP05MaxSumNonAdjacent
 * Problem statement
    You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.

    Note:
    A subsequence of an array/list is obtained by deleting some number of elements (can be zero) from the array/list, leaving the remaining elements in their original order.
    Detailed explanation ( Input/output format, Notes, Images )
    Constraints:
    1 <= T <= 500
    1 <= N <= 1000
    0 <= ARR[i] <= 10^5

    Where 'ARR[i]' denotes the 'i-th' element in the array/list.

    Time Limit: 1 sec.
    Sample Input 1:
    2
    3
    1 2 4
    4
    2 1 4 9
    Sample Output 1:
    5
    11
    Explanation to Sample Output 1:
    In test case 1, the sum of 'ARR[0]' & 'ARR[2]' is 5 which is greater than 'ARR[1]' which is 2 so the answer is 5.

    In test case 2, the sum of 'ARR[0]' and 'ARR[2]' is 6, the sum of 'ARR[1]' and 'ARR[3]' is 10, and the sum of 'ARR[0]' and 'ARR[3]' is 11. So if we take the sum of 'ARR[0]' and 'ARR[3]', it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.
    Sample Input 2:
    2
    5
    1 2 3 5 4
    9
    1 2 3 1 3 5 8 1 9
    Sample Output 2:
    8
    24
    Explanation to Sample Output 2:
    In test case 1, out of all the possibilities, if we take the sum of 'ARR[0]', 'ARR[2]' and 'ARR[4]', i.e. 8, it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.

    In test case 2, out of all the possibilities, if we take the sum of 'ARR[0]', 'ARR[2]', 'ARR[4]', 'ARR[6]' and 'ARR[8]', i.e. 24 so, it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.
 */
public class DP05MaxSumNonAdjacent {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
        int n = arr.length - 1;
        // recursion(arr, n);
        // memoization(arr,n);
        // tabulation(arr,n);
        tabulationWithSpaceOptimized(arr, n); // possible
        
    }

    private static void tabulationWithSpaceOptimized(int[] arr, int n) {
        long startTime = System.nanoTime();
        int prev1 = arr[0];
        int prev2 = 0;
        for (int i = 1; i <arr.length; i++) {
            int left = arr[i];
            if(i>1)
                left +=prev2;
            int right = 0 + prev1;
            prev2=prev1;
            prev1 = Math.max(left, right);
             
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + prev1);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void tabulation(int[] arr, int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        dp[0] = arr[0];
        for (int i = 1; i <arr.length; i++) {
            int left = arr[i];
            if(i>1)
                left +=dp[i-2];
            int right = 0 + dp[i-1];
            dp[i] = Math.max(left, right);
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int[] arr, int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        findByMomization(arr, n, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n-1]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByMomization(int[] arr, int n, int[] dp) {
        if ( n == 0) {
            return arr[n];
        }
        if( n < 0){
            return 0;
        }
        if ( dp[n] != -1) return dp[n];
        int left = arr[n] + findByMomization(arr, n-2, dp);
        int right = 0 + findByMomization(arr, n-1,dp);
        dp[n] = Math.max(left, right);
        return dp[n];
    }

    private static void recursion(int[] arr, int n) {
        long startTime = System.nanoTime();
        n = findByRecursion(arr, n);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + n);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByRecursion(int[] arr, int n) {
        if ( n == 0) {
            return arr[n];
        }
        if( n < 0){
            return 0;
        }
        int left = arr[n] + findByRecursion(arr, n-2);
        int right = 0 + findByRecursion(arr, n-1);
        return Math.max(left, right);
    }
}