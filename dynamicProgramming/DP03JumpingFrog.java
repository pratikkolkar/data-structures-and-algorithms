package dynamicProgramming;

import java.util.Arrays;

/* 
 * Problem statement
There is a frog on the '1st' step of an 'N' stairs long staircase. 
The frog wants to reach the 'Nth' stair. 
'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, 
the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). 
If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. 
Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) 
and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= HEIGHTS[i] <= 1000 .

Time limit: 1 sec
Sample Input 1:
2
4
10 20 30 10
3
10 50 10
Sample Output 1:
20
0
Explanation of sample input 1:
For the first test case,
The frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost).
Then a jump from the 2nd stair to the last stair (|10-20| = 10 energy lost).
So, the total energy lost is 20 which is the minimum. 
Hence, the answer is 20.

For the second test case:
The frog can jump from 1st stair to 3rd stair (|10-10| = 0 energy lost).
So, the total energy lost is 0 which is the minimum. 
Hence, the answer is 0.
Sample Input 2:
2
8
7 4 4 2 6 6 3 4 
6
4 8 3 10 4 4 
Sample Output 2:
7
2


Hints:
1. Think about all the possibilities at each stair.
2. Using recursion, try to divide the problem into subproblems and calculate the answer for each subproblem only once - store it for reusing in the future.
3. The above can also be done iteratively.



 */
public class DP03JumpingFrog {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};

        // recursion(arr,arr.length-1);
        // memoization(arr,arr.length-1);
        // tabulation(arr,arr.length-1);
        tabulationWithSpaceOptimized(arr,arr.length-1);
    }

    /* 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private static void tabulationWithSpaceOptimized(int[] arr, int n) {
        long startTime = System.nanoTime();
        int prev = 0;
        int prev1=0;
        for (int i = 1; i <= n; i++) {
            int first = prev + Math.abs(arr[i] - arr[i-1]);
            int second = Integer.MAX_VALUE;
            if(i>1)
                second = prev1 + Math.abs(arr[i] - arr[i-2]);
            prev1=prev;
            prev=Math.min(first,second); 
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + prev);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }


    /* 
     * Time Complexity: O(N)
     * Space Complexity: O(N) -> dp array
     */
    private static void tabulation(int[] arr, int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int first = dp[i - 1] + Math.abs(arr[i] - arr[i-1]);
            int second = Integer.MAX_VALUE;
            if(i>1)
                second = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            dp[i] = Math.min(first,second); 
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /* 
     * Time Complexity: O(N)
     * Space Complexity: O(N) + O(N) = (Stack space + Dp array space) 
     */
    private static void memoization(int[] arr, int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        findByMomization(arr,n, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }


     /* 
     * Time Complexity: O(N)
     * Space Complexity: O(N) + O(N) = (Stack space + Dp array space) 
     */
    private static int findByMomization(int[] arr, int n, int[] dp) {
        if(n <= 0) return 0;
        if(dp[n]!=-1) return dp[n];
        int step1 =  findByRecursion(arr, n-1) + Math.abs(arr[n]-arr[n-1]);
        int step2=Integer.MAX_VALUE;
        if(n>1)
         step2= findByRecursion(arr, n-2) + Math.abs(arr[n]-arr[n-2]);
        dp[n] =Math.min(step1, step2);
        return dp[n];
    }

    private static void recursion(int[] arr, int n) {
        long startTime = System.nanoTime();
        n = findByRecursion(arr,n);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + n);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /* 
    * Time Complexity: O(2^N)
    * Space COmplexity: O(N) - Stack space
    */
    private static int findByRecursion(int[] arr, int n) {
        if(n <= 0) return 0;
        int step1 =  findByRecursion(arr, n-1) + Math.abs(arr[n]-arr[n-1]);
        int step2=Integer.MAX_VALUE;
        if(n>1)
         step2= findByRecursion(arr, n-2) + Math.abs(arr[n]-arr[n-2]);
        return Math.min(step1, step2);
    }
}
