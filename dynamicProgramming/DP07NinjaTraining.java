package dynamicProgramming;

import java.util.Arrays;

/* 
 * Problem Statement:
 * Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

    You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

    For Example
    If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
    Detailed explanation ( Input/output format, Notes, Images )
    Constraints:
    1 <= T <= 10
    1 <= N <= 100000.
    1 <= values of POINTS arrays <= 100 .

    Time limit: 1 sec
    Sample Input 1:
    2
    3
    1 2 5 
    3 1 1
    3 3 3
    3
    10 40 70
    20 50 80
    30 60 90
    Sample Output 1:
    11
    210
    Explanation of sample input 1:
    For the first test case,
    One of the answers can be:
    On the first day, Ninja will learn new moves and earn 5 merit points. 
    On the second day, Ninja will do running and earn 3 merit points. 
    On the third day, Ninja will do fighting and earn 3 merit points. 
    The total merit point is 11 which is the maximum. 
    Hence, the answer is 11.

    For the second test case:
    One of the answers can be:
    On the first day, Ninja will learn new moves and earn 70 merit points. 
    On the second day, Ninja will do fighting and earn 50 merit points. 
    On the third day, Ninja will learn new moves and earn 90 merit points. 
    The total merit point is 210 which is the maximum. 
    Hence, the answer is 210.
    Sample Input 2:
    2
    3
    18 11 19
    4 13 7
    1 8 13
    2
    10 50 1
    5 100 11
    Sample Output 2:
    45
    110



    Solution:
    1. Step Convert to index: Will considter Days as index.
                         0  1  2 -> Task number
        Example: Day 0:  2  5 10
                 Day 1: 23  6 23
                 Day 3: 54 23 45

        Recurrence relation: f(day,lastTask)

        Will pass lastTask in paramater so that the task is ignored in the consecutive day.

    2. Do stuff with that index:
        Base case: The recursion will run until 0 index (day)
            if day == 0
                Return the maximum value among the task after ignoring lastTask.
        
        Calculate Maximum among the task ignoring the lasttask
            presentday task + f(day -1, task) - calculate for all the task except last task

        return the maximum value.

 */
public class DP07NinjaTraining {
    public static void main(String[] args) {
        int[][] arr = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
        int days = arr.length;
        int tasks = arr[0].length;
        // recursion(arr, days - 1, tasks);
        // memoization(arr, days, tasks);
        tabulation(arr, days, tasks);
    }

    private static void tabulation(int[][] arr, int days, int tasks) {
        long startTime = System.nanoTime();
        int dp[][] = new int[days][tasks + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        for (int i = 0; i < dp[0].length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i != j) {
                    dp[0][i] = Math.max(dp[0][i], arr[0][j]);
                }
            }
        }

        for (int day = 1; day < arr.length; day++) {
            for (int last = 0; last < dp[0].length; last++) {
                // dp[day][last]=0;
                for (int task = 0; task < arr[0].length; task++) {
                    if (last != task) {
                        dp[day][last] = Math.max(dp[day][last], (arr[day][task] + dp[day - 1][task]));
                    }
                }
            }

        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[days - 1][tasks]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int[][] arr, int days, int tasks) {
        long startTime = System.nanoTime();
        int dp[][] = new int[days][tasks + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        findByMomization(arr, days - 1, tasks, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[days - 1][tasks]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByMomization(int[][] arr, int day, int lastTask, int[][] dp) {
        int maxValue = Integer.MIN_VALUE;
        // Base case: Return max training value if day == 0
        if (day == 0) {
            for (int i = 0; i < arr[0].length; i++) {
                if (i != lastTask) {
                    maxValue = Math.max(maxValue, arr[0][i]);
                }
            }
            return maxValue;
        }
        if (dp[day][lastTask] != -1) {
            return dp[day][lastTask];
        }
        for (int i = 0; i < arr[day].length; i++) {
            if (i != lastTask) {
                maxValue = Math.max(maxValue, (arr[day][i] + findByMomization(arr, day - 1, i, dp)));
            }
        }
        dp[day][lastTask] = maxValue;
        return maxValue;
    }

    private static void recursion(int[][] arr, int days, int tasks) {
        long startTime = System.nanoTime();
        System.out.println("Output: " + findByRecursion(arr, days, tasks));
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByRecursion(int[][] arr, int day, int lastTask) {
        int maxValue = Integer.MIN_VALUE;
        // Base case: Return max training value if day == 0
        if (day == 0) {
            for (int i = 0; i < arr[0].length; i++) {
                if (i != lastTask) {
                    maxValue = Math.max(maxValue, arr[0][i]);
                }
            }
            return maxValue;
        }

        for (int i = 0; i < arr[day].length; i++) {
            if (i != lastTask) {
                maxValue = Math.max(maxValue, (arr[day][i] + findByRecursion(arr, day - 1, i)));
            }
        }
        return maxValue;
    }
}
