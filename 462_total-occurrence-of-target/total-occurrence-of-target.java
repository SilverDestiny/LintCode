/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 16-08-05 16:08
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int first, last;
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first = end;
        } else {
            return 0;
        }
        
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            last = end;
        } else if (A[start] == target) {
            last = start;
        } else {
            return 0;
        }
        
        return last - first + 1;
    }
}