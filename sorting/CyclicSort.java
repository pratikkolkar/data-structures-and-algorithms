package sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr) {
        int index =0;
        while (index < arr.length) {
            int correct = arr[index] - 1;
            if(index != correct){
                swap(arr, correct,index);
            }else{
                index++;
            }
        }
    }

    private static void swap(int[] arr, int correct, int index) {
        int tmp = arr[index];
        arr[index]= arr[correct];
        arr[correct]=tmp;
    }
}
