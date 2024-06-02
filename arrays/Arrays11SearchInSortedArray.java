package arrays;

/* 
    Searching an element in a sorted array

    Given an array arr[] sorted in ascending order of size N and an integer K. Check if K is present in the array or not.


    Example 1:

    Input:
    N = 5, K = 6
    arr[] = {1,2,3,4,6}
    Output: 1
    Exlpanation: Since, 6 is present in 
    the array at index 4 (0-based indexing),
    output is 1.
    

    Example 2:

    Input:
    N = 5, K = 2
    arr[] = {1,3,4,5,6}
    Output: -1
    Exlpanation: Since, 2 is not present 
    in the array, output is -1.
    

    Expected Time Complexity: O(Log N)
    Expected Auxiliary Space: O(1)
 */
public class Arrays11SearchInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int K = 8;
        int N = arr.length;
        int out = binarySearch(arr,N,K);
        System.out.println("Output: "+out);
    }

    /* 
     * Use Binary search algorithm as array is sorted
     * 
     * TC: O(logN)
     * SC: O(1)
     */
    private static int binarySearch(int[] arr, int N, int K) {
        int left =0, right = N - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == K){
                return 1;
            }else if(K < arr[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
