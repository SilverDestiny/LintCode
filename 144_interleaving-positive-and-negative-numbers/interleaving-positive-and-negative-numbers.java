/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/interleaving-positive-and-negative-numbers
@Language: Java
@Datetime: 17-02-08 22:52
*/

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return;
        }
        boolean sign = false;
        int countm = 0, countp = 0;
        for (int k = 0; k < A.length; k++) {
            if (A[k] < 0) {
                countm++;
            } else {
                countp++;
            }
        }
        sign = countm < countp ? true : false;
        
        int i = 0, j = 0;
        if (sign) {
            i = 1;
        } else {
            j = 1;
        }
        
        while (i < A.length && j < A.length) {
            if (A[i] < 0) {
                i = i + 2;
            } else if (A[j] > 0) {
                j = j + 2;
            } else {
                swap(A, i, j);
                i = i + 2;
                j = j + 2;
            }
        }
    }
   
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}