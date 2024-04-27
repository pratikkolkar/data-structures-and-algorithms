package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 2, 2, 1 };
        mergeSort(arr, 0 , arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }
        int mid = start +(end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int mix[] = new int[end - start];
        int k = 0;
        int i =start;
        int j = mid;

        while (i<mid && j <end) {
            if( arr[i] < arr[j]){
                mix[k++] = arr[i++];
            }else{
                mix[k++] = arr[j++];
            }
        }

        while(i < mid){
            mix[k++] = arr[i++];
        }
        while(j < end){
            mix[k++] = arr[j++];
        }
        
        for(int index = 0; index<mix.length; index++){
            arr[start+index]=mix[index];
        }
    }

}
