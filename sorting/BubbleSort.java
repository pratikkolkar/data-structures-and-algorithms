package sorting;

import java.util.Arrays;

/**
 * BubbleSort
 * 
 * arr = [5, 4, 3, 2, 1]
 * 
 * Inner loop
 * Step 1: if arr[j] < arr[j - 1] then swap
 * index:  0  1  2  3  4
 * arr:   [5, 4, 3, 2, 1]
 *            j
 *
 * result: [4, 5, 3, 2, 1]
 *                j=2
 * Step2:
 * result: [4, 3, 5, 2, 1]
 *                   j=3
 * Step3:  [4, 3, 2, 5, 1]
 * 
 * 
 * Step4:  [4, 3, 2, 1, 5]
 * 
 * Perform this operation for n number of times where n = size of array
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    private static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            // make swaps
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // if array is already sorted then break
            }
        }
        return arr;
    }
}