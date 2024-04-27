package dynamicProgramming;

import java.util.Arrays;

public class DP09UniquePathII {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int m = arr.length-1;
        int n = arr[0].length - 1;
        // recursion(arr,m,n);
        // memoization(arr,m,n);
        // tabulation(arr,m,n);
        tabulationSpaceOptimized(arr, m, n);

    }

    private static void tabulationSpaceOptimized(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        for (int i = 0; i <=m; i++) {
            int[] curr=new int[n+1];
            for (int j = 0; j <=n; j++) {
                if(i==0 && j ==0 & arr[i][j]!=1){
                    curr[j]=1;
                }else if(arr[i][j]!=1){
                    if(i>0){
                        curr[j] =dp[j];
                    }
                    
                    if(j>0){
                        curr[j] +=curr[j-1];
                    }
                }
            }
            dp=curr;
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void tabulation(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        int dp[][] = new int[m+1][n + 1];
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <=n; j++) {
                if(i==0 && j ==0 & arr[i][j]!=1){
                    dp[i][j]=1;
                }else if(arr[i][j]!=1){
                    if(i>0){
                        dp[i][j] +=dp[i-1][j];
                    }

                    if(j>0){
                        dp[i][j] +=dp[i][j-1];
                    }
                }
            }
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[m][n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        int dp[][] = new int[m+1][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        findByMomization(arr, m, n, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[m][n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByMomization(int[][] arr, int m, int n, int[][] dp) {
        int left=0, right = 0;
        //Base case:
        //Edge case: Check if one is present
        if(m==0 && n == 0 && arr[m][n] != 1){
         return 1;
        }

        
        if(arr[m][n] == 1 || m<0 || n<0) return 0;

        if(dp[m][n] != -1) return dp[m][n];
 
        if(m>0){
         left = findByMomization(arr, m-1, n,dp);
        }
 
        if (n>0) {
         right=findByMomization(arr, m, n-1,dp);
        }
        dp[m][n]=left+right;
        return dp[m][n];
    }

    private static void recursion(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        System.out.println("Output: " + findByRecursion(arr, m, n));
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByRecursion(int[][] arr, int m, int n) {
       int left=0, right = 0;
       //Base case:
       //Edge case: Check if one is present
       if(m==0 && n == 0 && arr[m][n] != 1){
        return 1;
       }

       if(arr[m][n] == 1 || m<0 || n<0) return 0;

       if(m>0){
        left = findByRecursion(arr, m-1, n);
       }

       if (n>0) {
        right=findByRecursion(arr, m, n-1);
       }

       return left+right;
    }
}
