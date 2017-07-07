/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Java
@Datetime: 16-09-15 15:44
*/

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        if (A == null || A.length == 0 || k > A.length) {
            return A;
        }
        int[] result = new int[k];
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                result[i] = A[end++];
            } else if (end > A.length - 1) {
                result[i] = A[start--];
            } else if (Math.abs(target - A[start]) <= Math.abs(target - A[end])) {
                result[i] = A[start--];
            } else {
                result[i] = A[end++];
            }
        }
        return result;
    }
}