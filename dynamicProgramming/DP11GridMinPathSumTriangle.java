package dynamicProgramming;

import java.util.Arrays;

/**
 * DP11GridMinPathSumTriangle
 * 
 * Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

    

    Example 1:

    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
    2
    3 4
    6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
    Example 2:

    Input: triangle = [[-10]]
    Output: -10
    

    Constraints:

    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -104 <= triangle[i][j] <= 104
 */
public class DP11GridMinPathSumTriangle {
    public static void main(String[] args) {
        int[][] arr = { { 2 }, { 3,4 }, { 5,6,7 } ,{4,1,8,3}};
        // int m = arr.length - 1;
        // int n = arr[0].length - 1;
        // recursion(arr);
        // memoization(arr);
        tabulation(arr);
        // tabulationSpaceOptimized(arr, m, n);

    }

    private static void tabulationSpaceOptimized(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = arr[i][j];
                } else {
                    int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                    if (i > 0) {
                        left = arr[i][j] + dp[j];
                    }

                    if (j > 0) {
                        right = arr[i][j] + curr[j - 1];
                    }
                    curr[j]=Math.min(left, right);
                }
            }
            dp = curr;
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /* 
     * 
     * Tabulation:
     * Time Comeplexity: O(M x N)
     * Space Complexity: O(M x Max(N))
     */
    private static void tabulation(int[][] arr) {
        long startTime = System.nanoTime();
        int dp[][] = new int[arr.length][arr[arr.length-1].length];
        for(int m = arr.length-1; m>=0; m--){
            for (int n = arr[m].length-1; n >=0 ; n--) {
                if(m==arr.length-1){
                    dp[m][n]=arr[m][n];
                }else{
                    int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                    left = arr[m][n] + dp[m+1][n];
                    right = arr[m][n] + dp[m+1][n+1];
                    dp[m][n]=Math.min(left, right);
                }
            }
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[0][0]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int[][] arr) {
        long startTime = System.nanoTime();
        int dp[][] = new int[arr.length][arr[arr.length-1].length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        findByMomization(arr, 0, 0, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[0][0]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

     /* 
     * Memoization:
     * Time Complexity = O(MxN)
     * Space Complexity = O(max(m,n)) + O(M x Maz(N))
     * 
     */
    private static int findByMomization(int[][] arr, int m, int n, int[][] dp) {
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        // Base case:
        // Edge case: Check if one is present
       if(m==arr.length-1 && n<arr[m].length){
            return arr[m][n];
       }

       if(m>arr.length-1 && n > arr[m].length -1 ) return Integer.MAX_VALUE;
       if(dp[m][n] !=-1) return dp[m][n];
       left = arr[m][n] + findByMomization(arr, m+1, n,dp);
       right = arr[m][n] + findByMomization(arr, m+1, n+1,dp);
       dp[m][n]=Math.min(left, right);
        return dp[m][n];
    }

    private static void recursion(int[][] arr) {
        long startTime = System.nanoTime();
        System.out.println("Output: " + findByRecursion(arr, 0, 0));
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /* 
     * Recusrion:
     * Time Complexity = O(2^m)
     * Space Complexity = O(max(m,n))
     * 
     */
    private static int findByRecursion(int[][] arr, int m, int n) {
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        // Base case:
        // Edge case: Check if one is present
       if(m==arr.length-1 && n<arr[m].length){
            return arr[m][n];
       }

       if(m>arr.length-1 && n > arr[m].length -1 ) return Integer.MAX_VALUE;
       left = arr[m][n] + findByRecursion(arr, m+1, n);
       right = arr[m][n] + findByRecursion(arr, m+1, n+1);
        return Math.min(left, right);
    }
}
