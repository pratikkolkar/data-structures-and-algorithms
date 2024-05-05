package dynamicProgramming;

import java.util.Arrays;

public class DP17CountSubsetWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 5};
        int k =5;
        // recursion(arr,k);
        // memoization(arr,k);
        // tabulation(arr,k);
        tabulationWithSpaceOptimized(arr,k);

    }


    /* 
     * Approach pick and non-pick
     * 
     * TC: O(N * K)
     * SC: O(K)
     */
    private static void tabulationWithSpaceOptimized(int[] arr, int k) {
        int n = arr.length;
        int[] dp=new int[k+1];
        //Base case
        dp[0]=1;
        if(arr[0]<=k)
            dp[arr[0]]=1;

        for(int idx=1; idx<n; idx++){ 
            int[] curr=new int[k+1];
            curr[0]=1;
            for (int sum = 1; sum <=k; sum++) {
                curr[sum] += dp[sum];
                if(sum>=arr[idx])
                curr[sum]+=dp[sum-arr[idx]];
            }
            dp=curr;
        }
        System.out.println("Output: "+dp[k]);
    }


    /* 
     * Approach pick and non-pick
     * 
     * TC: O(N * K)
     * SC: O(N*K)
     */
    private static void tabulation(int[] arr, int k) {
        int n = arr.length;
        int[][] dp=new int[n][k+1];
        //Base case
        for (int i = 0; i < n; i++) {
            dp[i][0]=1;
        }
        if(arr[0]<=k)
            dp[0][arr[0]]=1;

        for(int idx=1; idx<n; idx++){
            for (int sum = 1; sum <=k; sum++) {
                dp[idx][sum] += dp[idx-1][sum];
                if(sum>=arr[idx])
                dp[idx][sum]+=dp[idx-1][sum-arr[idx]];
            }
        }
        System.out.println("Output: "+dp[n-1][k]);

    }

    private static void memoization(int[] arr, int k) {
        int n = arr.length;
        int[][] dp=new int[n][k+1];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        int output = memoization(arr,n-1, k,dp);
        System.out.println("Output: "+output);
    }
    /* 
     * Approach pick and non-pick
     * 
     * TC: O(N)
     * SC: O(N)+O(N)
     */
    private static int memoization(int[] arr, int idx, int k, int[][] dp) {
        //Base case:
        if(k==0) return 1;
        if(idx==0) return arr[idx]==k?1:0;


        if(dp[idx][k]!=-1) return dp[idx][k];
        int left = recursion(arr, idx-1, k);
        int right = 0;
        if(k>=arr[idx])
            right = recursion(arr, idx-1, k-arr[idx]);
        dp[idx][k]=left+right;
        return dp[idx][k];
    }

    private static void recursion(int[] arr,int k) {
        int n = arr.length;
        int output = recursion(arr,n-1, k);
        System.out.println("Output: "+output);
    }


    /* 
     * Approach pick and non-pick
     * 
     * TC: O(2^n)
     * SC: O(N)+O(N)
     */
    private static int recursion(int[] arr, int idx, int k) {
        //Base case:
        if(k==0) return 1;
        if(idx==0) return arr[idx]==k?1:0;

        int left = recursion(arr, idx-1, k);
        int right = 0;
        if(k>=arr[idx])
            right = recursion(arr, idx-1, k-arr[idx]);
        return left+right;
    }
}
