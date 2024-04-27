package dynamicProgramming;

import java.util.Arrays;

public class DP04JumpingFrogKRange {
    public static void main(String[] args) {
        int[] arr = { 10, 40, 50, 20, 60 };
        int n = arr.length - 1;
        int k = 3;
        // recursion(arr, n, k);
        // memoization(arr,n,k);
        tabulation(arr,n,k);
        // tabulationWithSpaceOptimized(arr, n,k); // Not possible
    }

    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private static void tabulationWithSpaceOptimized(int[] arr, int n, int k) {
        long startTime = System.nanoTime();
        int prev = 0;
        int prev1 = 0;
        for (int i = 1; i <= n; i++) {
            int minCost=Integer.MAX_VALUE;
            for (int j = 1; j <=k; j++) {
                int jumpCost=Integer.MAX_VALUE;
                if(i-j>=0){
                    jumpCost=prev + Math.abs(arr[i] - arr[i - 1]);
                    minCost=Math.min(minCost, jumpCost);
                }
                
            }
            prev = minCost;
            
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + prev);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N) -> dp array
     */
    private static void tabulation(int[] arr, int n, int k) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minCost=Integer.MAX_VALUE;
            for (int j = 1; j <=k; j++) {
                int jumpCost=Integer.MAX_VALUE;
                if (i-j>=0) {
                    jumpCost=dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minCost=Math.min(minCost, jumpCost);
                }
            }
            dp[i]=minCost;
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N) + O(N) = (Stack space + Dp array space)
     */
    private static void memoization(int[] arr, int n, int k) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        findByMomization(arr, n, dp, k);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N) + O(N) = (Stack space + Dp array space)
     */
    private static int findByMomization(int[] arr, int n, int[] dp, int k) {
        if (n <= 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
            int minCost = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            int jumpCost=Integer.MAX_VALUE;
            if(n-i>=0){
                jumpCost=findByMomization(arr, n - i,dp, k) + Math.abs(arr[n] - arr[n - i]);
            }
            minCost = Math.min(minCost, jumpCost);
        }        
        dp[n]=minCost;
        return dp[n];
    }

    private static void recursion(int[] arr, int n, int k) {
        long startTime = System.nanoTime();
        n = findByRecursion(arr, n, k);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + n);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * Time Complexity: O(2^N)
     * Space COmplexity: O(N) - Stack space
     */
    private static int findByRecursion(int[] arr, int n, int k) {
        if (n <= 0)
            return 0;

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int jumpCost = Integer.MAX_VALUE;
            ;
            if (n - i >= 0) {
                jumpCost = findByRecursion(arr, n - i, k) + Math.abs(arr[n] - arr[n - i]);
            }
            minCost = Math.min(minCost, jumpCost);
        }
        return minCost;
    }
}
