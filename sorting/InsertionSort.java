package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 4,5,3,2,1};
        System.out.println(Arrays.toString(inserionSort(arr)));
    }

    private static int[] inserionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if(arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j - 1] = tmp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }
}
