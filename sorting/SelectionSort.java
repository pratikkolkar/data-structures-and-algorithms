package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    private static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length - 1 - i;
            int maxIndex = fetchMaxIndex(arr, i, lastIndex);
            swap(arr, maxIndex, lastIndex);

        }

        return arr;
    }

    private static void swap(int[] arr, int maxIndex, int lastIndex) {
        int tmp = arr[lastIndex];
        arr[lastIndex] = arr[maxIndex];
        arr[maxIndex] = tmp;
    }

    private static int fetchMaxIndex(int[] arr, int i, int lastIndex) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int j = 0; j <= lastIndex; j++) {
            if (max < arr[j]) {
                max = arr[j];
                index = j;
            }
        }
        return index;
    }
}
