package dynamicProgramming;

import java.util.Arrays;

/**
 * DP18PartitionWithGivenDiff
 */
public class DP18PartitionWithGivenDiff {
    // set mod to 10 ^ 9 + 7
    static int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        int[] arr = { 5, 2, 6, 4 };
        int diff = 3;

        // recursion(arr,diff);
        // memoization(arr, diff);
        // tabulation(arr, diff);
        tabulationSpaceOptimized(arr, diff);
    }

    private static void tabulationSpaceOptimized(int[] arr, int diff) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        // Edge case: (sum-diff)/2 should be even
        if (sum < diff || (sum - diff) % 2 != 0) {
            System.out.println("Output: " + 0);
            return;
        }
        int target = (sum - diff) / 2;
        int[] dp = new int[target + 1];

        if (arr[0] == 0) {
            dp[0] = 2;
        } else {
            dp[0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= target)
            dp[arr[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            int[] curr = new int[target + 1];
            for (int tar = 0; tar <= target; tar++) {
                int left = dp[tar];
                int right = 0;
                if (tar >= arr[idx])
                    right = dp[tar - arr[idx]];
                curr[tar] = (left + right) % mod;
            }
            dp = curr;
        }
        System.out.println("Output: " + dp[target]);
    }

    /*
     * TC: O(N * target)
     * SC: O(N * target)
     */
    private static void tabulation(int[] arr, int diff) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        // Edge case: (sum-diff)/2 should be even
        if (sum < diff || (sum - diff) % 2 != 0) {
            System.out.println("Output: " + 0);
            return;
        }
        int target = (sum - diff) / 2;
        int[][] dp = new int[n][target + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= target)
            dp[0][arr[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int tar = 0; tar <= target; tar++) {
                int left = dp[idx - 1][tar];
                int right = 0;
                if (target >= arr[idx])
                    right = dp[idx - 1][tar - arr[idx]];
                dp[idx][tar] = (left + right) % mod;
            }
        }
        System.out.println("Output: " + dp[n - 1][target]);
    }

    private static void memoization(int[] arr, int diff) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        // Edge case: (sum-diff)/2 should be even
        if (sum < diff || (sum - diff) % 2 != 0) {
            System.out.println("Output: " + 0);
            return;
        }
        int target = (sum - diff) / 2;
        int[][] dp = new int[n][target + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        memoization(arr, n - 1, target, dp);
        System.out.println("Output: " + dp[n - 1][target]);
    }

    private static int memoization(int[] arr, int idx, int target, int[][] dp) {
        // Base case:
        if (idx == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || arr[0] == target)
                return 1;
            return 0;
        }

        if (dp[idx][target] != -1)
            return dp[idx][target];

        int left = recursion(arr, idx - 1, target);
        int right = 0;
        if (target >= arr[idx])
            right = recursion(arr, idx - 1, target - arr[idx]);
        dp[idx][target] = (left + right) % mod;
        return dp[idx][target];
    }

    private static void recursion(int[] arr, int diff) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        // Edge case: (sum-diff)/2 should be even
        if (sum < diff || (sum - diff) % 2 != 0) {
            System.out.println("Output: " + 0);
            return;
        }
        int target = (sum - diff) / 2;
        int output = recursion(arr, n - 1, target);
        System.out.println("Output: " + output);
    }

    /*
     * Approach pick and non-pick
     * 
     * For Edge case details check DP17
     * 
     * TC: O(2^n)
     * SC: O(N)+O(N)
     */
    private static int recursion(int[] arr, int idx, int target) {
        // Base case:
        if (idx == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || arr[0] == target)
                return 1;
            return 0;
        }

        int left = recursion(arr, idx - 1, target);
        int right = 0;
        if (target >= arr[idx])
            right = recursion(arr, idx - 1, target - arr[idx]);
        return (left + right) % mod;
    }
}