/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/kth-smallest-sum-in-two-sorted-arrays
@Language: Java
@Datetime: 17-01-22 01:27
*/

public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int start = A[0] + B[0], end = A[A.length - 1] + B[B.length - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int i = 0, j = B.length - 1;
            int count = 0;
            while (i < A.length && j >= 0) {
                if (A[i] + B[j] > mid) {
                    j--;
                } else {
                    count += j + 1;
                    i++;
                }
            }
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}