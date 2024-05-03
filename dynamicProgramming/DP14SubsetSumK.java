package dynamicProgramming;

import java.util.Arrays;

/* 
    Problem statement
    You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. 
    Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

    Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

    For Example :
    If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. 
    These are {1,3} and {4}. Hence, return true.
 */
public class DP14SubsetSumK {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 2, 9, 10 };
        int k = 6;
        // recursion(arr, k);
        // memoization(arr,k);
        // tabulation(arr, k);
        tabulationWithSpaceOptimzed(arr, k);

    }

    /*
     * Time Complexity: O(N * k)
     * Space Complexity: O(2k)
     */
    private static void tabulationWithSpaceOptimzed(int[] arr, int k) {
        long startTime = System.nanoTime();
        int n = arr.length;
        boolean[] dp = new boolean[k + 1];

        // Base case 1
        dp[0] = true;

        // Base case 2
        if (arr[0] <= k)
            dp[arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean left = dp[target];
                boolean right = false;
                if (target >= arr[idx])
                    right = dp[target - arr[idx]];
                curr[target] = left | right;
            }
            dp = curr;
        }

        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[k]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * Time Complexity: O(N * k)
     * Space COmplexity: O(N * K)
     */
    private static void tabulation(int[] arr, int k) {
        long startTime = System.nanoTime();
        int m = arr.length;
        boolean dp[][] = new boolean[m][k + 1];

        // Base case 1: for any value of index if target is zero then mark it as true
        for (int i = 0; i < m; i++)
            dp[i][0] = true;

        // Base case 2: At index 0 if arr[0] == target then mark it as true. We can
        // fetch target value directly from arr[0]
        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int idx = 1; idx < arr.length; idx++) {
            for (int target = 1; target <= k; target++) {
                boolean left = dp[idx - 1][target];
                boolean right = false;
                if (target >= arr[idx]) {
                    right = dp[idx - 1][target - arr[idx]];
                }
                dp[idx][target] = left | right;
            }
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[m - 1][k]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int[] arr, int k) {
        long startTime = System.nanoTime();
        int m = arr.length;
        boolean dp[][] = new boolean[m][k + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, false));
        memoization(arr, m - 1, k, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + (dp[m - 1][k]));
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N * k) + O(N)
     * 
     */
    private static boolean memoization(int[] arr, int idx, int target, boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (idx == 0) {
            return target == arr[idx];// ? 1 : 0;
        }

        if (dp[idx][target] != false)
            return dp[idx][target];

        boolean left = memoization(arr, idx - 1, target, dp);
        boolean right = false;
        if (target >= arr[idx]) {
            right = memoization(arr, idx - 1, target - arr[idx], dp);
        }
        dp[idx][target] = left | right;// Math.max(left, right);
        return dp[idx][target];
    }

    private static void recursion(int[] arr, int k) {
        long startTime = System.nanoTime();
        int n = arr.length - 1;
        boolean max = recursion(arr, n, k);
        System.out.println("Output: " + max);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * 
     * 1. changing state of recurence relation: idx and target
     * 2. recurence relation:
     * left = f(idx-1,target) -> this recursion searches if target exits in array
     * if target > arr[idx]
     * right = f(idx-1, target - arr[idx])
     * 3. Base case:
     * 1. if target == 0 return true
     * 2. if idx == 0 and target == arr[0] then return true
     * 
     * 4. Return left || right
     * 
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(N) + O(N)
     * 
     */
    private static boolean recursion(int[] arr, int idx, int target) {
        if (target == 0) {
            return true;
        }

        if (idx == 0) {
            return target == arr[idx];
        }

        boolean left = recursion(arr, idx - 1, target);
        boolean right = false;
        if (target >= arr[idx]) {
            right = recursion(arr, idx - 1, target - arr[idx]);
        }
        return left | right;
    }
}
