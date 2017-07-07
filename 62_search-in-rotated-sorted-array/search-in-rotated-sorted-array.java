/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 17-03-06 01:26
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > A[start]) {
                if (target >= A[start] && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
