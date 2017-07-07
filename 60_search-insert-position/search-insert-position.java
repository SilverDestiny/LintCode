/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 16-09-13 02:51
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (target <= A[start]) {
            return start;
        } else if (target <= A[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}
