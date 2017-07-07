/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/closest-number-in-sorted-array
@Language: Java
@Datetime: 16-09-14 19:00
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target <= ((A[end] + A[start]) / 2)) {
            return start;
        } else {
            return end;
        }
    }
}