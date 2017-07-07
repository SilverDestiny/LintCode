/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 17-03-05 23:58
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}