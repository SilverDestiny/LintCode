/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-09-15 18:44
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[start] == A[mid]) {
                start++;
            } else if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return true;
        } else if (A[end] == target) {
            return true;
        }
        return false;
    }
}
