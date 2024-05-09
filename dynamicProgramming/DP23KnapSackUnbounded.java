package dynamicProgramming;



/* 
Knapsack with Duplicate Items

Given a set of N items, each with a weight and a value, represented by the array w and val respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

Example 1:
Input: 
N = 2
W = 3
val = {1, 1}
wt = {2, 1}
Output: 
3
Explanation: 
1.Pick the 2nd element thrice.
2.Total profit = 1 + 1 + 1 = 3. Also the total weight = 1 + 1 + 1  = 3 which is <= 3.

Example 2:

Input: 
N = 4
W = 8
val[] = {6, 1, 7, 7}
wt[] = {1, 3, 4, 5}
Output: 
48
Explanation: 
The optimal choice is to pick the 1st element 8 times.

Expected Time Complexity: O(N*W)
Expected Auxiliary Space: O(W)

Constraints:
1 ≤ N, W ≤ 1000
1 ≤ val[i], wt[i] ≤ 100

 */
public class DP23KnapSackUnbounded {
    public static void main(String[] args) {
        int[] wi = { 1, 2, 4, 5 };
        int[] vi = { 5, 4, 8, 6 };
        int W = 5;
        recursion(wi,vi,W);
        // memoization(wi,vi,W);
        // tabulation(wi,vi,W);
        // tabulationSpaceOptimized(wi,vi,W);
    }

    private static void recursion(int[] wi, int[] vi, int w) {
        int n = wi.length;
        int output = recursion(wi, vi, n - 1, w);
        System.out.println("Output: " + output);
    }

    /*
     * Edge Case: Take value of index 0 if w is less or equal to wi[0]
     * 
     * TC: O(2^n)
     * SC: O(N*W) + O(N)
     */
    private static int recursion(int[] wi, int[] vi, int idx, int w) {
        //Base case
        if(idx == 0){
            return (int)(w/wi[idx])*vi[idx];
        }

        int left = recursion(wi, vi, idx-1, w);
        int right =0;
        if(w>=wi[idx])
            right = recursion(wi, vi, idx, w-wi[idx]);
        return (left+right);

    }
}
