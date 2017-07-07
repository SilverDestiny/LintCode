/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 17-02-27 16:28
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        int m = A.length, n = B.length;
        int i = 0, j = 0, index = 0;
        int[] result = new int[m + n];
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                result[index++] = A[i++];
            } else {
                result[index++] = B[j++];
            }
        }
        while (i < m) {
            result[index++] = A[i++];
        }
        while (j < n) {
            result[index++] = B[j++];
        }
        return result;
    }
}