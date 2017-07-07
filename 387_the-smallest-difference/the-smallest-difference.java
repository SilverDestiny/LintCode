/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/the-smallest-difference
@Language: Java
@Datetime: 17-02-11 20:06
*/

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < A.length && j < B.length) {
            min = Math.min(min, Math.abs(A[i] - B[j]));
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
