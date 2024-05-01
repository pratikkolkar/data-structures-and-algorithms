package arrays;


public class Arrays05LargestNumber {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println(findLargestNum(arr));
    }

    private static int findLargestNum(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxNum=Math.max(maxNum, arr[i]);
        }
        return maxNum;
    }
}
