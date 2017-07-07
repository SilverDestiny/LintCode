/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Java
@Datetime: 17-01-06 18:04
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return;
        }
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            swap(A, i);
        }
    }
    
    private void swap(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2]) {
                son = k * 2 + 2;
            }
            if (A[son] >= A[k]) {
                break;
            }
            
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }
}