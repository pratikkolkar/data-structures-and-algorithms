package arrays;

/* 
    Problem statement
    You have been given an array ‘a’ of ‘n’ unique non-negative integers.
    Find the second largest and second smallest element from the array.
    Return the two elements (second largest and second smallest) as another array of size 2.

    Example :
    Input: ‘n’ = 5, ‘a’ = [1, 2, 3, 4, 5]
    Output: [4, 2]
 */
public class Arrays06SecondLargetNum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int[] output=fetchSecondNum(arr);
        for (int i : output) {
            System.out.print(i+" ");
        }
    }


    /* 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private static int[] fetchSecondNum(int[] arr) {
        int[] ans = new int[2];
        int largetNum=-1,smallestNum=Integer.MAX_VALUE, secondLargestNum=-1,secondSmallestNumb=Integer.MAX_VALUE;
        for(int num: arr){
            if(num>largetNum){
                secondLargestNum=largetNum;
                largetNum=num;
            }else if(num>secondLargestNum && secondLargestNum<largetNum){
                secondLargestNum=num;
            }

            if(num<smallestNum){
                secondSmallestNumb=smallestNum;
                smallestNum=num;
            }else if(num<secondSmallestNumb && secondSmallestNumb>smallestNum){
                secondSmallestNumb=num;
            }
        }

        ans[0]=secondLargestNum;
        ans[1]=secondSmallestNumb;
        return ans;
    }
}
