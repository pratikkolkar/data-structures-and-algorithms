package dynamicProgramming;

import java.util.Arrays;
/* 
 * find the fibonaaci number of given number n
 * n = 5
 * solution = 5
 * 
 * Solution:
 * 1. Recursion method
 * 
 * Base case: return if n <= 1
 * 
 * Write a recurrence relation i.e., f(n-1) + f(n-2)
 *              (5) = 5
 *             /   \
 *       <3> (4)    (3) <2>
 *          /   \      
 *    <2> (3)    (2) <1>
 *       /   \
 *   <1>(2)   (1)<1>
 *     /  \
 *   (1)   (0)
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(N) stack calls
 * 
 * 2. Memoization
 * 
 * Initialize array named dp with size n+1
 * Store ith fibonaaci number value in ith index of array.
 * Before executing recurance funtion check if the answer already exists in array and return directly from array
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) stack calls + O(N) dp array
 * 
 * 3. Tabulation method
 * 
 * convert recurrence relation into tabulation 
 * dp[i]=dp[i-1]+dp[i-2]
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)  if space is optimized
 * 
 */
public class DP01Fibonacci {
    public static void main(String[] args) {
        // recurrsion(50);
        // memoization(100);
        // tabulation(1000);
        tabulationWithSpaceOptimized(1000);
    }

    private static void tabulationWithSpaceOptimized(long n) {
        long startTime = System.nanoTime();
        long prev2=0;
        long prev1=1;
        long curr=0;
        for (int i = 2; i <=(int)n; i++) {
            curr = prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        long totalTime = System.nanoTime()-startTime;
        System.out.println("Output: "+prev1);
        System.out.println("Time Elaspsed: "+(totalTime/1000000));
    }

    @SuppressWarnings("unused")
    private static void tabulation(long n) {
        long startTime = System.nanoTime();
        long dp[] = new long[(int)n+1];
        // Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1]=1;
        for (int i = 2; i <=(int)n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        long totalTime = System.nanoTime()-startTime;
        System.out.println("Output: "+dp[(int)n]);
        System.out.println("Time Elaspsed: "+(totalTime/1000000));
    }

    private static void memoization(long n) {
       long startTime = System.nanoTime();
       long dp[] = new long[(int)n+1];
       Arrays.fill(dp,-1);
       findByMomization(n,dp);
       long totalTime = System.nanoTime()-startTime;
       System.out.println("Output: "+dp[(int)n]);
       System.out.println("Time Elaspsed: "+(totalTime/1000000));
    }

    private static long findByMomization(long n, long[] dp) {
        if(n<=1) return n;
        if(dp[(int)n]!=-1) return dp[(int)n];
        dp[(int)n]= findByRecurrsion(n-1)+findByRecurrsion(n-2);
        return dp[(int)n];
    }

    private static void recurrsion(long n) {
       long startTime = System.nanoTime();
       n=findByRecurrsion(n);
       long totalTime = System.nanoTime()-startTime;
       System.out.println("Output: "+n);
       System.out.println("Time Elaspsed: "+(totalTime/1000000));
       
    }
    /* 
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    private static long findByRecurrsion(long n) {
        if(n<=1) return n;
        return findByRecurrsion(n-1)+findByRecurrsion(n-2);
    }


}
