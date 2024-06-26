package math;

/* 
    Rectangle Overlap

    An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

    Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

    Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.

    

    Example 1:

    Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
    Output: true
    Example 2:

    Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
    Output: false
    Example 3:

    Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
    Output: false
    

    Constraints:

    rec1.length == 4
    rec2.length == 4
    -109 <= rec1[i], rec2[i] <= 109
    rec1 and rec2 represent a valid rectangle with a non-zero area.
 */
public class M02RectangleOverlap {
    public static void main(String[] args) {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
        System.out.println("Output: "+ isRectangleOverlap(rec1, rec2));
    }

    /* 
     * rec1: bottom left (x0,y0) and top right (x1,y1)
     * rec2: bottom left (x0,y0) and top right (x1,y1)
     * Observation: when not overlapping
     * if rec2 is below rec1 then rec1.y0 > rec2.y1
     * if rec2 is top of rec1 then rec2.y0 > rec1.y1
     * if rec2 is left of rec1 then rec2.x1 < rec1.x0
     * if rec2 is right of rec1 then rec1.x1 > rec2.x0
     * 
     * TC: O(1)
     * SC: O(1)
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec2[1]>=rec1[3] || rec2[3]<=rec1[1] || rec2[0]>=rec1[2] || rec2[2]<=rec1[0]);
    }
}
