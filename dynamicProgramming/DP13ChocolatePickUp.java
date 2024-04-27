package dynamicProgramming;
/* 
 * 
 * 
 * Not Solved correctly
 * 
 */
public class DP13ChocolatePickUp {
    public static void main(String[] args) {
        int[][] arr={{2, 3, 1, 2},{3, 4, 2, 2},{5, 6, 3, 5}};
        recursion(arr);
    }

    private static void recursion(int[][] arr) {
        long startTime = System.nanoTime();
        int r=arr.length-1;
        int c=arr[0].length-1;
        int max = recursion(arr,0,0,c);
        System.out.println("Output: " + max);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int recursion(int[][] arr, int r, int c1, int c2) {
        if(c1<0 || c2 <0 || c1>arr[0].length-1 || c2 > arr[0].length-1){
            return -1000000;
        }
        int curr = 0;
        if(c1==c2){
            curr = arr[r][c1];
        }{
            curr = arr[r][c1]+arr[r][c2];
        }

        if(r==arr.length-1){
            return curr;
        }

        int max=-1000000;
        max=Math.max(max,curr + recursion(arr, r+1, c1, c2));
        max=Math.max(max,curr + recursion(arr, r+1, c1-1, c2-1));
        max=Math.max(max,curr + recursion(arr, r+1, c1+1, c2+1));
        return max;
    }
}
