package arrays;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import utils.Util;

/* 
    Union of Two Sorted Arrays

    Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. Return the elements in sorted order.

    Example 1:

    Input: 
    n = 5, arr1[] = {1, 2, 3, 4, 5}  
    m = 5, arr2 [] = {1, 2, 3, 6, 7}
    Output: 
    1 2 3 4 5 6 7
    Explanation: 
    Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
    Example 2:

    Input: 
    n = 5, arr1[] = {2, 2, 3, 4, 5}  
    m = 5, arr2[] = {1, 1, 2, 3, 4}
    Output: 
    1 2 3 4 5
    Explanation: 
    Distinct elements including both the arrays are: 1 2 3 4 5.
    Example 3:

    Input:
    n = 5, arr1[] = {1, 1, 1, 1, 1}
    m = 5, arr2[] = {2, 2, 2, 2, 2}
    Output: 
    1 2
    Explanation: 
    Distinct elements including both the arrays are: 1 2.
    Your Task: 
    You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays.

    Expected Time Complexity: O(n+m).
    Expected Auxiliary Space: O(n+m).

    Constraints:
    1 <= n, m <= 105
    -109 <= arr1[i], arr2[i] <= 109
 */
public class Arrays12FindUnion {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 6, 7 };
        // betterSolution(arr1,arr2);
        optimalSolution(arr1, arr2);

    }

    /* 
     * Observation:
     * We can use two pointer
     * 
     * TC: O(n + m)
     * SC: O(n + m) for res list
     */
    private static void optimalSolution(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < n && j < m) {

            while (i + 1 < n && arr1[i] == arr1[i + 1])
                i++;
            while (j + 1 < m && arr2[j] == arr2[j + 1])
                j++;

            if (arr1[i] < arr2[j]) {
                res.add(arr1[i++]);
            } else if (arr1[i] > arr2[j]) {
                res.add(arr2[j++]);
            } else {
                res.add(arr1[i++]);
                j++;
            }
        }

        while (i < n) {
            res.add(arr1[i++]);
        }
        while (j < m) {
            res.add(arr2[j++]);
        }
        Util.printIntArray(res);
    }

    /*
     * Observation:
     * We can use set to find union
     * 
     * TC: O(N + M)
     * SC: O(N + M)
     */
    private static void betterSolution(int[] arr1, int[] arr2) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }

        System.out.println("[" + (set.stream().map(i -> "" + i).collect(Collectors.joining(","))) + "]");
    }
}
